def DFS1():
    # 함수 자신의 지역변수인지를 먼저 확인한다.
    # 지역변수이면 지역변수를 쓴다.
    # 자기의 지역변수에 없다면
    # 전역변수에 찾는다.
    cnt = 3
    print(cnt)

    
def DFS2():
    #전역변수 선언
    global cnt
    if cnt ==5:
        cnt = cnt+1

        print(cnt)
        
        
def DFS3():
    # error를 피하기 위해서 global 선언하고
    global a
    # 로컬리스트로 선언
    # 선언하면 error 안남
    a = a+ [7,8]
    print(a)
        
        
if __name__=="__main__":
    a = [1,2,3]
    cnt = 5
    DFS1()
    DFS2()
    DFS3()
    print(cnt)