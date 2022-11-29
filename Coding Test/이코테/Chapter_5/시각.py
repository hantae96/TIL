n = 5

cnt = 0
for i in range(n+1):
    for j in range(61):
        for k in range(61):
            if '3' in str(i) + str(j) + str(k):
                cnt+=1
print(cnt)