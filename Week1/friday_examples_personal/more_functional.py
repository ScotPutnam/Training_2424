import functools

names = ["Alice", "Bob", "Charlie"]
scores = [85, 92, 78]
grades = ["B", "A", "D"]

all_info = list(zip(names, scores))
print(all_info)

score_dict = dict(zip(names, scores))
print(score_dict)


curved = list(map(lambda x: min(x+5, 100), scores))
print(curved)
