import sys


def DFS(len):
    if len==1 or len==2:
        return len
    else:
        dy[len]=DFS(len-1)+DFS(len-2) 
        return dy[len]
           




if __name__ == "__main__":
    n = int(input())
    dy = [0]*(n+1)
    print(DFS(n))