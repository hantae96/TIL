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
		while(num != 1):
			if (num & 1) == 1:
				num = num * 3 + 1
				cnt +=1
			while (num & 1) != 1:
				num = num >> 1
				cnt +=1
		if max_length < cnt:
			max_length = cnt

	print(f"{i} {j} {max_length}")
