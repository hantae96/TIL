def solution(wallpaper):
    answer = []
    
    start_x = 0
    start_y = 0

    flag = True

    # 시작 행
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == "#":
                start_x = i
                flag = False
                break
        if flag == False:
            break

    # 시작 열
    start_y = float("inf")
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == "#":
                if start_y > j:
                    start_y = j

    #####
    
    end_x = float("-inf")
    end_y = float("-inf")

    # 끝 행
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == "#":
                if end_x < i:
                    end_x = i


    # 끝 열
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == "#":
                if end_y < j:
                    end_y = j
    
        

    # print(f"시작 {start_x} {start_y}")
    # print(f"끝 {end_x+1} {end_y+1}")

    for i in [start_x,start_y,end_x+1,end_y+1]:
        answer.append(i)
    return answer

wallpaper = ["..........", ".....#....", "......##..", "...##.....", "....#....."]	
print(solution(wallpaper))