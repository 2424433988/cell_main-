package com.neusoft.Dao;

import com.neusoft.domain.Admin;

import java.util.ArrayList;

public interface AdminDao {
    public Admin getAdminIdByNameandPassword(String AdminName, String Password);
}
