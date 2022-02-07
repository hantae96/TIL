# 핵심 아이디어 : 모든 조합을 비교하지 않고, 정답 == 타켓에서 첫번째 값을 뺀 값 target - n이 존재하는지 탐색하는 것

from re import I


nums = [2,7,11,15]
target = 9
# 출력은 [0,1] 

def twoSum(nums,target):
    # 두수의 인덱스를 리턴하므로, enumerate 함수를 사용한다.
    for index,num in enumerate(nums):
        complement = target - num
        
        # for 문안에 분기문이 있기 때문에, for문이 돌면서 한번 판단하고 끝나는게 아닌 계속 뒤에것을 탐색하면서 판단함
        if complement in nums[index+1:]:
            # x.index = 리스트에 x 값이 있으면, x의 위치값을 돌려줌
            
            # 리턴값으로 조건에 해당하는 num의 인덱스를, 두번째로 조건에 해당하는 인덱스 + 1를 반환한다.
            return [nums.index(num), nums[index+1:].index(complement)+(index+1)]
        


def twoSum_dic(nums,target):
    nums_map = {}
    for index,num in enumerate(nums):
        nums_map[num] = index
        
        for i,num in enumerate(nums):
            # 왜 index != nums_map[target-num]: 면 안되지??
            if target - num in nums_map and index != nums_map[target-num]:
                return [i,nums_map[target-num]]
        
twoSum_dic(nums,target)


nums = [2,7,11,15]


def two_sum_pointer(nums,target):
    left = 0
    right = len(nums)-1
    while left != right:
        if nums[left] + nums[right] < target:
            left+=1
        elif nums[left] + nums[right] > target:
            right -=1
        
        else:
            return print([left,right])
            
        
        
        
two_sum_pointer(nums,target)
