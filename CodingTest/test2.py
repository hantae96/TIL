import copy

test = []

for i in range(10):
    tmp = ["A"]*10
    tmp[i] = "B"
    for j in range(i+1,10):
        tmp[j] = "B"
        tmp2 = tmp.copy()
        test.append(tmp2)
        tmp[j]= "A"

for i in range(len(test)):
    test[i] = ''.join(test[i])

print(sorted(test)[24])

