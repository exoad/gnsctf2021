import math

def hamming_distance_bytes(text1: bytes, text2: bytes) -> int:
    dist = 0
    for byte1, byte2 in zip(text1, text2):
        dist += bin(byte1 ^ byte2).count('1')
    return dist
    
def hamming_score_bytes(text1: bytes, text2: bytes) -> float:
    return hamming_distance_bytes(text1, text2) / (8 * min(len(text1), len(text2)))

def compute_key_length(text: bytes) -> int:
    min_score, key_len = None, None
    for klen in range(2, math.ceil(len(text)/2)):
        chunks = [
            text[i: i+klen]
            for i in range(0, len(text), klen)
        ]
        if len(chunks) >= 2 and len(chunks[-1]) <= len(chunks[-2])/2:
            chunks.pop()
        _scores = []
        for i in range(0, len(chunks) - 1, 1):
            for j in range(i+1, len(chunks), 1):
                score = hamming_score_bytes(chunks[i], chunks[j])
                _scores.append(score)
        score = sum(_scores) / len(_scores)
        if min_score is None or score < min_score:
            min_score, key_len = score, klen
    return key_len
    
print(compute_key_length(bytes("0901073031250910075d300740061600562b055c0d463a131e5009", 'utf-8')))
