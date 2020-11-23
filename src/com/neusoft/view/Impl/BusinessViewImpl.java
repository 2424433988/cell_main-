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
    BusinessDao businessDao = new BusinessDaoImpl();

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
        String inputer = input.next();
        if (inputer.equals("y")) {
            int k = businessDao.removeBusiness(i);
            if (k != 0) System.out.println("删除成功！");
            else {
                System.out.println("删除失败！");
            }
        }
        else{
            System.out.println("正在停止删除操作！");
        }
    }

    @Override
    public Business updateBusiness(Business business) {
        Scanner input = new Scanner(System.in);
        String inputer =null;
        Double inputer1 = 0.0;
        System.out.println("请依次选择要修改的信息");

        System.out.println("您想修改的商户名称是：(不修改请忽略该项)");
        inputer = input.next();
        if (inputer != null){
            business.setBusinessName(inputer);
            inputer= null;
        }
        System.out.println("您想修改的商户地址是：(不修改请忽略该项)");
        inputer = input.next();
        if (inputer != null){
            business.setBusinessAddress(inputer);
            inputer= null;
        }
        System.out.println("您想修改的备注是：(不修改请忽略该项)");
        inputer = input.next();
        if (inputer != null){
            business.setBussinessExplain(inputer);
            inputer= null;
        }
        System.out.println("您想修改的起送费是：(不修改请忽略该项)");
        inputer1 = input.nextDouble();
        if (inputer1 != 0.0){
            business.setStarPrice(inputer1);
            inputer1= 0.0;
        }
        System.out.println("您想修改的配送费是：(不修改请忽略该项)");
        inputer1 = input.nextDouble();
        if (inputer1 != 0.0){
            business.setDeliveryPrice(inputer1);
            inputer1= 0.0;
        }
        System.out.println(business);
        businessDao.updateBusiness(business);
        return business;

    }

    public Business updateBusiness_password(Business business){
        Scanner scanner = new Scanner(System.in);
        String ps1 ="";
        String ps2 ="";
        String ps3 ="";
        System.out.println("请输入您的旧密码：");
        ps1 = scanner.next();
        while(!ps1.equals(business.getPassword())){
            System.out.println("请重新输入密码：");
            ps1 = scanner.next();
        }
        while(true){
            System.out.println("请输入新密码：");
            ps2 = scanner.next();
            System.out.println("请再次输入新密码：");
            ps3 = scanner.next();
            if(ps2.equals(ps3)){
                break;
            }
        }
        int i=businessDao.updateBusinesspassword(business.getBusinessId(),ps2);
        if (i!= 0){
            System.out.println("修改成功");
            business.setPassword(ps2);
        }
        else{
            System.out.println("修改失败！");
        }
        return business;
    }
    @Override
    public Business login() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入商家编号");
        Integer businessId = input.nextInt();
        System.out.println("请输入密码");
        String password = input.next();
        BusinessDaoImpl businessDao = new BusinessDaoImpl();
        Business business = null;
        business = businessDao.getBusinessByIdandpassword(businessId,password);
        System.out.println(business);
        return business;
    }

}