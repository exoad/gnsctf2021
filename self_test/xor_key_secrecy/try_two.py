cypher = bytes.fromhex(
    '0901073031250910075d300740061600562b055c0d463a131e5009')
plaintext = b'gnsctf{flag format}'

key = ''.join(chr(m ^c) for c, m in zip(cypher, plaintext))

print(key)