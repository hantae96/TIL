# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
# 팀의 순위 : 우선 푼 문제의 갯수가 많은 순 -> 시간 벌점이 적은 순
# 이둘을 고려했는데도 동점 팀이 둘이상 -> 팀 숫자가 작은 팀
# 제출된 풀이 가운데 정답이 하나라도 있으면 해결
# 시간 벌점은 첫 번째 정답이 제출될 떄까지 걸린 시간
# 정답이 나오기 전까지 제출된 오답 1개에 20분 추가 벌점
# 입력 : 팀 번호 / 문제 번호 / 시간 패널티 / 유형

# 출력 : 팀 번호 / 푼 문제 갯수 / 누적된 시간 벌점
num = int(input())
blank = input()

test_case = []
test = [[] for i in range(num)]
team_list = {}

while True:
	try:
		test_case.append(input())
	except EOFError:
		break
		
idx = 0
for case in test_case:
	if case == "":
		idx+=1
	else:
		case = list(case.split())
		test[idx].append(case)


for test_set in test:
	stack = [[0,0,0] for i in range(10)]
	cnt = 0
	result = []

	for case in test_set:
		if case[0] not in team_list:
			team_list[case[0]] = []
		for i in range(len(case)-1):
			case[i] = int(case[i])

	for case in test_set:
			if case[3] == ("L" or "R" or "E"):
				continue
			elif case[3] == "I":
				stack[case[0]][1]= stack[case[0]][1] + 20
			elif case[3] == "C":
				# 시간 패널티
				stack[case[0]][1] = stack[case[0]][1] + case[2]
				# 푼 문제 갯수
				stack[case[0]][0] += 1
				# 팀 번호
				stack[case[0]][2] = case[0]
	stack = sorted(stack, key = lambda x : (-x[:][0],x[:][1],x[:][2]))
	# print(stack)
	
	for i in range(len(stack)):
		if sum(stack[i]) != 0:
			print(f"{stack[i][2]} {stack[i][0]} {stack[i][1]}")
	print()

