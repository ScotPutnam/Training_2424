import logging
import logging.handlers
import os

# one method to log is a print - no level, no timestamp
# no filter, no timestamp, bad way to trace erros
print("[print] Something went wrong")

logging.basicConfig(
    level = logging.DEBUG,
    format = "%(asctime)s | %(levelname)-8s | %(message)s",
    datefmt = "%H:%M:%S",
    force = True   
)

logging.debug("Debug Msg")
logging.warning("Warning Msg")
logging.info("Info Msg")
logging.error("Error Msg")
logging.critical("Critical Msg")

# named logger with stream handler

logger = logging.getLogger("Test_Logger")
logger.setLevel(logging.DEBUG)
logger.handlers.clear()

console = logging.StreamHandler()
console.setLevel(logging.INFO)
console.setFormatter(logging.Formatter(
    " %(levelname)-8s"
))

# file logger with file handler
log_file = "demo_output.log"
file_handler = logging.FileHandler(log_file, mode="w")
file_handler.setLevel(logging.DEBUG)
file_handler.setFormatter(logging.Formatter(
    "%(asctime)s | %(levelname)-8s | %(name)s:%(lineno)d | %(message)s",
    datefmt="%Y-%m-%d %H:%M:%S"
))

logger.addHandler(console)
logger.addHandler(file_handler)
logger.debug("Debug Msg")
logger.warning("Warning Msg")
logger.info("Info Msg")
logger.error("Error Msg")
logger.critical("Critical Msg")

# Logging exceptions

def div(a, b):
    try:
        c = a/b
    except ZeroDivisionError:
        logger.error(f"Division by zero {a}/{b}")
        return None

div(10, 0)

def my_decorator(func):
    def wrapper():
        print("Before function runs")
        func()
        print("After function runs")
    return wrapper()

@my_decorator
def say_hello():
    print("Hello!")

def my_decorator_2(func):
    def wrapper(*args, **kwargs):
        print("Starting func...")
        result = func(*args, **kwargs)
        print("Function finished")
        return result
    return wrapper

@my_decorator
def add(x,y):
    return x + y

print(add(3,5))

