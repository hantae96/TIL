num = int(input())
string = ""
count = 0

for i in range(num):
    string=input()
    check_list = []
    for i in range(len(string)):
        if string[i] not in check_list:
            check_list.append(string[i])
            Flag = True
            for j in range(i+1,len(string)):
                if string[i] != string[j]:
                    Flag = False
                    break
        else:
            continue
        
        
            
    
    if Flag:
        count+=1



print(count)