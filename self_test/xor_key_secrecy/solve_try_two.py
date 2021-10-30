# a second promising script

#!/usr/bin/env python2.7

key = raw_input()
ciphertext = raw_input()
assert len(ciphertext) % 2 == 0

key = map(ord, key)

plaintext = []
ki = 0
for i in xrange(0, len(ciphertext), 2) :
  x = int(ciphertext[i:i+2], 16)
  k - key[ki % len(key)]
  x = x ^ k
  plaintext.append(x)
  ki += 1
  
plaintext = map(chr, plaintext)
print "".join(plaintext) # if this is run using python3 u might need to change this to print("".join(plaintext))
          
           
           
