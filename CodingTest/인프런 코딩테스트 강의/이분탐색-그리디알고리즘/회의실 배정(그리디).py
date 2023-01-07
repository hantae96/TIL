
n = 5

meeting = [[1,4],[2,3],[3,5],[4,6],[5,7]]
    
meeting.sort(key=lambda x : (x[1],x[0]))


cnt = 0
endtime = 0
for start,end in meeting:
    if start >= endtime:
        cnt+=1
        endtime = end
        
print(cnt)