package com.neusoft.view.Impl;

import com.neusoft.Dao.BusinessDao;
import com.neusoft.Dao.impl.BusinessDaoImpl;
import com.neusoft.domain.Business;
import com.neusoft.view.BusinessView;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView {
    Scanner input = new Scanner(System.in);
    String inputer ="";
    BusinessDao businessDao = null;

    @Override
    public void ListAllBusiness() {
        businessDao = new BusinessDaoImpl();
        List<Business> businessList = businessDao.listBusiness("", "");
//        System.out.printf("%-10s %-10s %-40s %-10s %-10s","商家编号","商家名称","商家地址","商家备注","配送费","起送金额");
//        System.out.println();
        System.out.println("商家编号" + "\t" + "商家名称" + "\t" + "商家地址" + "\t" + "商家备注" + "\t" + "商家配送费" + "\t" + "商家起送费");
        for (Business b : businessList) {
//            System.out.printf("%-10s %-10s %-40s %-10s %-10s",b.getBusinessId(),b.getBusinessName(),b.getBusinessAddress(),b.getBussinessExplain(),b.getDeliveryPrice(),b.getStarPrice());
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t" + b.getBussinessExplain() + "\t" + b.getDeliveryPrice() + "\t" + b.getStarPrice());
//            System.out.println();
        }
    }

    @Override
    public void SelectBusiness() {
        Scanner input = new Scanner(System.in);
        String inputer = "";
        businessDao = new BusinessDaoImpl();
        String businessName = "";
        String businessAddress = "";
        System.out.println("请确认是否输入商家名称关键字(y/n):");
        inputer = input.nextLine();
        if (inputer.equals("y")) {
            System.out.println("请输入商家名称关键字");
            businessName = input.nextLine();
        }
        System.out.println("请确认是否输入商家地址关键字(y/n):");
        inputer = input.nextLine();
        if (inputer.equals("y")) {
            System.out.println("请输入商家地址关键字");
            businessAddress = input.nextLine();
        }
        List<Business> businessList = businessDao.listBusiness(businessName, businessAddress);
//        System.out.printf("%-10s %-10s %-40s %-10s %-10s %-10s","商家编号","商家名称","商家地址","商家备注","配送费","起送金额");
//        System.out.println();
        if (businessList == null) System.out.println("未查询到该商家！");
        else {
            System.out.println("商家编号" + "\t" + "商家名称" + "\t" + "商家地址" + "\t" + "商家备注" + "\t" + "商家配送费" + "\t" + "商家起送费");
            for (Business b : businessList) {
//            System.out.printf("%-10s %-10s %-40s %-10s %-10s &-10s",b.getBusinessId(),b.getBusinessName(),b.getBusinessAddress(),b.getBussinessExplain(),b.getDeliveryPrice(),b.getStarPrice());
//            System.out.println();
                System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t" + b.getBussinessExplain() + "\t" + b.getDeliveryPrice() + "\t" + b.getStarPrice());

            }
        }
    }

    @Override
    public void saveBusiness() {
        String businessName = "";
        String password = "";
        BusinessDao businessDao = new BusinessDaoImpl();
        System.out.println("请输入商户名称：");
        businessName = input.nextLine();
        System.out.println("请输入密码");
        password = input.nextLine();
        Integer i = businessDao.saveBusiness(businessName, password);
        System.out.println("您的商户编号为:" + i);
    }

    @Override
    public void removeBusiness() {
        System.out.println("请输入您要删除的商户编号");
        Integer i = input.nextInt();
        System.out.println("请确认是否删除？(y/n)");
        inputer = input.nextLine();
        if (inputer.equals("y")) {
            int k = businessDao.removeBusiness(i);
            if (k != 0) System.out.println("删除成功！");
            else {
                System.out.println("删除失败！");
            }
        }
        if (inputer.equals("n")){
            System.out.println("正在停止删除操作！");
        }
    }
}