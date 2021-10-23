from base64 import b64decode
from typing import Counter, Tuple

occurance_english = {
    'a': 8.2389258,
    'b': 1.5051398,
    'c': 2.8065007,
    'd': 4.2904556,
    'e': 12.813865,
    'f': 2.2476217,
    'g': 2.0327458,
    'h': 6.1476691,
    'i': 6.1476691,
    'j': 0.1543474,
    'k': 0.7787989,
    'l': 4.0604477,
    'm': 2.4271893,
    'n': 6.8084376,
    'o': 7.5731132,
    'p': 1.9459884,
    'q': 0.0958366,
    'r': 6.0397268,
    's': 6.3827211,
    't': 9.1357551,
    'u': 2.7822893,
    'v': 0.9866131,
    'w': 2.3807842,
    'x': 0.1513210,
    'y': 1.9913847,
    'z': 0.0746517
}


def decipher(text: bytes) -> Tuple[bytes, int]:
    original_text, encryption_key, min_fq = None, None, None
    for k in range(256):

        _text = single_byte_xor(text, k)

        _fq = compute_fitting_quotient(_text)

        if min_fq is None or _fq < min_fq:
            encryption_key, original_text, min_fq = k, _text, _fq

    return original_text, encryption_key


def single_byte_xor(text: bytes, key: int) -> bytes:
    return bytes([b ^ key for b in text])


def hamming_distance(bytes1, bytes2):

    assert len(bytes1) == len(bytes2)

    distance = 0
    for zipped_bytes in zip(bytes1, bytes2):

        x = zipped_bytes[0] ^ zipped_bytes[1]

        set_bits = 0
        while (x > 0):

            set_bits += x & 1

            x >>= 1

        distance += set_bits

    return distance


dist_english = list(occurance_english.values())


def compute_fitting_quotient(text: bytes) -> float:
    counter = Counter(text)
    dist_text = [(counter.get(ord(ch), 0) * 100) / len(text)
                 for ch in occurance_english]
    return sum([abs(a - b)
                for a, b in zip(dist_english, dist_text)]) / len(dist_text)


b1 = b'this is a test'
b2 = b'wokka wokka!!!'

assert hamming_distance(b1, b2) == 37


def get_keylength(ciphertext):
    lowest = None
    best_keylength = None

    for keylength in range(2, 41):
        to_average = []

        start = 0
        end = start + keylength
        while (1):

            first_chunk = ciphertext[start:end]
            second_chunk = ciphertext[start + keylength:end + keylength]

            if (len(second_chunk) < keylength):
                break

            distance = hamming_distance(first_chunk, second_chunk)
            """
      "Normalize" the distance. This basically gets it to a decimal
      place that is relative to the total keylength so that it can be
      compared to distances based on other key lengths.
      """
            normalized = distance / keylength

            to_average.append(normalized)

            start = end + keylength
            end = start + keylength

        average = sum(to_average) / len(to_average)
        to_average = []

        if lowest == None or average < lowest:
            lowest = average
            best_keylength = keylength

    return best_keylength


def decrypt(message_bytes, key):
    decrypted = b''

    i = 0
    for byte in message_bytes:

        if (i == len(key)):
            i = 0

        xor = byte ^ ord(key[i])

        decrypted += bytes([xor])

        i += 1

    return decrypted


def transpose_chunks_by_keylength(keylength, ciphertext):

    chunks = dict.fromkeys(range(keylength))

    i = 0
    for octet in data:

        if (i == keylength): i = 0

        if (chunks[i] == None): chunks[i] = []

        chunks[i].append(octet)

        i += 1

    return chunks


def get_key(blocks):
    common = 'ETAOIN SHRDLU'
    key = ''

    for i in blocks:
        current_high_score = 0
        current_key_char = ''

        for j in range(127):

            x = [j ^ the_bytes for the_bytes in blocks[i]]

            b = bytes(x)

            b_str = str(b, 'utf-8')

            score = 0
            for k in b_str.upper():
                if k in common:
                    score += 1

            if score > current_high_score:
                current_high_score = score
                current_key_char = chr(j)

        key += current_key_char

    return key


the_file = open('self_test/xor_key_secrecy/6.txt', 'r')
data = the_file.read()

decoded = b64decode(data)

keylength = get_keylength(decoded)

chunks = transpose_chunks_by_keylength(keylength, decoded)

key = get_key(chunks)

decrypted = decrypt(decoded, key)

print(decrypted)