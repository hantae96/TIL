import sys
sys.stdin = open("input.txt")

result = []
n = int(sys.stdin.readline())
number = [int(sys.stdin.readline()) for i in range(n)]
stack = []

i = 1
j = 0

for i in range(n):
    num = int(input())
    while cur
