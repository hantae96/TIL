import copy

N,M,K = map(int,input().split())
number_list = list(map(int,input().split()))

result = 0

number_list.sort(reverse=True)

i = 0
while M > 0:
    step = copy.deepcopy(K)
    if number_list[i] > number_list[i+1]:
        while step > 0:
            result+=number_list[i]
            step-=1
            M-=1
        result+=number_list[i+1]
        M-=1
    else:
        result += number_list[i]*M
        break

print(result)
            