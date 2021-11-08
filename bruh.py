from urllib.request import urlopen
import hashlib
from termcolor import colored

sha256hash = input("[+] Enter sha256 Hash value: ")

try:
    password_list = str(urlopen('https://raw.githubusercontent.com/danielmiessler/SecLists/master/Passwords/Common-Credentials/10-million-password-list-top-1000000.txt').read(), ‘utf-8’)
    for password in password_list.split('\n'):
        guess = hashlib.sha256(bytes(password,'utf-8')).hexdigest()
        if guess == sha256hash:
            print(colored("[+] The password is: "+str(password),'green'))
            break
        elif hashguess != sha1hash:
            continue
        else:
        print(colored("The password does not matched in the list…", 'red'))
except Exception as exc:
    print('There was a problem: %s' % (exc))
