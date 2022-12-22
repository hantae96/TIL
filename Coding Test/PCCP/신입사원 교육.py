import heapq

def solution(ability, number):
    answer = 0

    hq = []
    for i in ability:
        heapq.heappush(hq,i)
    
    for i in range(number):
        a = heapq.heappop(hq)
        b = heapq.heappop(hq)

        heapq.heappush(hq,a+b)
        heapq.heappush(hq,a+b)
    
    answer = sum(hq)

    return answer