import math

def change_time(time):
    clock,minute = map(int,time.split(":"))
    result = clock*60+minute
    return result


def solution(fees, records):
    MAX_LENGTH = 100000
    in_time = [0]*MAX_LENGTH
    io_table = [0]*MAX_LENGTH
    result_table = [0]*MAX_LENGTH
    car_number_list = []
    answer = []
    
    for i in records:
        time,car_number,IO = i.split()    
        car_number = int(car_number)
        car_number_list.append(car_number)
        
        
        if io_table[car_number] == 0:
            in_time[car_number] += change_time(time)
            io_table[car_number] = 1
        else:
            result_table[car_number] += abs(in_time[car_number] - change_time(time))
            in_time[car_number] = 0
            io_table[car_number] = 0
            
    for i in range(len(io_table)):
        if io_table[i] == 1:
            result_table[i] += 1439-in_time[i]
    
    
    base_time,base_money,add_min,add_money = fees
    
    for i in range(len(result_table)):
        if result_table[i] > base_time:
            tmp = base_money
            result_table[i] = result_table[i]-base_time
            tmp += math.ceil(result_table[i]/add_min)*add_money
            result_table[i] = tmp
        elif result_table[i] <= base_time and result_table[i] != 0:
            result_table[i] = base_money
            
    for i in range(len(result_table)):
        if i in car_number_list:
            answer.append(result_table[i])
            
    return answer
        