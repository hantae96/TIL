def backTracking(level,count):
    if generation == 1:
        return "Rr"
    else:
        parent=backTracking(level-1,count//4)
        if parent == "Rr":
            return child[count%4]
        else:
            return parent    



if __name__ == "__main__":
    child = ["RR","Rr","Rr","rr"]

    generation,count = map(int,input().split())

    index=backTracking(generation,count-1)
    child[index]
    
    