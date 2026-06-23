SET search_path TO public;

-- drop if exists
DROP TABLE IF EXISTS employees;

-- create, delete if exists
CREATE TABLE employees (
	employee_id SERIAL PRIMARY KEY,
	first_name VARCHAR(50),
	last_name  VARCHAR(50),
	email VARCHAR(100),
	hire_date DATE DEFAULT CURRENT_DATE,
	salary DECIMAL(10, 2)
);

-- append employee
INSERT INTO employees (first_name, last_name, email, salary) VALUES ('bob','job', 'bobjob123@email.com', 100_000);

-- SELECT ALL Employees
SELECT * FROM employees;

-- SELECT specific column
SELECT first_name, last_name, salary FROM employees;

-- FILTER with where
SELECT * FROM EMPLOYEES WHERE SALARY > 10000;