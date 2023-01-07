import sys

sys.stdin = open("Coding Test/자료구조(스택,큐,해쉬,힙)/input.txt","r")

N = int(input())

pan = []

for i in range(N):
    pan.append(list(map(int,input().split())))

sum_list = []

for i in range(len(pan)):
    for j in range(len(pan[i])):
        target = pan[i][j]
        sum_list.append(sum(pan[i]))
        sum_list.append(sum(pan[:][j]))
        
        sum = 0
        x = i
        y = j
        while x or y != 1:
            x -=1
            y -=1
        # 음의 대각선 일때
        while x or y != N:
            sum += pan[x][y]
            x+=1
            y+=1
        sum_list.append(sum)
        sum = 0
        # 양의 대각선
        while x or y != N:
            x +=1
            y +=1
        while x or y != N:
            sum += pan[x][y]
            x+=1
            y-=1
        sum_list.append(sum)
            

print(sum_list)


