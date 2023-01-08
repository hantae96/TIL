from itertools import combinations


test = ['a','b','c']
for i in range(len(test)):
    print(list(combinations(test,i)))