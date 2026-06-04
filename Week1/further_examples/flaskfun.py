from flask import Flask, request

# tells flask to look for resources
app: Flask = Flask(__name__)

count = 0

data_set = {"one": 1, "two": "two", "Three": 4}

@app.route("/", methods=["GET"])
def hello_world():
    return "Hello World"

@app.route("/<num1>/add/<num2>", methods=["GET"])
def addition (num1:str, num2:str) -> str:
    result = int(num1) + int(num2)
    return str(result)

credentials = {}
@app.route("/login", methods=["POST"])
def login():
    credentials = request.get_json()
    username = credentials["username"]
    password = credentials["password"]

@app.route("/count", methods=["PUT"])
def add_count():
    global count
    count += 1

@app.route("/data") # route includes query param
def query_database():
    query = request.args["DB"]
    if query == "":
        return data_set
    else:
        return data_set[query]

app.run()