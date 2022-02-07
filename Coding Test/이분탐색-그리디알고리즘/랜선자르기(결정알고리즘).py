k = 4
N = 11

LAN_length = [802,743,457,539]

tmp = 1

dic1={}
dic2={}
dic3={}
dic4={}

for i in LAN_length:

    while i >=tmp:
        counting = 0
        if i == 802:
            slice=i//tmp
            counting = i//slice
            dic1 = {i:counting}
            tmp+=1
        elif i == 743:
            slice=i//tmp
            counting = i//slice
            dic2 = {i:counting}
        elif i == 457:
            slice=i//tmp
            counting = i//slice
            dic3 = {i:counting}
        else:
            slice=i//tmp
            counting = i//slice
            dic4 = {i:counting}
            
        print(dic1)
    

        