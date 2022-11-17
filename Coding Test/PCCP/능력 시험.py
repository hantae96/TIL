def DFS(level,max_sum):
    global test_case
    global result
    if level == len(test_case[0]):
        result = max(result,max_sum)
    else:
        for i in range(len(test_case)):
            if check_list[i] == 0:
                check_list[i] = 1
                DFS(level+1,max_sum+test_case[i][level])
                check_list[i] = 0
    

if __name__ == "__main__":
    test_case = [[40,10,10],
             [20,5,0],
             [30,30,30],
             [70,0,70],
             [100,100,100]]
    
    result = 0
    max_sum = 0
    check_list = [0]*len(test_case)
    DFS(0,0)
    print(result)
