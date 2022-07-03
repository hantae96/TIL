# made by hantae choi -2022-05-22
# This program is Single Server Queue System Simulation
# : 입력된 값에 의해서 단일 서버 대기행렬 시스템을 시뮬레이션 하는 프로그램임
#
# 0. 시뮬레이션에 필요한 고객 도착 시간 간격과 각 고객들의 서비스 시간을 리스트에 입력
# 1. initize_varible 함수 실행(변수 선언 및 초기화)
#   1.1 초기 시스템 설정을 위해 event_arrive, event_depart 덱 생성 후 값을 각각 arrive_time_list의 첫번 째 값과 inf(무한)으로 대입
# 2. processing()함수 실행 -> 로직을 while 문으로 반복
#   2.1 arrive_time_list(시간)을 time_generator함수를 실행 시켜 arrive_time_table(시각) 리스트로 만듬
#   2.2 node가 만들어 질때 num에 i를 대입해 고객 번호로 사용
#   2.3 node에 arrive_time_list의 시각을 node.at에 추가
#   2.4 arrive_time_list의 첫번째 값을 server_queue 에 추가 , server_queue가 비어있으면 꺼내어 2.5 행으로 실행    
#   2.5 event_arrive의 값이 event_depart의 값 보다 작을 시 event_arrive에서 가장 최근 값을 꺼내어 sys_clock(현재시각)에 대입
#   2.6 event_arrive이 비어있는지 확인하여 비어있으면 서버상태를 0으로 바꾸고 arrive_time_list에서 다음 데이터를 입력((add_arrive 함수실행))
#   2.7 event_arrive의 값이 event_depart의 값 보다 클 시 event_depart의 가장 최근 값을 꺼내어 tmp(현재시각)에 대입
#   2.8 event_depart의 비어있는지 확인하여 비어있으면 서버상태를 0으로 바꾸고, server_queue에서 대기 손님 pop, costomer_service_time_list에서 다음 데이터를 입력(add_depart 함수실행)
#   2.9 node 가 나올 시 node.dt 에 나가는 시각의 데이터를 추가
#       (node.dt - node.at) - (원래 도착시간+원래 서비스시간) 을 하면 지연시간을 알 수 있음
#       node.dt - node.at로 체류시간도 알 수 있음
# 
#   2.10  arrive_time_list가 전부 순회되면 while문을 종료
# 3. 출력 함수에 변수값을 할당 후 값 출력
#

# 덱을 위한 모듈 import
from collections import deque

# 노드 클래스 선언 
class Node():
    def __init__(self,num):
        self.num = num

# 노드 정보 입력 함수 , default_at : 원래 도착 시간 . at = 다음 사람의 도착시간 , dt = 출발시간
    def data_handler(self,node,default_at=0,at=0,dt=0):
            self.default_at = default_at
            self.at = at
            self.dt = dt
            
def initize_varible():
    global arrive_time_list,costomer_service_time_list,arrive_time_table,node_list
    global event_arrive,event_depart,server_queue
    global i,j,customer,step,wating
    # 데이터 값 input
    arrive_time_list = [55,32,24,40,48]
    costomer_service_time_list = [43,36,34,51,44]
    arrive_time_table=time_generator(arrive_time_list)
    
    # 노드 리스트 생성
    node_list = []

    # 사건 리스트 A,D 덱 생성
    event_arrive = deque()
    event_depart = deque()
    server_queue = deque()
    # 변수 선언 및 초기화
    i = 0 # i = arrive_time_list의 인덱스
    j = 0 # j = arrive_time_list의 인덱스
    customer = 0 # 고객 수 변수
    step = 0 # 단계확인용 변수
    wating = 0 # 대기자 수 변수


# ui 출력 함수
def print_ui(status,wating,time,arrive_event,depart_event,n):
    # 각 list가 비어있을 시 indexerror를 방지하기 위해 사용
    try:
        arrive_event=arrive_event[-1]
    except:
        # 오류 발생시 빈칸으로 대입
        arrive_event=""
    try:
        depart_event=depart_event[-1]
    except:
        # 오류 발생시 빈칸으로 대입
        depart_event=""
        
    # sever_queue 인자 프린트 전처리
    sq=[i for i in server_queue]
    print("--------------------------------------")
    print(f"서버상태 {status} 대기인수 {wating} 도착시간 {sq}")
    print(f"현재 시각 {time} 사건리스트 A[{arrive_event}] [{depart_event}]")
    print(f"서비스 고객 수 {n}")
    print("--------------------------------------")
    print()

# 도착 "시각" 리스트 를 만드는 함수
def time_generator(arrive_time_list):
    arrive_time_table = []

    for i in range(len(arrive_time_list)):
        if i == 0:
            arrive_time_table.append(arrive_time_list[i])
        else:
            arrive_time_table.append(arrive_time_table[-1] + arrive_time_list[i])
    # 도착 "시간","시각" 튜플 리스트 생성 ("시간","시각")
    arrive_time_table = [(x,y) for x,y in zip(arrive_time_list,arrive_time_table)]

    return arrive_time_table
    

def add_first(step):
    if step== 0:
        # 처음 시뮬레이션 값 대입
        event_arrive.append(arrive_time_list[i])
        event_depart.append(float("inf"))
        sys_clock = 0
        print_ui(0,wating,sys_clock,event_arrive,event_depart,customer)
        step+=1
    else:
        # 사건 리스트에서 나중에 고객(event_arrive)의  시간보다 먼저온 고객이 서비스를 완료한 시간(event_depart)이 더 오래걸리는 경우
        # 대기열이 생기는 경우
        if event_arrive < event_depart:
            # 1단계에서 Depart event가 무한에서 값을 변경 해야하므로
            # step 변수로 단계를 구분
            if step == 1:
                # 무한에서 1번째 손님의 출발시간으로 값 변경
                event_depart[0]=(arrive_time_list[i]+costomer_service_time_list[j])
                # 다음 손님의 서버시간 계산을 위해  인덱스 증가
                j+=1
                step = 2

