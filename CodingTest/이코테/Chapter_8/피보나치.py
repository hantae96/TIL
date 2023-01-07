# def fibo(number):
#     if number == 1 or number == 2:
#         return 1
#     else:        
#         return fibo(number-1) + fibo(number-2)

# print(fibo(4))

# dp_table = [0]*101

# def dp_fibo(number):
#     if number == 1 or number == 2:
#         return 1
#     if dp_table[number] != 0:
#         return dp_table[number]
#     dp_table[number] = dp_fibo(number-1) + dp_fibo(number-2)
#     return dp_table[number]

# print(dp_fibo(10))

d = [0]*100
d[1] = 1
d[2] = 1
n = 99

for i in range(3,n+1):
    d[i] = d[i-1] + d[i-2]

print(d[n])

        