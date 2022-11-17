def DFS(level,count):
    global generation
    if generation == level:
        return count
    else:
        DFS(level-1,count/4)




if __name__ == "__main__":
    bio_list = ["RR","Rr","Rr","rr"]

    generation,count = map(int,input().split())

    index=DFS(generation,count)
    bio_list[index]