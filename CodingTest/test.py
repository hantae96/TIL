def solution(commands):
    answer = []
    martix = [["EMPTY" for i in range(50)] for i in range(50)]
    merge_list = []
    merge_flag = 0
    
    for i in commands:    
        command_list = i.split()
        command = command_list[0]
        

        if command == "UPDATE":
            update_merge = 0
            if command_list[1].isnumeric():
                x = int(command_list[1])-1
                y = int(command_list[2])-1
                value = command_list[3]
                martix[x][y] = value

                for j in merge_list:
                    for k in j:
                        if k[1] == x and k[2] == y:
                            update_merge = k[0]
                
                for i in range(len(martix)):
                    for j in range(len(martix)):
                        for k in range(marge_list):
                            if update_merge == marge_list[k][0]:
                                martix[i][j] = value
                
            else:
                value1 = command_list[1]
                value2 = command_list[2]
                for i in range(len(martix)):
                    for j in range(len(martix)):
                        if martix[i][j] == value1:
                            martix[i][j] = value2

        if command == "MERGE":
            b_x = int(command_list[1])
            b_y = int(command_list[2])
            a_x = int(command_list[3])
            a_y = int(command_list[4])
            #병합한 값은 category 값을 가지게 되며 좌표 어디서든 접근 할 수 있다.
            martix[b_x][b_y] = "category"
            martix[a_x][a_y] = "category"
            marge_list.append([merge_flag,b_x,b_y])
            merge_list.append([merge_flag,a_x,a_y])
            merge_flag +=1

        if command == "UNMERGE":
            x = int(command_list[1])-1
            y = int(command_list[2])-1


             for j in merge_list:
                    for k in j:
                        if k[1] == x and k[2] == y:
                            update_merge = k[0]
                
                for i in range(len(martix)):
                    for j in range(len(martix)):
                        for k in range(marge_list):
                            if marge_list[k][1] == x and merge_list[k][2] == y:
                                martix[x][y] = martix[i][j]
                                flag = marge_list[k][0]
                            
                            if marge_list[k][0] == flag:
                                merge_list.pop(k)
        
        if command == "PRINT":
            x = int(command_list[1])-1
            y = int(command_list[2])-1
            print_list = []

            for i in merge_list:
                if i[1] == x and [2] == y:
                    print_list.append(i[0])

            for i in print_list:
                for j in merge_list:
                    if j[0] == i:
                        print(martix[j[0]][j[1]])

    return answer