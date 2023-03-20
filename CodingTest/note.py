phone = [[1,2,3],[4,5,6],[7,8,9],["*",0,"#"]]

def solution(numbers, hand):
    answer = ""
    # 왼손, 오른손이 닿을수 있는 번호
    left_side = [1,4,7]
    right_side = [3,6,9]
    
    # 핸드폰 구조 2차원 배열
    phone = [[1,2,3],[4,5,6],[7,8,9],["*",0,"#"]]
    
    # 왼손, 오른손 변수
    left = []
    right = []
    
    for number in numbers:
        temp_hand = ""
        number_idx = check(number)
        if number in left_side: 
            left=number_idx
            temp_hand = "L"

        elif number in right_side:
            right=number_idx
            temp_hand = "R"

        else:
            temp_left = 0
            temp_right = 0
            
            if linear(number_idx,left):
                temp_left = abs(number_idx[0] - left[0]) + abs(number_idx[1] - left[1])
            if linear(number_idx,right):
                temp_right = abs(number_idx[0] - right[0]) + abs(number_idx[1] - right[1])
            if temp_left == temp_right:
                if hand == "left":
                    left = number_idx
                    temp_hand = "L"
                else :
                    right = number_idx
                    temp_hand = "R"
            else:
                if temp_left < temp_right:
                    left = number_idx
                    temp_hand = "L"
                else:
                    right = number_idx
                    temp_hand = "R"

        answer = answer + temp_hand
        
    return answer

def linear(number_idx,hand_idx):
    # 똑같은 번호는 누르지 않는다고 가정할때
    if number_idx[0] == hand_idx[0] and number_idx[1] != hand_idx[1]:
        return True
    elif number_idx[1] == hand_idx[1] and number_idx[0] != hand_idx[0]:
        return True
    else:
        return False

def check(number):
    for i in range(4):
        for j in range(3):
            if phone[i][j] == number:
                return [i,j]

numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
hand = "right"

print(solution(numbers,hand))
