def backTracking(level,remain,dungeons,check_list,answer):
    if level == step:
        if answer < level:
            answer = level
      
    else:
        for i in range(step):
            if check_list[i] == 0 and remain >= dungeons[i][0]:
                check_list[i] = 1
                backTracking(level+1,remain-dungeons[i][1],dungeons,check_list,answer)
                check_list[i] = 0

def solution(k, dungeons):
    global step,min_number
    answer = -1
    step = len(dungeons)
    check_list = [0]*step
    answer=backTracking(0,k,dungeons,check_list,answer)
    
    return answer

k = 80
dungeons = [[80,20],[50,40],[30,10]]
print(solution(k,dungeons))