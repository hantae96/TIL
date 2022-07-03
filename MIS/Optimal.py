class Node():
    def __init__(self):
        self.time = 0


class event():
    def __init__(self):
        self.people_list = [55,32,24,40,48]
        self.server_list = [43,36,34,51,44]
        self.count = 0
        
    def check(self,systime=0):
        print(f"현재시각 : {systime}  ",end="")
        print()

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


if __name__== "__main__":

    # 인스턴스 할당
    event = event()
    node = Node()

    # 시간 계산
    server_time,arrive_time=event.time_generator()

    s=0
    a=0
    while True:
        # 반드시 arrive time이 먼저 끝남
        if a <= len(arrive_time)-1:
            if node.time >= server_time[s]:
                event.check(server_time[s])
                s+=1
            elif node.time < server_time[s]:
                event.check(node.time)
                node.time = arrive_time[a]
                a+=1
        else:
            for i in range(s,len(server_time)):
                event.check(server_time[i])
            else:
                break
        
        
