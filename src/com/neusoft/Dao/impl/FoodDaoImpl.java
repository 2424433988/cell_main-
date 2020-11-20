package com.neusoft.Dao.impl;

import com.neusoft.domain.Business;
import com.neusoft.domain.Food;
import com.neusoft.untils.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodDaoImpl {
    public ArrayList<Food> FoodList(){
        ArrayList<Food> arrayList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql= "select * from food";
        try {
            connection = JDBC.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Food food =new Food();
                food.setFoodId(resultSet.getInt(1));
                food.setFoodName(resultSet.getString(2));
                food.setFoodExplain(resultSet.getString(3));
                food.setFoodPrice(resultSet.getDouble(4));
                food.setBusinessId(resultSet.getInt(5));
                arrayList.add(food);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC.close(resultSet,preparedStatement,connection);
        }
        return arrayList;
    }
}
