import sys
sys.stdin = open("/Users/Hantae/Desktop/Programming/TIL/Coding Test/탐색 & 시뮬레이션/input.txt","r")

def check(x,y,bound):
    if (-1 < x < bound) and (-1 < y < bound):
        return True
    else:
        False

def count_value(x,y,bound):
    count = True
    x_list = [-1,1,0,0]
    y_list = [0,0,-1,1]
    for i in range(4):
        if check(x+x_list[i],y+y_list[i],bound):
            if martix[x][y] <= martix[x+x_list[i]][y+y_list[i]]:
                count = False
                break
    if count:
        # 봉우리 확인
        # print(martix[x][y])
        return 1
    else:
        return 0


res = 0
num = int(input())
martix = [list(map(int,input().split( ))) for _ in range(num)]


for i in range(num):
    for j in range(num):
        res+=count_value(i,j,num)

print(res)
