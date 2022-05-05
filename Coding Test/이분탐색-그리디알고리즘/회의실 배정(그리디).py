
import sys

sys.stdin = open("C:/Users/MIS/Desktop/MIS/TIL-/Coding Test/이분탐색-그리디알고리즘/input.txt","r")
n = int(input())
arr = [list(map(int,input().split())) for _ in range(n)]

arr.sort(key = lambda x : x[1])

cnt = 0
endtime = 0

for start,end in arr:
    if start>= endtime:
        cnt+=1
        endtime =end

print(cnt)



# for i in range(len(arr)):
#     cnt = 1
#     endtime=arr[i][1]
#     for j in range(i,len(arr)):
#         startime = arr[j][0]
#         if startime == endtime:
#             cnt += 1
#             endtime= arr[j][1]
    
#     lst.append(cnt)
# print(lst)
# print(max(lst))
    
            
        
    