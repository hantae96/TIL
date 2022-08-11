import sys


def check(arr):
        for x in range(len(arr)):
            check_xlist = [0]*10
            check_ylist = [0]*10
            for y in range(len(arr)):
                check_xlist[arr[x][y]]=1
                check_ylist[arr[y][x]]=1
       
            if sum(check_xlist)!=9 or sum(check_ylist)!= 9:
                return False

        for i in range(3):
            for j in range(3):
                check_pan = [0]*10
                for x in range(3):
                    for y in range(3):
                        check_pan[arr[3*i+x][3*j+y]]=1
             
                if sum(check_pan) != 9:
                    return False

        return True


sys.stdin = open("in1.txt","r")
arr = [list(map(int,input().split())) for _ in range(9)]

if check(arr):
    print("YES")
else:
    print("NO")


