from collections import defaultdict

def solution(p):
    answer = 0

    card_dict = {}
    for i in p:
        if i not in card_dict:
            card_dict[i] = 1
        else:
            card_dict[i] +=1

    print(card_dict)

    key_set = sorted(card_dict)

    for i in range(len(key_set)-1):
        if i == len(key_set)-1:
            answer += card_dict[key_set[i]]

        if card_dict[key_set[i]] < card_dict[key_set[i+1]]:
            answer+=card_dict[key_set[i]]
        else :
            answer+=1
            card_dict[key_set[i+1]] += (card_dict[key_set[i]] - card_dict[key_set[i+1]])


    return answer
solution(
[103, 101, 103, 103, 101, 102, 100, 100, 101, 104])