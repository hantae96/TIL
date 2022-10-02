# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
from collections import deque

number = int(input())

# 12시부터 시계 방향
x_coor = [-1,-1,0,1,1,1,0,-1]
y_coor = [0,1,1,1,0,-1,-1,-1]


for i in range(number):
	blank = input()
	M,N = map(int,input().split())
	martix = []
	for _ in range(M):
		martix.append(input().lower())
		
	# 테스트 케이스 한줄씩 입력
	test_case_num = int(input())
	test_case_set = [0 for i in range(test_case_num)]
	for idx in range(test_case_num):
		test_case = input().lower()

		for i in range(len(martix)):
			for j in range(len(martix[i])):
				if martix[i][j] == test_case[0]:
					start = (i,j)
					for k in range(8):
						tmp = martix[start[0]][start[1]]
						for n in range(1,len(test_case)):
							X = (start[0] + x_coor[k]*n)  
							Y = (start[1] + y_coor[k]*n)
							
						# 방향을 정하고 그 방향으로 test_case의 길이 만큼 탐색해야 함.
							if -1 < X < M and -1 < Y < N:
								tmp = tmp + martix[X][Y]
								if tmp == test_case:
									if test_case_set[idx] != 1:
										print(f"{start[0]+1} {start[1]+1}")
										test_case_set[idx] = 1
			
	print()		
				
			
		

