from collections import deque

class Node():
    def __init__(self,custom_number):
        self.num = 0
        self.at = 0
        self.dt = 0
        self.custom_number = custom_number

        

class event():
    def __init__(self):
        self.count = 0
        self.people_list = [55,32,24,40,48,0]
        self.server_list = [43,36,34,51,44,0]

    def arrive_depart(self,custom_number):
        node=Node(custom_number)
        node.at = self.people_table[custom_number]
        node.dt = self.server_table[custom_number]
        return node
        
    def check(self,systime=0,cd=0,sd=0):
        self.customer_delay=0
        self.server_delay=0
        self.customer_delay += cd
        self.server_delay += sd
        print(f"현재시각 : {systime}")

    def stat(self):
        pass

    def time_generator(self):
        self.people_table = []

        for i in range(len(self.people_list)):
            if i == 0:
                self.people_table.append(self.people_list[i])
            else:
                self.people_table.append(self.people_table[-1] + self.people_list[i])

        self.server_table = []

        for j in range(len(self.server_list)):
            if j == 0:
                self.server_table.append(self.people_table[0]+self.server_list[0])
            else:
                self.server_table.append(self.server_table[-1] + self.server_list[j])

        return self.server_table,self.people_table

# 키생성
server = deque()
event = event()
# 시간 계산
server_time,arrive_time=event.time_generator()
print(arrive_time,server_time)

# 노드 배열 생성
arr = []
for i in range(len(server_time)):
    arr.append(event.arrive_depart(i))

# 시작 노드 값 입력
server.append(arr[0])
event.check(arr[0].at)

# 첫번쨰 끝나느시간보다 두번째 시작시간이 작으면
# 서버에 넣는다
server = deque()

for num in range(1,len(arr)):
    if arr[num].dt >  arr[num+1].at:
        event.check(arr[num+1].at)
        server.append(arr[num+1])
    else:
        #server_check(arr[num+1])
        event.check(arr[num+1].dt)
        # 이벤트 시작 발생
#else:
#    for num in range(len(server)):
#        if server[num]
        
    
