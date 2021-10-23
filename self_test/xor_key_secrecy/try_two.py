cypher = bytes.fromhex(
    '0901073031250910075d300740061600562b055c0d463a131e5009')
plaintext = b'6c3129101152930277d10276026362076b257c2d661a33'

key = ''.join(chr(m ^c) for c, m in zip(cypher, plaintext))

print(key)