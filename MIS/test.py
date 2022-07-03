from collections import deque

class Node():
    def __init__(self,custom_number):
        self.num = 0
        self.at = 0
        self.dt = 0
        self.custom_number = custom_number


class Server():
    dq = deque()

class event():
    def __init__(self):
        self.count = 0
        self.people_list = [55,32,24,40,48]
        self.server_list = [43,36,34,51,44]

    def arrive_depart(self,custom_number):
        node=Node(custom_number)
        node.at = self.people_list[custom_number]
        node.dt = self.server_list[custom_number]
        return node
        
        
    def check(self,systime=0):
        print(f"현재시각 : {systime}  ",end="")
        print(f"대기인수 : {self.count}")
        print()

    def stat(self):
        pass

    def time_generator(self):
        self.time_table = []

        for i in range(len(self.people_list)):
            if i == 0:
                self.time_table.append(self.people_list[i])
            else:
                self.time_table.append(self.time_table[-1] + self.people_list[i])

        self.server_table = []

        for j in range(len(self.server_list)):
            if j == 0:
                self.server_table.append(self.time_table[0]+self.server_list[0])
            else:
                self.server_table.append(self.server_table[-1] + self.server_list[j])

        return self.server_table,self.time_table


event = event()
# 시간 계산
server_time,arrive_time=event.time_generator()
print(arrive_time,server_time)

arr = []

print(event.arrive_depart(1))

#for i in range(len(arrive_time)):
#    arr.append(event.arrive_depart(i))

#print(arr)