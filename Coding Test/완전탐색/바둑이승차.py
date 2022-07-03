import sys
sys.setrecursionlimit(10000)


def DFS(level,weight):
    global max_weight
    if weight > C:
        return 
    # 왜 무게로 하면 안되지??
    if level == N:
        if max_weight < weight:
         max_weight = weight
    else:
        DFS(level+1,weight+dog_lst[level])
        DFS(level+1,weight)


if __name__ == "__main__":
    C,N = 259,5
    dog_lst = [81,58,42,33,61]
    max_weight = float("-inf")

    DFS(0,0)

    print(max_weight)
    