from errno import EDEADLK
import sys

sys.stdin = open("/Users/Hantae/Desktop/Programming/TIL/Coding Test/small_book/input.txt","r")

try:
    while True:
        can_list=list(input().split())
        
        i = 0        
        result = []

        while i<len(can_list):
            if can_list[i] != "*":
                result.append(can_list[i])
            else:
                j = len(result)-2
                while j >= 0:
                    if can_list[j] == "Coke":
                        j -=1
                    else:
                        result.pop(j)
                        break
                    
                
            i+=1
        
        
        print(result)
                
            

except:
    pass    