import sys

sys.stdin = open("Coding Test/자료구조(스택,큐,해쉬,힙)/input.txt","r")

total_list = []
for i in range(2):
    num = (int(input()))
    lst = list(map(int,input().split()))
    total_list.append(lst)

ptr1 = 0
ptr2 = 0
result = []


# while ptr1 or ptr2 < :
#     if total_list[0][ptr1] > total_list[1][ptr2]:
#         result.append(total_list[1][ptr2])
#         ptr2+=1
#     else:
#         result.append(total_list[0][ptr1])
#         ptr1+=1
    

# print(ptr1,ptr2)

# if ptr1 <= len(total_list[0])-1:
#     for i in total_list[0][ptr1:]:
#         result.append(i)
# if ptr2 <= len(total_list[1])-1:
#     for i in total_list[1][ptr2:]:
#         result.append(i)

print(result)

