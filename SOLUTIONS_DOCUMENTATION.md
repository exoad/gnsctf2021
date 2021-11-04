# My World
-solved

Solution:
-I used a Overhead Minecraft World Renderer [here](https://github.com/Jupisoft111/Minecraft-Overworld-Viewer/releases)
Then I inputted the world file, to get an anomaly in one of the rendered maps:
![](./assets/r.4167.27747.png)

This image in the renderer lead us with coordinates (X,Z): 2133779, 14206976

Then I just teleported there to get:
![](./assets/map.png)

# Quiet & Falling
-solved

Solution:
-Find the original recording of this song on YouTube: [here](https://www.youtube.com/watch?v=l4FXoiD2EvI)

-In the comments:
![](./assets/comment.png)

-The text is: `good
nice
serenity
Calming
Terrific
Fun
{
i
talk
'
see
_
quiet
utopia
intent
everything
tranquil
_
dark
only
wonder
now
_
happiness
ecstatic
real
euphoria
}`

Taking the first letter of each word gives us: `gnsCTF{it's_quiet_down_here}`

# Monochrome Butterfly
-solved

Solution: This was based on Image Stego. Using [this](./apps/stegsolve.jar) we can alter between the colors and color phases to reveal 
a QR code:
![](./assets/butterfly_qr.png)

which when scanned gave us the flag `gnsCTF{h1dd3n_b3tw33n_th3_b1t_pl4n3s}`

# bookface
-solved

Solution: The common web vulnerability was SQL injections which was proved using the injection code of `' or 1=1--` in the password and `admin` for the username. 
This gave us the account access. Which lead us to having the flag of: `gnsCTF{g3t_y0ur_f4c3_0ut_0f_th4t_b00k}`

# Caesura of Despair
-solved

-Solution: The main logic behind it was AES-256-CBC then DES-CBC using openssl (ignore the key derivation used):
```sh
openssl enc -aes-256-cbc -d -salt -in out.enc -out aes.enc -k IRyS

openssl enc -des-cbc -d -salt -in aes.enc -out des.enc -k IRyS
```

getting you the flag of `gnsCTF{d4rkn355_w1ll_f4d3_away_l1ght_w1ll_gu1d3_y0ur_w4y_h0p3_has_descended_and_y0u_are_n0t_al0ne}`

# Tupperware
-solved

Solution: Using the tupper formula, the K value was 
```
7046890806098227958824054035841669579252352373335454688743471323715958682884806244376479723439842411579064508832628408698462207683934029532582388131788110558420326452978938838675781531228566552636252716563201575589499370667467698703660636438713073914155788343459356200698490322930824955282271084327902839457280763892984863984854550620580637272598756700104647089236958308306470745024706826229543234249866440918133382593304731408315133524629092211728447125964550787892317644208636872320053045839269843744148497353297332480357926908259546808320
```
Then using [this](https://github.com/spalaciob/tupper-self-ref-formula) we can then get the flag of:
![](./assets/unknown.png)


# fakeimage
-solved

Solution: This was basically I got lucky and spotted a "sus" file which was `etc/apt/sources.list.d/fsfsfs.list` which I knew was not really part
of anything, and when I opened it: 
```

                      _______________________________  ___     .__________          __    ________                 ____                    ________   ___  
   ____   ____   _____\_   ___ \__    ___/\_   _____/ / /    __| _/\   _  \   ____ |  | __\_____  \______    _____/_   | _____   ______    \_____  \   \ \ 
  / ___\ /    \ /  ___/    \  \/ |    |    |    __)   \ \   / __ | /  /_\  \_/ ___\|  |/ /  _(__  <_  __ \  /  ___/|   |/     \ /  ___/      _(__  <   / / 
 / /_/  >   |  \\___ \\     \____|    |    |     \    < <  / /_/ | \  \_/   \  \___|    <  /       \  | \/  \___ \ |   |  Y Y  \\___ \      /       \  > > 
 \___  /|___|  /____  >\______  /|____|    \___  /    / /  \____ |  \_____  /\___  >__|_ \/______  /__|____/____  >|___|__|_|  /____  >____/______  /  \ \ 
/_____/      \/     \/        \/               \/     \_\_      \/        \/     \/     \/       \/  /_____/    \/           \/     \/_____/      \/  _/_/ 
```

which translates to gnsCTF{d0ck3r_s1ms_3}

# Who's that pokemon
-solved

Exploit: Just literally put your cursor over the gif and you could then see the link embedded as the name of the pokemon

# Encyclopedic Knowledge
-solved

Solution: Go to Great Neck South wikipedia page, then go to view histiry and see the edit made by user "GnsCtf2" then scroll down to
find part 1, then go back to the contribs of GnsCtf2 to view other parts to get `gnsCTF{w1k1_15_4_b4d_50urc3}`

# Noot's Flat Earth Tavern
-solved

Solution: Using burpsuite, you basically get Noot's token from one of his messages, then when you are using the `/flag` command, 
replace your token with Noot's token to get gnsCTF{wh4t5_th3_d34l_w1th_s0ck3t10}

# Hackletric Eye
-solved

Solution: The flag is embedded within the file

# Dault Voor Electric Eye
-solved

Solution: Wrote a script that first convertted the bytes back to integer and then moved them to the left (shift)
After this script began to take on meaning, there was comment on the following:
```// My electric eye broke and messed up the bit arrangements... SAD!```
which further confirmed 

# SuperFPG
-solved

Exploit: Since the source code for the player object was posted, the object was titled "Player" this could then gives the following abilities:

`unityInstance.SendMessage("Player", "SetMoves", 999999)`

Then we lure the final guy and we use the above command to finally get the flag of go0d_g8m3_4e5ign

# Crappy Bird
-solved (i thought it was code injection lmao)

Solution: Go to the shope and import data, change the import data to like `9999999999999999999` and then import, this will change the coin count. Once you click play
the flag will appear but you must be quick to take a screenshot of it of `50ON_7O_B3_R3MOV3D`

# Noisy Transmission
-solved

Solution: Look through the `noisy.wav` file through an app like sonic visualizer and then short beams are `.` and longer ones are `_` then put that through a morse to 
text translator to get:
`th1sfl4g1sl0st1nsp4c3`

# DaultVoor2
-solved

Solution: Basically just reading the if statements backwards and transcribing the final backwards (rev)

# ArrSa
-solved

Solution: Integer Factorization 

# Disco Trump
-solved

Solution: Use NATO Phoentic Alphabet 

# Electric Nonsense
-solved

Solution: Vignere Cipher

# next color planet
-solved

Solution: Use an online XOR decoder and stuff


