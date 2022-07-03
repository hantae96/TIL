class Node():
    def __init__(self):
        self.time = 0
        self.customer = 0

class event():
    def __init__(self):
        self.arrive_list = [55,32,24,40,48]
        self.depart_list = [43,36,34,51,44]
        
    def check(self,arrive,depart):
        global a,s
        if arrive >= depart[s]:
            systime= depart_time[s]
            print(f"현재시각 : {systime}    ",end="")
            print()
            s+=1
             
        elif arrive < depart[s]:
            systime=node.time
            print(f"현재시각 : {systime}    ",end="")
            print()
            node.time = arrive_time[a]
            a+=1

    def check_waitng(self,depart_time,arrive_time):
        self.waiting_lst=[]
        lst = [(x,y) for x,y in zip(arrive_time,depart_time)]
        i=0
        j=1
        while i<len(lst) and j<len(arrive_time):        
            if lst[i][0]<=arrive_time[j]<=lst[i][1]:
                self.waiting_lst.append((arrive_time[j],1))
                j+=1
            else:
                i+=1
        return self.waiting_lst

    def time_generator(self):
        self.time_table = []
        for i in range(len(self.arrive_list)):
            if i == 0:
                self.time_table.append(self.arrive_list[i])
            else:
                self.time_table.append(self.time_table[-1] + self.arrive_list[i])

        self.depart_table = []
        for j in range(len(self.depart_list)):
            if j == 0:
                self.depart_table.append(self.time_table[0]+self.depart_list[0])
            else:
                self.depart_table.append(self.depart_table[-1] + self.depart_list[j])

        return self.depart_table,self.time_table


if __name__== "__main__":
    # 인스턴스 할당
    event = event()
    node = Node()
    # 시간 계산
    depart_time,arrive_time=event.time_generator()
    # 시간에 따른 대기인원
    waiting_list = event.check_waitng(depart_time,arrive_time)
    
    s=0
    a=0
    while True:
        # 반드시 arrive time이 먼저 끝남
        if a <= len(arrive_time)-1:
            event.check(node.time,depart_time)
        else:
            for i in range(s,len(depart_time)):
                print(f"현재시각 : {depart_time[i]}  ",end="")
                print()
                
            else:
                break
    
    print(f"현재시각 - 대기인원 : {waiting_list}")
        
