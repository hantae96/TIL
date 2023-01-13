import sys

sys.stdin = open("/Users/Hantae/Desktop/Dev/TIL/CodingTest/baeekingDog/연결리스트/input.txt")

string1 = list(input())
string2 = []
n = int(input())


for i in range(n):
    command = input().split()
    if command[0] == 'L':
        if string1:
            string2.append(string1.pop())


