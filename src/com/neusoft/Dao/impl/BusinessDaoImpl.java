package com.neusoft.Dao.impl;

import com.neusoft.Dao.BusinessDao;
import com.neusoft.domain.Business;
import com.neusoft.untils.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {

    public List<Business> businessList(){
        ArrayList<Business> arrayList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql= "select * from business";
        try {
            connection = JDBC.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
            while(resultSet.next()){
                Business business = new Business();
                business.setBusinessId(resultSet.getInt(1));
                business.setPassword(resultSet.getString(2));
                business.setBusinessName(resultSet.getString(3));
                business.setBusinessAddress(resultSet.getString(4));
                business.setBussinessExplain(resultSet.getString(5));
                business.setStarPrice(resultSet.getDouble(6));
                business.setDeliveryPrice(resultSet.getDouble(7));
                arrayList.add(business);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC.close(resultSet,preparedStatement,connection);
        }

        return arrayList;
    }
}