def add_arive(server_status):
    # 사건 리스트에서 event_arrive가 더 작은 경우
    # even_arrive에서 가장 최근에 들어온 값을 제거 및 현재 시각에 대입
    global i,j,event_arrive,step,customer,wating,node
    # 제일 최근에 서비스를 이용한 고객이 출발하는 시간을 tmp에 대입
    sys_clock = event_arrive.popleft()
    
    # ui 출력
    print_ui(server_status,wating,sys_clock,event_arrive,event_depart,customer)
    #arrive_time_list에 다음 손님의 도착 시간을 계산 ( 데이터가 "시간" 단위 임으로 sum 함수를 이용해 "시각"으로 변경)
    i+=1
    # 서버 큐에 추가
    server_queue.append(sum(arrive_time_list[0:(i)+1]))
    event_arrive.append(sum(arrive_time_list[0:(i)+1]))
    node.data_handler(node,at=sum(arrive_time_list[0:(i)+1]))
    # 단계, 서비스 고객 증가 및 대기인원 생성
    step+=1
    customer+=1
    wating = 1

# event_depart에 시간 추가함수
def add_depart(server_status):
    global i,j,event_depart,step,customer,wating,node,server_queue
     #사건 리스트에서 나중에 고객(event_arrive)의  시간보다 먼저온 고객이 서비스를 완료한 시간(event_depart)이 더 짧은 경우
    # 대기열이 없어지는 경우 
     # 마지막에 일한 시간에 다음 손님의 시간을 더해서 다음 손님이 완료 될 시간을 event_depart에 추가
    tmp = event_depart.popleft()
    
    node.data_handler(node,at = arrive_time_table[i][1],dt=tmp+costomer_service_time_list[j])
    node_list.append(node)
    
    event_depart.append(tmp+costomer_service_time_list[j])
    
    # 시스템 시각보다 서버큐의 최상단 시간이 작으면 이미 손님이 떠난 것으로, 서버큐에서 pop
    if server_queue[0] <= tmp:
        server_queue.popleft()
        
    # ui 출력
    print_ui(server_status,wating,tmp,event_arrive,event_depart,customer)
    # costomer_service_time_list 인덱스, 단계 증가 및 대기 인원 제거
    j+=1
    step+=1
    wating= 0
    
def node_data_view():
    print("노드 정보")
        
    for i in range(len(node_list)):
        node_list[i].default_at = arrive_time_table[i][1]
    
    
    for i in node_list:
        print(i.num,end="/")
        print(i.default_at,end="/")
        print(i.at,end="/")
        print(i.dt,end="")
        print()
        
    delay_time=0
    total_delay_time=0
    print()
    for i in range(len(node_list)-1):
        if node_list[i] == 0:
            print(f"총지연시간 : {0} 누적 지연시간 : {0}")
        else:
            delay_time=node_list[i].dt-node_list[i+1].default_at
            total_delay_time+=delay_time
            print(f"총지연시간 : {total_delay_time} 누적 지연시간 : {delay_time}")

# 메인 로직 실행
def processing():
    global step,i,j,node,server_queue
    
    while i<len(arrive_time_list):
        # 1단계 변수 값 입력
        if step == 0 :
            
            node = Node(i+1)
            
            # 처음 시뮬레이션 값 대입
            event_arrive.append(arrive_time_list[i])
            node.data_handler(node,at=arrive_time_list[i])
            server_queue.append(arrive_time_list[i])
            event_depart.append(float("inf"))
            sys_clock = 0
            
            print_ui(0,wating,sys_clock,event_arrive,event_depart,customer)
            step+=1

        
        # 1단계 이후 변수 값 입력 및 계산
        else:
            # 사건 리스트에서 나중에 고객(event_arrive)의  시간보다 먼저온 고객이 서비스를 완료한 시간(event_depart)이 더 오래걸리는 경우
            # 대기열이 생기는 경우
            if event_arrive < event_depart:
                # 1단계에서 Depart event가 무한에서 값을 변경 해야하므로
                # step 변수로 단계를 구분
                if step == 1:
                    # 무한에서 1번째 손님의 출발시간으로 값 변경
                    event_depart[0]=(arrive_time_list[i]+costomer_service_time_list[j])
                    node.data_handler(node,at=arrive_time_table[i+1][1],dt=event_depart[0])
                    node_list.append(node)
                    # 다음 손님의 서버시간 계산을 위해  인덱스 증가
                    j+=1
                    step = 2
                # 1단계가 아닐시 
                else:
                    node = Node(i+1)
                    
                    if len(server_queue)!=0:
                        server_status=1
                        add_arive(server_status)
                    else:
                        server_status=0
                        add_arive(server_status)

            else:
                if len(server_queue)!=0:
                    server_status=1
                    add_depart(server_status)
                else:
                    server_status=0
                    add_depart(server_status)

    # while 문이 끝나면 종료 알림
    else:
        print("대기열을 추가하시오")  
        print()


# 메인 함수 시작
if __name__ == "__main__":
    # 변수 초기화
    initize_varible()
    # 로직 실행
    processing()
    # 노드 정보 출력
    node_data_view()
    
