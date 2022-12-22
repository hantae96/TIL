def backTracking(level,sum_number,max_number,check_list,three_sqrt,answer):
   
    if sum_number > max_number:
        return
    else:
        for number in three_sqrt:
            if check_list[number] == 0:
                check_list[number] = 1
                answer.append(sum_number+number)
                backTracking(level+1,sum_number+number,max_number,check_list,three_sqrt,answer)
                check_list[number] = 0
        
                
def solution(n):

    three_sqrt = []
    answer= []
    for i in range(n+1):
        three_sqrt.append(3**i)


    max_number = 10000
    check_list = [0]*max_number
    backTracking(0,0,max_number,check_list,three_sqrt,answer)

    number_set =sorted(list(set(answer)))
    print(number_set)

    return number_set[n-1]

solution(11)