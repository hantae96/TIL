import sys
sys.stdin = open("input.txt","r")

def count(lan,lan_list):
    cnt = 0
    for i in lan_list:
        cnt+=i//lan
    return cnt

K,N = map(int,input().split())
lan_list = []
for i in range(K):
    lan_list.append(int(input()))

rt = max(lan_list)
lt = 1
# 이분 탐색 투 포인터(왼쪽 포인터 오른쪽 포인터로 푼다.)

lan = rt
while lt<=rt:
    cnt=count(lan,lan_list)
    if cnt >= N:
        rt-=1
        lan = rt
    else:
        lt+=1
        lan = lt
print(lan)