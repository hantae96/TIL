import sys

def DFS(level):
    
    if level == num+1:
        for i in range(len(check_list)):
            if check_list[i] == 1:
                sum+=num_list[i]
        sum_list.append(sum) 

    if sum in sum_list:
        print("YES")
  
    else:
        check_list[level] = 1
        DFS(check_list[level+1])
        check_list[level] = 0
        DFS(check_list[level+1])
         



if __name__ == "__main__":
    sys.stdin = open("/Users/Hantae/Desktop/Programming/TIL/Coding Test/완전탐색/DFS/input.txt","r")
    num = int(input())
    num_list = list(map(int,input().split()))
    check_list = [0]*len(num_list)
    level = 0
    sum = 0
    sum_list = []
    DFS(level)

