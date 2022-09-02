import sys

sys.stdin = open("input.txt","r")
dice_set = []
n = int(input())
for i in range(n):
    dice_set.append(list(map(int,input().split())))

result = []

for dice in dice_set:
    cnt = 0
    same = 0
    for i in range(len(dice)):
        for j in range(i+1,len(dice)):
            if dice[i] != dice[j]:
                cnt+=1
            else :
                same = dice[i]
        if cnt == 0:
            result.append(10000 + 1000*same)
        elif cnt == 1:
            result.append(1000 + 100 *same)
        else :
            result.append(100 * max(dice))

print(result)
print(max(result))