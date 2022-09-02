num = int(input())
check_list = [0 for i in range(num+1)]
result = []

for i in range(2,num+1):
    if check_list[i] == 0:
        result.append(i)
        j = 1
        while(i * j <=20):
            check_list[i*j] = 1
            j+=1

print(len(result))