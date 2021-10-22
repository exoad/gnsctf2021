#!/usr/bin/python2.7

import hashlib

f = open("flag.txt", "r")
flag = f.read()
enc_flag = hashlib.sha256(flag).hexdigest()

def login():
    print("input flag: ")
    data = raw_input()
    enc = hashlib.sha256(data).hexdigest()
    
    if enc == enc_flag:
        print("CORRECT!")
    else:
        print("INCORRECT")

def flag():
    print("The SHA256 hash of flag is: %s" % enc_flag)

def exit():
    quit()

while True:
    menu = "\nChoose from menu>\n1) login\n2) flag\n3) leave\n"
    print(menu)
    option = input()
    if(option == 1):
        login()
    elif(option == 2):
        flag()
    else:
        exit()