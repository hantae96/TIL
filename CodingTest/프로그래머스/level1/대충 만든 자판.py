def count(char,keymaps):
    length = []
    flag = False
    for keymap in keymaps:
        cnt = 0
        for idx,val in enumerate(keymap):
            if val == char:
                cnt += idx+1
                break

        length.append(cnt)

    if sum(length) == 0:
        return -1
    else:
        min_value = float("inf")
        for i in length:
            if i != 0 and min_value > i:
                min_value = i
        return min_value
            
    

def solution(keymap, targets):
    answer = []
    flag = True
    for target in targets:
        tmp = 0
        cnt = 0
        for char in target:
            tmp =count(char,keymap)
            if tmp == -1:
                answer.append(-1)
                flag = False
                break
            else:
                cnt += (count(char,keymap))
    
        if flag == False:
            break
        else:
            answer.append(cnt)
    
    return answer


keymap = ["ABCDE","ABBCE"]
targets = ["ABBEF"]	

print(solution(keymap,targets))