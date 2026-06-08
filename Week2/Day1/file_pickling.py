import pickle

file = open("num_pickles.py", "wb")

numbers = [i for i in range(0, 100, 10)]
pickle.dump(numbers, file)
file.close()

file = open("num_pickles.py", "rb")
data = pickle.load(file)
print(data)
data = file.close()