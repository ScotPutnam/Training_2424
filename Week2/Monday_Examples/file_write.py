file=open("notes.txt", "w")

# must manually enter newline
file.write("Hello World!\n")
file.write("Python\n")
file.write("Scot")
file.writelines("Will this be a new line")
file.close()
