import sys
sys.stdin = open("/Users/Hantae/Desktop/Programming/TIL/Coding Test/문제해결프로그래밍/3week/input2.txt","r")

T = int(input())
empty_line = input()
# 테스트케이스만큼 반복
for _ in range(T):
    board = {}
    is_team = []
    while(True):
        try:
            team_num, pro_num, time, result = input().split()
            team_num, pro_num, time = map(int, [team_num, pro_num, time])

            if team_num not in is_team: # 팀정보 없으면 만들어주기
                board[team_num] = {'correct': 0, 'penalty': 0, 'incorrect': {}}
                is_team.append(team_num)

            print(board)

            if pro_num not in board[team_num]['incorrect'].keys(): # 문제 정보 없으면 만들어주기
                board[team_num]['incorrect'][pro_num] = 0

            if result == 'C': # 맞았을 때
                board[team_num]['correct'] += 1
                board[team_num]['penalty'] += (board[team_num]['incorrect'][pro_num] * 20) + time
            elif result == 'I': # 틀렸을 때
                board[team_num]['incorrect'][pro_num] += 1
        except:
            break
    # 순위 계산
    score = []
    for k in board:
        score.append((-board[k]['correct'], board[k]['penalty'], k))
    score.sort()
    for l in score:
        key = l[2]
        print(key, board[key]['correct'], board[key]['penalty'])
    print()