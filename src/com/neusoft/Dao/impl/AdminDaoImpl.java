package com.neusoft.Dao.impl;

import com.neusoft.domain.Admin;
import com.neusoft.untils.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDaoImpl {
    public ArrayList<Admin> AdminList(){
        ArrayList<Admin> arrayList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql= "select * from admin";
        try {
            connection = JDBC.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Admin admin =new Admin();
                admin.setAdminId(resultSet.getInt(1));
                admin.setAdminName(resultSet.getString(2));
                admin.setPassword(resultSet.getString(3));
                arrayList.add(admin);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC.close(resultSet,preparedStatement,connection);
        }

        return arrayList;
    }
}
