import sys

sys.stdin = open("/Users/Hantae/Desktop/Programming/TIL/Coding Test/이분탐색-그리디알고리즘/input.txt","r")

def binary_search(M,num_list):
    while True:
        mid = len(num_list)//2
        if num_list[mid][1] == M:
            return num_list[mid][0]+1
        elif num_list[mid][1] < M:
            num_list = num_list[mid+1:]
        else:
            num_list = num_list[:mid]

N,M = map(int,input().split())
num_list = list(map(int,input().split()))
num_list.sort()
for idx,val in enumerate(num_list):
    num_list[idx] = (idx,val)


print(binary_search(M,num_list))

