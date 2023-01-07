import copy

N,M,K = map(int,input().split())
number_list = list(map(int,input().split()))

result = 0

number_list.sort(reverse=True)
first = number_list[0]
secend = number_list[1]

count = int(M/(K+1))*K
count += M%(K+1)

print(result)
            