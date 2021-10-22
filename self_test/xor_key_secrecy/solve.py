from base64 import b64decode

def hamming_distance(bytes1, bytes2):
  # The strings must be equal length or this will fail.
  assert len(bytes1) == len(bytes2)

  distance = 0
  for zipped_bytes in zip(bytes1, bytes2):
    # XOR a bit from bytes1 with the corresponding bit in bytes2
    x = zipped_bytes[0] ^ zipped_bytes[1]

    set_bits = 0
    while (x > 0):
      # Check if the right most bit is set. If it is then track it.
      set_bits += x & 1;

      # Right shift the bits so we can check the next one in line.
      x >>= 1; 

    # Add the number of set bits for the current chars to the total
    # distance
    distance += set_bits

  return distance


b1 = b'this is a test'
b2 = b'wokka wokka!!!'

assert hamming_distance(b1, b2) == 37

def get_keylength(ciphertext):
  lowest = None
  best_keylength = None

  for keylength in range(2, 41):
    to_average = []

    # Define the starting and ending points for the first chunk
    start = 0
    end = start + keylength
    while (1):
      # Grab 2 adjacent chunks of data that are KEYLENGTH long.
      first_chunk = ciphertext[start:end]
      second_chunk = ciphertext[start + keylength:end + keylength]

      # Check if we're at the end of ciphertext. We can ignore the
      # dangling bit.
      if (len(second_chunk) < keylength):
          break

      # Find the distance between these two KEYLENGTH chunks
      distance = hamming_distance(first_chunk, second_chunk)

      """
      "Normalize" the distance. This basically gets it to a decimal
      place that is relative to the total keylength so that it can be
      compared to distances based on other key lengths.
      """
      normalized = distance / keylength

      # We've got a score append it to the list of distances we want
      # the average of.
      to_average.append(normalized)

      # Move on to the next chunk that we'll want to get hamming
      # distances for.
      start = end + keylength
      end = start + keylength

    # Find the average of those distances and then empty out the array
    # for the next iteration.
    average = sum(to_average) / len(to_average)
    to_average = []

    # Check if we've beat the current lowest score. If we have that's
    # more likely the correct key length.
    if lowest == None or average < lowest:
      lowest = average
      best_keylength = keylength

  return best_keylength

def decrypt(message_bytes, key):
  decrypted = b''

  i = 0
  for byte in message_bytes:
    # Go back to the beginning of the key if we've reached it's length.
    # This handles the "repeating" bit of the key.
    if (i == len(key)):
      i = 0

    # Convert the key char to a number so it can be XOR'd
    xor = byte ^ ord(key[i])
    
    # Convert the xor'd value back to bytes... bytes(...) requires an
    # array as an argument, hence the [...]
    decrypted += bytes([xor])

    i += 1

  return decrypted

def transpose_chunks_by_keylength(keylength, ciphertext):
  # Create a dictionary for the number of chunks that the data can be
  # broken into.
  chunks = dict.fromkeys(range(keylength))

  i = 0
  for octet in data:
    # If we're at the end of the key start at the beginning again. This
    # is "repeating key" XOR after all.
    if (i == keylength): i = 0

    # If the chunk is null, initialize it to an empty array.
    if (chunks[i] == None): chunks[i] = []

    # Append the current octet to the chunk.
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
      # Create an array of all the XOR'd
      x = [j ^ the_bytes for the_bytes in blocks[i]]
            
      # Convert the array of numbers back into bytes
      b = bytes(x)

      # Convert to a string so we can compare it to the common
      # letters.
      b_str = str(b, 'utf-8')

      # Increase the score for everywhere there is overlap
      score = 0
      for k in b_str.upper():
          if k in common:
              score += 1

      # If this score is better for this char, keep it
      if score > current_high_score:
        current_high_score = score
        current_key_char = chr(j)

    key += current_key_char

  return key


the_file = open('self_test/xor_key_secrecy/6.txt', 'r')
data = the_file.read()

# We know the file is base64 encoded so decode it first, this converts it
# to raw bytes.
decoded = b64decode(data)

# First we need to take a stab at finding the key length.
keylength = get_keylength(decoded)

# Once we have a good key length transpose the chunks
chunks = transpose_chunks_by_keylength(keylength, decoded)

# Get the key from the transposed chunks
key = get_key(chunks)

# Decrypt the ciphertext
decrypted = decrypt(decoded, key)

# Find out what it is!
print(decrypted)