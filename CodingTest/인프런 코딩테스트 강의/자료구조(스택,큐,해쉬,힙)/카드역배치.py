import sys

sys.stdin = open("Coding Test/자료구조(스택,큐,해쉬,힙)/input.txt","r")

card_list = [i for i in range(1,21)]

for i in range(10):
    start,end = map(int,input().split()) 
    start -=1
    end -=1    
    if start > end :
        start,end = end,start
    
    step = end - start

    if step%2 == 0:
        step = step//2
    else:
        step = step//2 + 1
    
    for i in range(step):
        card_list[start + i],card_list[end - i] = card_list[end - i], card_list[start + i]

print(card_list)
    

