enc_hex = "0901073031250910075d300740061600562b055c0d463a131e5009".replace('\n' , '')

enc_ascii = enc_hex.decode('hex')

enc_numbers = [ord(ch) for ch in enc_ascii]
