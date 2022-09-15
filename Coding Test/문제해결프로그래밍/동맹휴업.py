import sys
sys.stdin = open("/Users/Hantae/Desktop/Programming/TIL/Coding Test/문제해결프로그래밍/input.txt","r")

n = int(input())

for i in range(n):
    days = int(input())+1
    day_list = [0 for i in range(days)]
    hartal_parameter = []
    
    company_count = int(input())

    for i in range(company_count):
        hartal_parameter.append(int(input()))
    
    for i in hartal_parameter:
        for j in range(i,days,i):
            day_list[j-1] = 1
    
    for i in range(len(day_list)):
        if (i*7)+5 < len(day_list):
            day_list[(i*7)+5] = 0
        if (i*7)+6 < len(day_list):
            day_list[(i*7)+6] = 0

    print(sum(day_list))
		