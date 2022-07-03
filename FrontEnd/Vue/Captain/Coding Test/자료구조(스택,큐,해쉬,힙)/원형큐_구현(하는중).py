MAX_QSIZE = 8

class CircularQuue:
    def __init__(self):
        self.front = 0
        self.rear = 0
        self.items = [None] * MAX_QSIZE
        
    def enqueue(self,item):
        self.rear = (self.rear+1)%MAX_QSIZE
        self.items[self.rear] = item
        
    def dequeue(self):
        self.front = (self.front+1)%MAX_QSIZE
        return self.items[self.front]
    
    def view(self):
        print(self.items)
    
key = CircularQuue()

for i in range(8):
    key.enqueue(i+1)



cnt = 1

for i in range(8):
    if cnt == 3:
        key.dequeue()
        cnt = 1
    else:
        cnt+=1
        key.enqueue(i+1)
    
key.view()
            
