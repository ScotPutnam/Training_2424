package com.scotputnam.DAOs;

import com.scotputnam.models.Role;
import com.scotputnam.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoleDAO {

    public Role getRoleById(int id) {

        try (Connection con = ConnectionUtil.getConnection()){
            String sql  = "select * from role where role_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            

        } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        return null;
    }
