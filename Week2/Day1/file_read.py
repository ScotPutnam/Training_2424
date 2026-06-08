file=open("data.txt","r")

# Read entire file
# content = file.read()
# print(content)
# print("*"*20)
# Read one line from file
# line_content = file.readline()
# print(line_content)


# read all lines
lines = file.readlines()
print(lines)
file.close()