package com.neusoft.untils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.ConnectionCallback;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 连接数据库工具
 */
public class JDBC {
    //定义成员变量DATASource
    private static DataSource ds;
    //初始化成员变量
    static {
        try {
            //  加载Properties文件
            Properties pro = new Properties();
            InputStream in =JDBC.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(in);
            //  初始化DataSource对象
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接Connection对象
     * @return 连接对象
     * @throws SQLException
     */
    public static  Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 关闭连接
     * @param statement
     * @param connection
     */
    public static void close(Statement statement, Connection connection){
        close(null,statement,connection);
    }
    public static void close(ResultSet resultSet,Statement statement,Connection connection){
        if (resultSet !=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    





//    Connection conn = null;
//    JDBC(String document,String address) throws ClassNotFoundException, SQLException {
//        Class.forName(document);
//        Connection conn = DriverManager.getConnection(address);
//    }
//    void select(String sql,int index) throws SQLException {
//        Statement stmt = conn.createStatement();
//        ResultSet resultSet = stmt.executeQuery(sql);
//        int i=1;
//        while(resultSet.next()){
//            ;;;;;
//        }
//
//    }
//    void delete(){
//
//    }
//    void update(){
//
//    }
}
