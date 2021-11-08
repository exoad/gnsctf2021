from pwn import *

sh_code = b""

sh_code += asm(f"""
mov rbx, rdi
sub rbx, 1
xor r8, r8
loop:
    add rbx, 1
    cmp r8, 160
    jg end
    inc r8
    {shellcraft.amd64.linux.write(1, 'rbx', 1)}
    cmp byte ptr [rbx], 0x0
    jne loop
end:
    ret
""", arch='amd64', os='linux').ljust(160, b'\0')

sh_code += asm(f"""
mov rbx, rdi
sub rbx, 1
xor r8, r8
loop:
    add rbx, 1
    cmp r8, 160
    jg flush
    inc r8
    {shellcraft.amd64.linux.readn(0, 'rbx', 1)}
    cmp byte ptr [rbx], 0xa
    jne loop
ret
flush:
    push 1
    {shellcraft.amd64.linux.readn(0, 'rsp', 1)}
    pop rcx
    cmp rcx, 0xa
    jne flush
    ret
""", arch='amd64', os='linux').ljust(160, b'\0')

sh_code += asm(f"""
push rdi
push rsi
{shellcraft.amd64.linux.echo("flip (f = forwards, b = backwards)?")}
add rsp, 40
push 1
{shellcraft.amd64.linux.readn(0, 'rsp', 1)}
pop rbx
pop rsi
pop rdi
cmp rbx, 0x62
je backward
forward:
    cmp BYTE PTR [rsi], 9
    jge end
    add DWORD PTR [rdi], 160
    add WORD PTR [rsi], 1
    ret
backward:
    cmp BYTE PTR [rsi], 0
    jle end
    sub DWORD PTR [rdi], 160
    sub WORD PTR [rsi], 1
    ret
end:
    ret
""", arch='amd64', os = 'linux').ljust(160, b'\0')

sh_code = sh_code.ljust(1600, b'\0')

with open('bytecode', 'wb') as f:
    f.write(sh_code)