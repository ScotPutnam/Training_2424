from flask import Flask, request, jsonify

students = [
    {
        "id": 1,
        "name": "Alice",
        "course": "Computer Science"
    },
    {
        "id": 2,
        "name": "Bob",
        "course": "Data Science"
    }
]

app = Flask(__name__)

@app.errorhandler(404)
def not_found(error):
    return jsonify({"error": "not_found", "message": str(error)})

@app.get("/students")
def get_students():
    return jsonify(students)

@app.get("/students/<int:id>")
def get_students_by_id(id):
    for student in students:
        if student['id'] == id:
            return jsonify(student)
    
    return {"error": "bad_request", "message":"Student not found"}, 404
    # return (students[id])

@app.post("/students")
def new_student():
    data=request.json()
    students.append(data)
    return jsonify(data), 201

@app.put("/students/<int:id>")
def update_student(id):
    data=request.json

    if not isinstance(data, dict):
        return {"error": "bad_request", "message": "JSON body must be in object notation key:val"}, 400
    
    for student in students:
        if student['id'] == id:
            students[id].update({"id": id, "name": data["name"], "course":data['course']})
            return jsonify(students), 201
    return {"error": "bad_request", "message":"ID not in table"}

@app.delete("/students/<int:id>")
def delete_student(id):
    for student in students:
        if student['id'] == id:
            students.pop(students.index(student))
            return jsonify(students), 204
    return {"error": "bad_request", "message": "student not in student registry"}, 404

if __name__ == "__main__":
    app.run(debug=True)

