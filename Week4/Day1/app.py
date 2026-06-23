from os import getenv

from dotenv import load_dotenv
from sqlalchemy import create_engine, text
import pandas as pd

load_dotenv()
CS = getenv("CS")
engine = create_engine(CS)

query = "SELECT * FROM employees;"
df = pd.read_sql(query, engine)

df.to_sql(
    name = "processed",
    con = engine,
    if_exists="replace",
    index=False
)

# Get input from user
first_name = input("First Name: ")
last_name = input("Last Name: ")
email = input("Email: ")
hire_date = input ('Hire Date (YYYY-MM-DD): ')
salary = float(input("Enter Salary: "))

with engine.begin() as conn:
    result = conn.execute(text("""
    INSERT INTO EMPLOYEES (
    first_name,
    last_name,
    email,
    hire_date,
    salary)
    VALUES (
    :first_name,
    :last_name,
    :email,
    :hire_date,
    :salary)
    RETURNING employee_id;
    """),
    {
        "first_name" : first_name,
        "last_name" : last_name,
        "email" : email,
        "hire_date" : hire_date,
        "salary" : salary

    })
    employee_id = result.scalar()
    print(f"Employee {employee_id} inserted successfully")
