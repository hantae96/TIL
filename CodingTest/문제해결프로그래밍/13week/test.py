answer = 0


def check(card):
    global answer
    i = 0
    j = 1

    tmp = []
    tmp.append(card[i])

    while j<len(card) and i<j:
        if card[i] == card[j]:
            j+=1
            continue
        else:
            if card[j] not in tmp:
                tmp.append(card[j])
                j+=1
            else:
                j+=1
    
    answer += len(tmp)-1

    for i in tmp:
        card.remove(i)
    return card

def solution(p):
    global answer
    card = p
    while card:
        if len(card) == 1:
            break
        card = check(card)
    
    return answer
