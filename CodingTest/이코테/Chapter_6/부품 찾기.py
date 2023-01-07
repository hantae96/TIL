import sys


def bin_search(array,target):
    start = 0
    end = len(array)-1
    while start <= end:
        mid = (start+end)//2
        if array[mid] == target:
            return mid
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid +1
    return None
            


sys.stdin = open("Chapter_6/input.txt")

n = int(input())
part = sorted(list(map(int,input().split())))

m = int(input())
search = list(map(int,input().split()))

result = []
for i in search:
    result.append(bin_search(part,i))

print(result)