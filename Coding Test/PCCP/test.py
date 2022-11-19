coor = [[0,1],[1,0],[0,-1],[-1,0]]


def go(start,current_path,command):
    tmp=coor[current_path]
    if command == "G":
        for i in range(len(tmp)):
            if tmp[i] != 0:
                start[i] +=tmp[i]
    elif command == "B":
        for i in range(len(tmp)):
            if tmp[i] != 0:
                start[i] -=tmp[i]
    return start


def solution(command):
    answer = []    
    
    start = [0,0]
    current_path = 0
    
    for i in command:
        if i == "G":
            start=go(start,current_path,"G")
        elif i == "B":
            start=go(start,current_path,"B")
        elif i == "R":
                current_path +=1
        elif i == "L":
                current_path -=1
            
            
    return start

print(solution("GRGRGRB"))