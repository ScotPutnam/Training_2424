# hardly know her

def gen():
    for x in range(1000000000):
        yield x

g = gen()

print(next(g))
print(next(g))

data = (x for x in range(1000))

print(next(data))