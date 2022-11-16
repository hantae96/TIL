test_case = "edeaaabbccd"
test_case = list(test_case)

previous = 0
current = 0

hash = {}

for i in range(len(test_case)):
    if i == 0:
        hash[test_case[i]] = 1
    else:
        if test_case[i-1] != test_case[i]:
            if( test_case[i] not in hash):
                hash[test_case[i]] =1
            else:
                hash[test_case[i]] +=1

print(hash)
