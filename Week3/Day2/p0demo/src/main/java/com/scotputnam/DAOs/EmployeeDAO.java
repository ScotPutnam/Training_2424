package com.scotputnam.DAOs;

import com.scotputnam.models.Employee;
import com.scotputnam.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO implements EmployeeDAOInterface{

    @Override
    public ArrayList<Employee> getEmployees() {

        // instantiate DB connection
        try(Connection conn = ConnectionUtil.getConnection()){
            // A string to represent our SQL statement
            String sql = "SELECT * FROM employees;";

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            ArrayList<Employee> employeesList = new ArrayList<>();

            while(rs.next()){
                Employee e = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                );
                employeesList.add(e);
            }
            return employeesList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee insertEmployee(Employee emp) {

        // instantiate DB connection
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "insert into employees (first_name, last_name) values (?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, emp.getFirst_name());
            ps.setString(2, emp.getLast_name());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
}
