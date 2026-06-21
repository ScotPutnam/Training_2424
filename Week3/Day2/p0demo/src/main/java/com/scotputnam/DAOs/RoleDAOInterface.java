package com.scotputnam.DAOs;

import com.scotputnam.models.Role;

public interface RoleDAOInterface {
    Role getRoleById(int id);
    Role getRoleByTitle(String title);
}
