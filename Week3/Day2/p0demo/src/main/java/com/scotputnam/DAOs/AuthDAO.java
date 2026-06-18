package com.scotputnam.DAOs;

import com.scotputnam.models.Employee;
import com.scotputnam.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO {

    // using fname and lname as password

    public Employee login(String first_name, String last_name){
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM EMPLOYEES WHERE first_name = ? AND last_name = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, first_name);
            ps.setString(2, last_name);

            ResultSet rs = ps.executeQuery();

            // we only expect a single record
            if(rs.next()){
                return new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                );
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

}
