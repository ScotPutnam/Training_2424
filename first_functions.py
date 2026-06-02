# create functions in python using def keyword, name the function, finish with ():, write code in block
# return keyword has function return a value

def basic_function():
    return "This is a basic function"

bf = basic_function()
print(type(bf))
print(basic_function)

def basic_function_2(parameters):
    return parameters + 1

# param casting with :type
# return type declared with ->type
def add_type_annotations(param1:str, param2:int)->str:
    return print(type(param1), type(param2))

output = add_type_annotations("Hello", 1)

print(output)

def annotations_dont_matter(num: int, num2: int) -> int:
    return num + num2

print(annotations_dont_matter(1, 2))
print(annotations_dont_matter("hi ", "everybody"))

# you can add a variable to the end of the parameteres called a variable argument, 
# which takes an unspecified amount of information and places them in a tuple

def variable_arguments (*args): # use this vararg when you dont know how many args function might take
    for element in args:
        print(element)
variable_arguments(1,2,3,4,5, "Hello") # can mix datatypes in lists

# this allows arguments to be taken as key-value pairs. Kwargs is a dictionary 
def key_word_function(**kwargs): ## keyword arguments
    print(kwargs["password"])
    print(kwargs["username"])


key_word_function(password = "my password", username= "my username")

def more_kwargs(**kwargs):
    for key, value in kwargs.items():
        print(f"{key}:{value}")

more_kwargs(first_key="first value", second_key="second value", third_key="third key")
