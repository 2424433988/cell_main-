package com.neusoft.Dao.impl;

import com.neusoft.Dao.FoodDao;
import com.neusoft.domain.Business;
import com.neusoft.domain.Food;
import com.neusoft.untils.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        List<Food> arrayList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql= "select * from food where businessId = ?";
        try {
            connection = JDBC.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,businessId);
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

    @Override
    public Food getFoodById(Integer FoodId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Food food =new Food();
        String sql= "select * from food where FoodId = ?";
        try {
            connection = JDBC.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,FoodId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                food.setFoodId(resultSet.getInt(1));
                food.setFoodName(resultSet.getString(2));
                food.setFoodExplain(resultSet.getString(3));
                food.setFoodPrice(resultSet.getDouble(4));
                food.setBusinessId(resultSet.getInt(5));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC.close(resultSet,preparedStatement,connection);
        }
        return food;
    }

    @Override
    public int saveFood(Food food) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Integer result =0;
        String sql= "insert into Food(foodName,foodExplain,foodPrice,businessId) values (?,?,?,?)";
        try {
            connection = JDBC.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,food.getFoodName());
            preparedStatement.setString(2,food.getFoodExplain());
            preparedStatement.setDouble(3,food.getFoodPrice());
            preparedStatement.setInt(4,food.getBusinessId());

            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC.close(resultSet,preparedStatement,connection);
        }
        return result;
    }

    @Override
    public int updateFood(Food food) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Integer result =0;
        String sql= "update food set foodName = ? , foodExplain = ? ,foodPrice = ? ,businessId = ? where  foodId = ?";
        try {
            connection = JDBC.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,food.getFoodName());
            preparedStatement.setString(2,food.getFoodExplain());
            preparedStatement.setDouble(3,food.getFoodPrice());
            preparedStatement.setInt(4,food.getBusinessId());
            preparedStatement.setInt(5,food.getFoodId());
            result = preparedStatement.executeUpdate();
            //if (resultSet.next()) result= resultSet.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC.close(resultSet,preparedStatement,connection);
        }
        return result;
    }

    @Override
    public int removeFood(Integer foodId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Integer result =0;
        String sql= "delete from food where  foodId = ?";
        try {
            connection = JDBC.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,foodId);
            result = preparedStatement.executeUpdate();
//            if (resultSet.next()) result= resultSet.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC.close(resultSet,preparedStatement,connection);
        }
        return result;
    }
}
