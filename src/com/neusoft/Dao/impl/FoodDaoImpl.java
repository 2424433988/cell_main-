package com.neusoft.Dao.impl;

import com.neusoft.domain.Business;
import com.neusoft.domain.Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FoodDaoImpl {
    public ArrayList<Food> FoodList(){
        ArrayList<Food> arrayList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql= "select * from food";
    }
}
