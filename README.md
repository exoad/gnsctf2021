# NOTES ON ALL OF THE PROBLEMS THAT ARE UNSOLVED 
Check [Solutions.md](./SOLUTIONS_DOCUMENTATION.md) for all of the solved ones and their documented solutions

# pitch perfect
```
G#3
G3
A3

D3
A3
G3

F3
G3
G3

C3
F3
A#3

A#3
D#3
A3

D3
E3
C#3

G#3
D#3
E3

D#3
G3
B3

A3
G3
E3

C3
A3
D3

G#3
G3
G3

B3
G#3
E3

E3
C#3
G#3

E3
G3
B3

A#3
C#3
E3

C3
A3
A3

G3
B3
A3

G#3
A3
F#3

E3
E3
A3

D3
A3
G3

G#3
D#3
A3

F#3
E3
C#3

G#3
D3
E3

D#3
G3
B3

E3
C#3
A3

G#3
A#3
F3
```

Using the frequency of each base note [here](https://theonlinemetronome.com/instrument-tuner), convert them to octal?

# Violet

```
0:10 TOP: a monologue, MIDDLE: "403.", BOTTOM: hatred stirs up dissention, but love covers over all wrongs (Proverbs 10:12)

0:32 TOP: a monologue, MIDDLE: "520" (no period), BOTTOM: but he knows the way that I take; when he has tested me, I will come forth as gold (Job 23:10)

1:14 TOP: a monologue, MIDDLE: "913.", BOTTOM: come to me all you who are weary and burdened and I will give you rest (Matthew 11:28)

1:37 TOP: Beliefs, MIDDLE: "1016.", BOTTOM: and now these three remain: faith, hope, and love but the greatest of these is love (1 Corinthians 13:13)

2:43 TOP: a monologue, MIDDLE: "1129.", BOTTOM: for we brought nothing into the world and we can take nothing out of it. (1 Timothy 6:7)
```

# RiSuAyunda
-answer sequence: `y` | `y` | `31415926535900024685333724635123260888029162081305437033832795028841` | `n` | `y` | `1879192356672253348435765130293352140927781989531481020198546673766426345654011142567837860979525556598757017604728576540647160364587937140263195801545243832809439986532645022057677037910762855325717338581677245387222365851270247202736126599755161321078000206514648543999372922638980374879198040944726993835915237830362427534098786868068100744257865512097199512827926093539210499171426929430381291365207821418816354830788959819939631962268332004243217577857687822392885281354431964523963330286071274566946102491050044852096700865263007628239533169200882797719953955616673579243204805635237794198308486763105365474997` | `y` | `31415926535900024685333724635091844960493264148920744000000000000000` | `y` | `785398163397500617133343115877296124012331603723018600000000000000` | `n` | `y` | `3232897777038406266809592798631059322029606001229363710024725352577854198670998904631189252215464493683300207026412212166661498570243937702916135122285640218873819417559182244640310435013591402695044945345835899107336551297971295653028994962815799843540910414911645281166784657853398284862892647291380938788576630778132151111942103926329576760985179775987116677699452565601345423430775397643292386891991944744282317689222036439405224134526269032825069972396656114618447305459102495077602260474400530762113449248385735074963541396046901963158302829896464863142513388082190462596958309547021229134680788772469064588935` | `y` | `1917483488766730872524699717680578039998465659855612966766` | `y` |

-Stuck On: Finding d value given n, e, and p

**Notes**

-encoding is done by the formula ![](./assets/index.png)

where ![](./assets/variable_M.png) is our final encoded message

where ![](./assets/variable_lower_m.png) is our message for encoding

where ![](./assets/variable_lower_e.png) is our public key

where ![](./assets/variable_N.png) is a modulus which is the value of ![](./assets/variable_lower_p.png) multiplied by ![](./assets/variable_lower_q.png)

TOTIENT FUNCTION: `φ(n)=(p−1)(q−1)=pq−p−q+1=(n+1)−(p+q)` refer to [this](https://crypto.stackexchange.com/questions/5791/why-is-it-important-that-phin-is-kept-a-secret-in-rsa)

CARMICHAEL FUNCTION: `λ(n)=LCM(p−1, q−1)` refer to [this](https://math.stackexchange.com/questions/509436/using-carmichael-function-in-rsa) 

EXTENDED EUCLIDEAN: [reference](https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm)

DECODING EXPONENT: `d = e^-1 mod carmichael`

GOOD PAPER [HERE](https://math.asu.edu/sites/default/files/rsa_0.pdf)

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
  
# CDN++
-inject php code?

-look at the bot.py and server.py files

Stuck On: What?

# SpellingC
-use libc to understand the interactions
  
-use gdb

# shashasha
-change the flag in order to match that of the `output.txt`

