n = 5
lst = [(172,67),(183,65),(180,70),(170,72),(181,60)]

lst.sort(reverse=True)

tmp = 0
cnt = 0
for x,y in lst:
    if y >= tmp:
        cnt+=1
        tmp = y
        
print(cnt)
