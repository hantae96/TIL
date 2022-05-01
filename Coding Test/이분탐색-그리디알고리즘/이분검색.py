N = 8
M = 32

input1 = "23 87 65 12 57 32 99 81"

arr = list(map(int,input1.split()))

arr = sorted(arr)    

print(arr)

def binary_search(arr):
    while arr:
        mid = len(arr)//2
        
        if M == arr[mid]:
            return mid
        elif M > arr[mid]:
            arr = arr[mid+1:]
        else:
            arr = arr[:mid]
            
print(binary_search(arr))

        
    