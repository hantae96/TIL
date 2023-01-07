# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys

for i in range(4):
	i,j = map(int,sys.stdin.readline().split())
	tmp = 0
	if i > j:
		tmp = i
		i = j
		j = tmp
	
	
	max_length = 0
	for num in range(i,j+1):
		cnt = 1
		# 짝수면 맨 끝자리 비트가 무조껀 0
		# 홀수면 맨 끝자리 비트가 무조껀 1
		# 짝수면 11110 & 11001(1) = 중간에 같아도 11001 어처피 1 아님
		# 홀수면 11111 & 11111 -> 11111 
		# 비트연산은 각 해당 자리수 끼리만 비교한다.
		# 그래서 숫자가 아무리 커도 홀수면 무조껀 마지막 비트가 1 짝수면 0이니까
		# 1000000000001 & 1 = 같으면 1 이면 홀수인것이다.
		while(num != 1):
			if (num & 1) == 1:
				num = num * 3 + 1
				cnt+=1
			while (num & 1) != 1:
				num = num >> 1
				cnt +=1
		if max_length < cnt:
			max_length = cnt

	print(f"{i} {j} {max_length}")
