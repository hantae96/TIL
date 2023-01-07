import sys
import copy
sys.stdin = open("input.txt","r")

def count(size):
    size2 = copy.deepcopy(size)
    count = 1
    for i in song_list:
        if size-i>0:
            size=size-i
        else:
            size = size2
            size = size - i
            count+=1

    return count


N,M = map(int,input().split())
song_list = list(map(int,input().split()))
print(N,M)

lt = max(song_list)
rt = sum(song_list)
size = lt

while lt<=rt:
    A=count(size)
    if A == M:
        print(size-1)
        break
    elif A > M:
        lt+=1
        size = lt
    else:
        rt-=1
        size = rt

