from flask import Flask, request, jsonify

app=Flask("__name__")

# @app.route("/student", methods=['GET', 'POST'])
# @app.get("/student")
# def student():
#     data={
#         "name" : "Scot",
#         "year" : "Senior",
#         "gpa" : 2.8
#     }
#     return jsonify(data)
    
@app.get("/students")
def student():
    data=[
        {"id":1,"name":"Scot","course":"Python"},
        {"id":2,"name":"Abdul","course":"Python"}
    ]
    return jsonify(data)

if __name__ == "__main__":
    app.run(debug=True)
