from flask import Flask, request

app = Flask(__name__)

@app.route("/")
def home():
    return "Hello Flask"

@app.route("/hello_world")
def hello_world():
    return "Hello World"

# sending data to/from server
# Url parameter - path parameter
# /route/<name>
@app.route("/user/<name>")
def get_user(name):
    return f"We found: {name}\nIn our records"

# Query String
# appends to end of url with ? followed by name of the parameter to send
# url appended with /user?="Scot" to test
# request.args.get("name_of_queryparam")
# to send in multiple params use &param=trainer
@app.route("/user1")
def user_1_name():
    name = request.args.get("name")
    return f"{name} was found"

# int:param casts path params
@app.route("/add/<int:num1>/<int:num2>")
def addition(num1, num2):
    # num1 = int(num1)
    # num2 = int(num2)
    result = [num1 + num2]
    return result

# jinja templates

if __name__ == "__main__":
    app.run(debug=True)