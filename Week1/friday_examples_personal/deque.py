from collections import deque

d = deque([])

d.append("jo1")
d.appendleft("bo1")
d.append("jo2")
d.appendleft("bo2")

print(d)

flat = ""
for x in d:
    flat += x

print(flat)

d.popleft()