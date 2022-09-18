# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
from collections import deque

try:
	while True:
		num_dq = deque(map(int,input().split()))
		step = num_dq.popleft()
		
		if len(num_dq)==1:
			print("Jolly")
			continue
		elif len(num_dq) == 2:
			if abs(num_dq[0] - num_dq[1]) == 1:
				print("Jolly")
				continue
		
		tmp_list = []
		for i in range(step-1):
			tmp_list.append(abs(num_dq[0] - num_dq[1]))
			num_dq.popleft()
		
		tmp_list.sort()
		# print(tmp_list)
		# print(list(range(1,tmp_list[-1]+1)))
		
		
		if tmp_list == list(range(1,tmp_list[-1]+1)):		
			print("Jolly")
		else:
			print("Not jolly")
except:
	pass