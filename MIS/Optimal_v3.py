# made by hantae choi -2022-05-20
# This program is Single Server Queue System Simulation

# 덱을 위한 모듈 import
from collections import deque

# 데이터 값 input
arrive_list = [55,32,24,40,48]
server_list = [43,36,34,51,44]

# 사건 리스트 A,D 덱 생성
event_arrive = deque()
event_depart = deque()

# 변수 선언 및 초기회
i = 0
j = 0
customer = 0
#total_time = 0
#accumulate_time = 0
step = 0
wating = 0

# ui 출력 함수
def print_ui(status,wating,time,A,D,n):
    try:
        A=A[-1]
    except:
        A=""
    D = D[-1]
    print("--------------------------------------")
    print(f"서버상태 {status} 대기인수 {wating}")
    print(f"현재 시각 {time} 사건리스트 A[{A}] [{D}]")
    print(f"서비스 고객 수 {n}")
    print("--------------------------------------")
    print()

while i<5:
    # 초기 시스템 설정
    if step == 0 :
        event_arrive.append(arrive_list[i])
        event_depart.append(float("inf"))
        systime = 0
        print_ui(0,wating,systime,event_arrive,event_depart,customer)
        step+=1
    else:
        if min(event_arrive) < min(event_depart):
            if step == 1:
                event_depart[0]=(arrive_list[i]+server_list[j])
                j+=1
                step = 2
                
            else:
                systime = event_arrive.popleft()
                print_ui(1,wating,systime,event_arrive,event_depart,customer)
                event_arrive.append(sum(arrive_list[0:(i+1)+1]))
                i+=1
                step+=1
                customer+=1
                wating= abs(wating-1)
        else:
            tmp = event_depart.popleft()
            event_depart.append(tmp+server_list[j])
            print_ui(1,wating,tmp,event_arrive,event_depart,customer)
            j+=1
            step+=1
            wating+=1


# while 문이 끝나면 
else:
    print("대기열을 추가하시오")  


        


                
    

    