import sys
#sys.stdin=open("input.txt", "r")
n=int(input())
for i in range(1, n+1):
    str=input()
    str=str.upper()
    for j in range(len(str)//2):
        if str[j]!=str[-1-j]:
            print("#%d NO" %i)
            break
    else:
        print("#%d YES" %i)




<다른코드>

import sys
sys.stdin=open("input.txt", "r")
n=int(input())
for i in range(n):
    str=input()
    str=str.upper()
    if str==str[::-1]:
        print("#%d YES" %i)
    else:
        print("#%d NO" %i)