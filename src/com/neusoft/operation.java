package com.neusoft;

import com.neusoft.Dao.impl.BusinessDaoImpl;
import com.neusoft.domain.Business;
import com.neusoft.untils.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class operation {
    public static void main(String [] args){
        BusinessDaoImpl businessDao = new BusinessDaoImpl();
        //查询用例
//        ArrayList<Business> arrayList = (ArrayList<Business>) businessDao.businessList();
//        for (Business business:arrayList){
//            System.out.println(business);
//        }
        //保存用例
//        System.out.println(businessDao.saveBusiness("小杰",null));
//       System.out.println(businessDao.saveBusiness("小华","96732"));
        //删除用例
//        int flag= businessDao.removeBusiness(100018,"小华","96732");
//        if (flag==1)System.out.println("删除成功！");
//        else System.out.println("删除失败！");
        //更新用例
        Business business =new Business(200000,"78964","脆皮鸡","街道办","小吃",9000.312,54000.639);
        businessDao.updateBusiness(business);
    }
}
