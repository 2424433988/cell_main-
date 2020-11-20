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
//        ArrayList<Business> arrayList = (ArrayList<Business>) businessDao.businessList();
//        for (Business business:arrayList){
//            System.out.println(business);
//        }
        System.out.println(businessDao.saveBusiness("小杰",null));
        System.out.println(businessDao.saveBusiness("小华","96732"));
    }
}
