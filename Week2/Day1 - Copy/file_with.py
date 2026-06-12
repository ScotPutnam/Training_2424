import pickle


numbers = [x for x in range(0, 100, 5)]


with open("numbers_dat", "wb") as file:
    pickle.dump(numbers, file)

# with kword calls context manager with automatically opens/clse
with open("num_pick.dat", "rb") as file:
    data = pickle.load(file)

# next: random access
# use tell method - research - tells you what line fptr is on
# use seek method - tell fptr what line to go to