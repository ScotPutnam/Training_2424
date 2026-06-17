# #!/bin/python3

# import math
# import os
# import random
# import re
# import sys

# #
# # Complete the 'superDigit' function below.
# #
# # The function is expected to return an INTEGER.
# # The function accepts following parameters:
# #  1. STRING n
# #  2. INTEGER k
# #

# def superDigit(n, k):
#     # Write your code here
#     p = ""
#     for i in range(k):
#         p += f"{n}"
    
#     total = 0
#     for char in p:
#         temp = int(char)
#         total += temp
    
#     while total > 10:
#         temp = str(total) 
#         print(temp)   
        
        
    
#     return total

# n = "148"
# k = 3

# # print(superDigit(n,k))

# def superDigit2(n, k):

#     p = [int(char) for char in n * k]
    
#     q = sum(p)
#     while q >= 10:
#         temp = [val for val in str(q)]
#         temp2 = [int(val) for val in temp]
#         q = sum(temp2)

#     return q

# print(superDigit2(n, k))


# # if __name__ == '__main__':
# #     fptr = open(os.environ['OUTPUT_PATH'], 'w')

# #     first_multiple_input = input().rstrip().split()

# #     n = first_multiple_input[0]

# #     k = int(first_multiple_input[1])

# #     result = superDigit(n, k)

# #     fptr.write(str(result) + '\n')

# #     fptr.close()

# sample_int = "100 200 10 1 3 2"

# input_arr = []
# for char in sample_int:
#     input_arr.append(sample_int)

# print(input_arr)

# arr = [0, 0, 0, 8, 8, 8, 5, 5, 7]

# dupe_arr = []
# index = 0
# for val in arr:
#     count = 1
    
#     while(val == arr[index + 1]):
#         count += 1
#         arr.pop(index + 1)



#     arr.insert(index, count)
#     index += 1
#     # for value in list if index + 1 == value

inp = [0, 4, 6, 8, 8, 8, 5, 5, 7]

def set_reducer(inp):
    
    dupe_set = []
    for i in range(1, len(inp) - 1, 1):
        
        if(inp[i] is not inp[i + 1]):
            dupe_set.append(1)
        
        if (inp[i] == inp[i + 1]):
            count = 1
            while(inp[i] == inp[i+1]):
                inp.insert(i+1, 1)
                count +=1
                i +=1
            print(count)
    
    print(dupe_set)
    
    

            
        
    

