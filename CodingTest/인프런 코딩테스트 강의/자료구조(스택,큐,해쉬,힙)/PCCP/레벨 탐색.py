from collections import deque

def BFS():
    dQ = deque()
    dQ.append(1)
    L=0
    while(dQ):
        length = len(dQ)
        for _ in range(length):
            v = dQ.popleft()
            print(v,end="")
            for nv in [v*2,v*2+1]:
                if nv > 7:
                    continue
            dQ.append(nv)
        L+=1

BFS()