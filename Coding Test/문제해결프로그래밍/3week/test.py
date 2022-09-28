import sys
sys.stdin = open("/Users/Hantae/Desktop/Programming/TIL/Coding Test/문제해결프로그래밍/3week/input.txt","r")

T = int(input())

for t in range(1,T+1):
    p,n = map(int,input().split())

    papers = []
    nameSet = set()
    for _ in range(p):
        author,title = input().split(':')
        authors = []
        word =author.split(', ')
        # print(word)
        for front,after in list(zip(word[::2],word[1::2])):
            authors.append(front + ', ' + after)
            nameSet.add(front+', '+after)
        papers.append(authors)
    
    edge = {a:{} for a in nameSet}

    for authors in papers:
        for a in authors:
            for b in authors:
                if a==b:
                    continue
                edge[a][b] = 1
    
    graph = {a:-1 for a in nameSet}
    print(graph)
    try:
        queue = list(zip(edge['Erdos, P.'].keys(),[1 for _ in range(len(nameSet))]))
        while len(queue) > 0:
            name,dist = queue[0]
            queue.pop(0)
            if graph[name] > 0:
                graph[name] = min(graph[name],dist)
            else:
                graph[name] = dist
            print(edge[name].keys())
            for nxt in edge[name].keys():
                if graph[nxt] == -1:
                    queue.append((nxt,dist+1))
    except:
        pass

