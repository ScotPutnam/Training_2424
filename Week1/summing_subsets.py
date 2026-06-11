
lst = [1,2,1]

subset_sum = 0
start = 0
end = len(lst)
subsets = []
for sets in lst:
    subsets.append(lst[start:end]) 
print(subsets)

result_sum = set(sets for sets in subsets)
print(result_sum)