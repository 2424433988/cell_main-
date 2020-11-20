package com.neusoft.Dao.impl;

import com.neusoft.Dao.BusinessDao;
import com.neusoft.domain.Business;
import com.neusoft.untils.JDBC;

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

    /**
     * 删除商户
     * @param BusinessId 商户id
     * @param BusinessName  商户名称
     * @param password 商户账号密码
     * @return
     */
    public int removeBusiness(Integer BusinessId, String BusinessName, String password){
        int result = 0;
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        String sql = "delete from business where businessId = ? and businessName = ? and password = ?;";
        try {
            connection = JDBC.getConnection();
            //开启事务
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,BusinessId);
            preparedStatement.setString(2,BusinessName);
            preparedStatement.setString(3,password);
            result = preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception throwables) {
            result = 0;
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }finally {
            JDBC.close(resultSet,preparedStatement,connection);
        }
        return result;

    }

    /**
     * 更新商户信息
     * @param business 商户
     * @return
     */
    //存在问题
    public int updateBusiness(Business business){
        int result = 0;
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "update business set businessName = ? ,businessAddress = ? ,businessExplain =? , starPrice =?,deliveryPrice=? where businessId =?";
        try {
            connection = JDBC.getConnection();
            //开始事务
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            if(business.getBusinessName()!=null) preparedStatement.setString(1, business.getBusinessName());
            if(business.getBusinessAddress()!=null) preparedStatement.setString(2, business.getBusinessAddress());
            if(business.getBussinessExplain()!=null) preparedStatement.setString(3, business.getBussinessExplain());
            if (business.getStarPrice()!=0.0) preparedStatement.setDouble(4,business.getStarPrice());
            if (business.getDeliveryPrice()!=0.0) preparedStatement.setDouble(5,business.getDeliveryPrice());
            preparedStatement.setInt(6,business.getBusinessId());
            result = preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException throwables) {
            result = 0;
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }finally {
            JDBC.close(resultSet,preparedStatement,connection);
        }
        return result;
    }
//    public int updateBusiness_password(Integer BusinessId,String BusinessName,String password){
//
//    }
    public Business getBusinessById(int id){
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Business business = null;
        String sql = "select * from business where businessId = ?;";
        try {
            connection = JDBC.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,business.getBusinessId());
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                business.setBusinessId(resultSet.getInt("businessId"));
                business.setBusinessName(resultSet.getString("businessName"));
                business.setBusinessAddress(resultSet.getString("businessAddress"));
                business.setBussinessExplain(resultSet.getString("businessExplain"));
                business.setStarPrice(resultSet.getDouble("starPrice"));
                business.setDeliveryPrice(resultSet.getDouble("deliveryPrice"));
                business.setPassword(resultSet.getString("password"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC.close(resultSet,preparedStatement,connection);
        }
        return  business;
    }
}
