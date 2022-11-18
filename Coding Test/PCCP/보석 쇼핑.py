from collections import defaultdict


def solution(gems):
    lt = 0
    answer = []
    gems_keys = set(gems)
    gems_dict = defaultdict(int)
    
    max_length = 10000000
    for rt in range(len(gems)):
        gems_dict[gems[rt]] +=1
        while len(gems_dict) == len(gems_keys):
            if rt-lt+1 < max_length:
                max_length = rt-lt+1
                answer = [lt+1,rt+1]
        
            gems_dict[gems[lt]]-=1
            if gems_dict[gems[lt]] == 0:
                del gems_dict[gems[lt]]
            lt+=1
    
    return answer

gems = ["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]	
# gems = ["AA", "AB", "AC", "AA", "AC"]
print(solution(gems))