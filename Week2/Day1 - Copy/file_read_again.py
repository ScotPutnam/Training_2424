try:
    file=open("abc.text", "r")
except FileNotFoundError:
    print("file not found")
finally:
    if file:
        file.close()

