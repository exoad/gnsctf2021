# NOTES ON ALL OF THE PROBLEMS THAT ARE UNSOLVED 
Check [Solutions.md](./SOLUTIONS_DOCUMENTATION.md) for all of the solved ones and their documented solutions

# Ceasura of Despair

```openssl aes-256-cbc -d -pbkdf2 -in out.enc -out result_out.txt```

# Tupperware
-Helpful tool? [Click Here](https://keelyhill.github.io/tuppers-formula/?preset=2OIMOPbfPBtCWYiWCKUaVjTaOqPtXpgV71I3PVdTAZbhRx78PCNdh5AoY0XnpouotnfRckvX7JRC0vzo2I9A0QOU4TxpX1VemYtCZiWKmrUcj2mMUn3r3912bm6OfhNRLq34UbwDfMdRBVrNDl3rL8zqgVz0RiUIkZJanhsNfZW49SD04tE62VqEaAsjUzQeAJdrSRd9zFnVdru7ovJcOqx64wtUPX6tgJUIm5VdAVU6CxfbQEDqRc7sJeWp1A6szlitOhgsTD8a6ONYZsUCujbbUXoNsat9fGXvSvaiQ5x9AKz)

# Violet

```
0:10 TOP: a monologue, MIDDLE: "403.", BOTTOM: hatred stirs up dissention, but love covers over all wrongs (Proverbs 10:12)

0:32 TOP: a monologue, MIDDLE: "520" (no period), BOTTOM: but he knows the way that I take; when he has tested me, I will come forth as gold (Job 23:10)

1:14 TOP: a monologue, MIDDLE: "913.", BOTTOM: come to me all you who are weary and burdened and I will give you rest (Matthew 11:28)

1:37 TOP: Beliefs, MIDDLE: "1016.", BOTTOM: and now these three remain: faith, hope, and love but the greatest of these is love (1 Corinthians 13:13)

2:43 TOP: a monologue, MIDDLE: "1129.", BOTTOM: for we brought nothing into the world and we can take nothing out of it. (1 Timothy 6:7)
```

# RiSuAyunda
-answer sequence: `y` `y` `31415926535900024685333724635123260888029162081305437033832795028841` `n` `y` 

-Stuck On: finding the ciphertext using the following:

n: `22409902333678780634396349171704874375996011264748935370870001103378796405764583554160902218250028718866407072599288925777830094854098783144112829605926701890563594390880123408640544183138795257118320438217784898175209219145924671131478263565292619847283372559317203108765938560657693521080902789733484857516506094749406101588558894585946990157947819769843020908790689153089503020787264275986808655454784152699927238904358404825275899856294390104357819299858264494871614654576558638200696100726844539194077580911010240662216110858208629015407745368880794560020963689048498514495548492584344163974901799588780045024061`

e: `65537`

plaintext: `7508877384402416653085955384220958443375619030239966576`

cipher? `7508877384402416653085955384220958443375619030239966576`

# Crappy Bird Extension
-the letter separators of `ABCDEF` can appear in any order

-value B is where the value assembly happens 

-here are some more stuffs:

`D000A00000B7530F000C000E000` - coin value of 3

`D000A20000B0EA60F000C000E000` - coin value of 26

`D000A50000B0EA60F000C000E000` - coin value of 56 (does this mean A holds the value of the tenth place?) =>

`D000A50000BFEA60F900C000E000` - coin value of 51 (hmmm) 

`D000A50000B4EA60F000C000E000` - coin value of 53 (hmmm) 

`D001A50000BDEA60F000C000E000` - coin value of 59 (bruh)

`D001A90000BDEA60F000C000E000` - coin value of 99 (wow)

# Fake image
-pull and run the docker image

Stuck On: ?

# Quiet and falling
-use your inspector and select the element representing the "..." and there
should be an image source tag attached with a mp3 file
  
Stuck On: understanding what this mp3 file actually does

# pwner
-try the `solve_pwner` shell script to auto this action (probably not very efficient or might not work at all)

# ez
-due to "gets()" not being able to control buffer size, it should be assumed
this problem asking on how to think of a way to trick this program without
crashing it (core dump)
  
-actual plan, to use gdb and then we overflow onto the next memory location (which should be the "correct" password is held):

`python -c "print("\x29")*30" | nc gnsctf.ml 4020`

-`ezpzlemonsqu` is the furthest you could without core dump  
  
Stuck On: Basic Logic down, just gotta actually figure out how to do this

# xor key secrecy
-the key length is unknown

-closest decode is the phrase `notsecr`

-legit just bruteforcing the key with some guessing

-the presented cipher is the flag not the key

-probable code:
```python
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
```
  
**Basic Process** First find the length of the ciphertext (in hex) using the hamming distance and then bruteforce it  

Key length should be 24 (bytes)
  
Stuck On: How to bruteforce the key

Key tries:
![](images/41C73761-7A42-4EAE-BC04-CF29801C62D8.jpeg)
  
  
# CDN++
-inject php code?

-look at the bot.py and server.py files

Stuck On: What?

# My World
-does not involve actually loading world into Minecraft
  
-due to the hint being "built somewhere" it should be noted that it should be found
within the folder region or something not sure

# Monochrome Butterfly
-the blocks are in binary (most likely)
  
Stuck On (#1): Is colored = 0 & no color = 1 or the other way?
  
Stuck On (#2): What does the hint mean of R0G5B0? Invertting the colors does not give
you this super dark green color

# SpellingC
-use libc to understand the interactions
  
-use gdb

# shashasha
-change the flag in order to match that of the `output.txt`

