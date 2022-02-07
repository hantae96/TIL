N = 8
M = 32

lst = "23 87 65 12 57 32 99 81"

lst = list(map(int,lst.split()))

lst.sort(reverse=False)
print(lst)

left = 0
right = len(lst)-1

# left가 right 보다 크면 탐색을 전부 완료한 것
while left<=right:
    mid = (left+right)//2
    
    if 32 < lst[mid]:
        right = mid-1
    
    if 32 > lst[mid]:
        left = mid+1
        
    
# 원하는 조건을 최상단에
    if 32 == lst[mid]:
        print(mid+1)
        break
    
    
    
import sys
sys.stdin = open("input.txt","r")
n,m = map(int,input().split())
a = list(map(int,input().split()))
a.sort()
lt = 0
rt = n-1
while lt <=rt:
    mid = (lt+rt)//2
    if a[mid] == m:
        print(mid+1)
        break
    elif a[mid]>m:
        rt = mid-1
    else:
        lt = mid+1