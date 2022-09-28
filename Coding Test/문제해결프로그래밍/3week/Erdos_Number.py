import sys
sys.stdin = open("/Users/Hantae/Desktop/Programming/TIL/Coding Test/문제해결프로그래밍/3week/input.txt","r")

# 시나리오 개수 입력받음
T = int(input())

# 시나리오 횟수만큼 반복
for t in range(1, T+1):
    # p, n 입력
    p, n = map(int, input().split())

    papers = [] # 논문별 공동 저자 목록
    nameSet = set() # 해당 시나리오 전체 저자 목록
    for _ in range(p):
        author, title = input().split(':')
        authors = []

        # author 부분 ', ' 단위로 나눈 후 2개씩 결합
        word = author.split(', ')
        for surname, forename in list(zip(word[::2], word[1::2])):
            authors.append(surname+', '+forename)
            nameSet.add(surname+', '+forename)
        papers.append(authors)

    # print(f"papers : {papers}")    
    # print(f"nameSet {nameSet}")
    # 두 저자 간 연결 여부를 알려주는 dictionary
    edge = {a:{} for a in nameSet}
    # 연결 여부 업데이트
    for authors in papers:
        for a in authors:
            # 똑같은 for문을 안에서 한번 더 돌면서, 완전 탐색함
            for b in authors:
                if a == b:
                    continue
                edge[a][b] = 1

    # print(f"edge {edge}")
    # Erdos로부터의 거리를 저장하는 map
    graph = {a:-1 for a in nameSet}
    # print(f"graph : {graph}")
    # bfs
    try:
        # zip : 한 
        queue = list(zip(edge['Erdos, P.'].keys(), [1 for _ in range(len(nameSet))]))
        print(queue)
        while len(queue) > 0:
            name, dist = queue[0]
            queue.pop(0)
            if graph[name] > 0:
                graph[name] = min(graph[name], dist)
            else:
                graph[name] = dist
            for nxt in edge[name].keys():
                if graph[nxt] == -1:
                    queue.append((nxt, dist+1))
    except:
        sadf = 0 # Erdos가 없으면 아무것도 안한다.
    # 출력
    print('Scenario', t)
    for i in range(n):
        name = input()
        print(name, graph[name] if graph[name]>0 else 'infinity')