# import matplotlib.pyplot as plt
# import numpy as np

# plt.plot(np.random.randn(50).cumsum())
# plt.savefig("test1.png")

#######################################################################
# Ternary Expressions:

# x = 1
# y = 2
# result = "lower" if x < y else 'Higher'
# print(result)

#######################################################################
# List Comprehension
list_strings = ["b", "is", "cat", "far", "love", "python"]
words: list = [word.upper() for word in list_strings]

#######################################################################
# Lambdas / Anon Functions
def short_function(x):
    return x*2

equiv_anon = lambda x: x*2

print(short_function(6))
print(equiv_anon(6))

max_val = lambda x , y: x if x > y else y
print(max_val(11,10))

#####################################################################
# Nested list comprehension

all_data = [['John', 'Emily', 'Michael', 'Mary', 'Steven'],
['Maria', 'Juan', 'Javier', 'Natalia', 'Pilar']]

names_of_interest = []
for names in all_data:
    enough_es = [name for name in names if name.count('e') >=2]
    names_of_interest.extend(enough_es)


#####################################################################

some_tuples = [(1,2,3), (4,5,6), (7,8,9)]
# reads as for tuple in some_tuples, grab the value of tuple and return to x
flattened = [x for tup in some_tuples for x in tup]
print(flattened)


import re
def remove_punctuation(word) -> str:
    """ Removes punctuation from word given to function """

    
    return re.sub("[!@#$]", " ", )

clean_ops = [str.strip, remove_punctuation, str.title]