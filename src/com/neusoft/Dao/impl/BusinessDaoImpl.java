package com.neusoft.Dao.impl;

import com.neusoft.Dao.BusinessDao;
import com.neusoft.domain.Business;
import com.neusoft.untils.JDBC;

import java.security.interfaces.RSAKey;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {

    /**
     * 查询所有商户信息
     * @return List<Business>
     */
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

    /**
     * 新添加一名商户的名称
     * @param BusinessName
     * @return 新加商户所生成的主键id
     */
    public int saveBusiness(String BusinessName,String password){
        int BusinessId = 0;
        if (password==null)password = "123456";
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        String sql = "insert into Business(BusinessName,password) values (?,?)";
        try {

            connection = JDBC.getConnection();
            preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,BusinessName);
            preparedStatement.setString(2,password);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                BusinessId = resultSet.getInt(1);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBC.close(resultSet,preparedStatement,connection);
        }
        return BusinessId;
    }
    public int saveBusiness(Business business){
        int BusinessId=0;
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        String sql = "insert into Business(BusinessName,password,businessAddress,businessExplain,starPrice,deliveryPrice) values (?,?,?,?,?,?)";
        try {

            connection = JDBC.getConnection();
            preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,business.getBusinessName());
            preparedStatement.setString(2,business.getPassword());
            preparedStatement.setString(3,business.getBusinessAddress());
            preparedStatement.setString(4, business.getBussinessExplain());
            preparedStatement.setDouble(5,business.getStarPrice());
            preparedStatement.setDouble(6,business.getDeliveryPrice());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                BusinessId = resultSet.getInt(1);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC.close(resultSet,preparedStatement,connection);
        }
        return BusinessId;
    }
//    /**
//     * 删除商户
//     * @param BusinessName
//     * @return  删除结果
//     */
//    public boolean removeBusiness(Integer Id,String BusinessName,String password){
////        int BusinessId = 0;
//        Connection connection =null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet =null;
//        String sql = "insert into Business(BusinessName,password) values (BusinessName,password)";
//        try {
//
//            connection = JDBC.getConnection();
//            preparedStatement = connection.prepareStatement(sql);
//            resultSet = preparedStatement.getGeneratedKeys();
//
//        } catch (Exception throwables) {
//            throwables.printStackTrace();
//        }
//
//
//    }
}
