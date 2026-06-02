import re

print("second python")


# numeric datatypes are integer and float
# snakecase

my_integer = 1
my_float = 1.1

# demonstrates pythons interprolation of data types
print(type(my_integer))
print(type(my_float))

# String handles text and words
my_string = "this handles words/text"

# booleans handle True/False operators

# None can be assigned as a type: useful for avoiding errors
my_none = None

# char - not native type in python, instead characters are a string with length 1
my_char = chr(65)
print(my_char)

name = "Scot"

greeting = "Hello " + name

# if you place an f before the first quote you can format a string
formatted_string = f"Hello {name}"

# using regex - re included package
text = "Order ID: 12345"

match = re.search(r'\d+', text)
if match:
    print(f"Found ID:{match.group()}")

# you can also format strings using the .format() method
formatted_by_method_string = "Hello {}".format("Scot")

# slicing strings
my_string = "Hello Scot"
just_hello = my_string[0:5]
print(just_hello)

# using starting index X: grabs all chars from x index to end of string

just_scot = my_string[6:]
print(just_scot)

# using negatg