def check(x,y):
    if (1>x or y>9) or (1>y or y>9):
        return False
    return True


# x_corr = {"a":1,"b":2,"c":3,"d":4,"e":5,"f":6,"g":7,"h":8}


command = input()

# x = x_corr[command[0]]
x = ord(command[0]) - ord("a") + 1 
y = int(command[1])

cnt= 0

for i in (-2,2):
    for j in (-1,1):
        next_x = x+i
        next_y = y+j
        if check(next_x,next_y):
            cnt+=1

for i in (-1,1):
    for j in (-2,2):
        next_x = x+i
        next_y = y+j
        if check(next_x,next_y):
            cnt+=1

print(cnt)