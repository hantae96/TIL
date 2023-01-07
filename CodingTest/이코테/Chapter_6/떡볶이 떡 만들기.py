import sys
sys.stdin = open("Chapter_6/input.txt")

n,m = map(int,input().split())
length = list(map(int,input().split()))

def check(cut,length):
    result = 0
    for i in length:
        if i-cut > 0:
            result+=i-cut

    return result

max_length = max(length)

while True:
    if check(max_length,length) == m:
        print(max_length)
        break
    max_length-=1

