package com.neusoft.view.Impl;

import com.neusoft.Dao.AdminDao;
import com.neusoft.Dao.impl.AdminDaoImpl;
import com.neusoft.domain.Admin;
import com.neusoft.view.AdminView;

import java.util.Scanner;

public class AdminViewImpl implements AdminView {
    private Scanner input = new Scanner(System.in);
    //
    public Admin login(){
      System.out.println("请输入用户名：");
      String adminName = input.nextLine();
      System.out.println("请输入密码：");
      String adminpassword = input.nextLine();
      AdminDao adminDao = new AdminDaoImpl();
      Admin admin = adminDao.getAdminIdByNameandPassword(adminName,adminpassword);
      return admin;
    }
}
