package com.neusoft;

import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;
import com.neusoft.view.AdminView;
import com.neusoft.view.BusinessView;
import com.neusoft.view.Impl.AdminViewImpl;
import com.neusoft.view.Impl.BusinessViewImpl;
import com.neusoft.view.Impl.FoodViewImpl;

import java.util.Scanner;

/**
 * 入驻商户信息管理系统
 */
public class BusinessAdminEntry {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Scanner input = new Scanner(System.in);
        // 商家登录
        BusinessView businessView = new BusinessViewImpl();
        Business business = businessView.login();
        int menu = 0;
        if (business != null){
            System.out.println("商家 "+business.getBusinessName()+ "欢迎您回来！");
            while (menu != 5){
                System.out.println("1. 查看商家信息   2. 修改商家信息    3. 修改密码    4. 所属商品管理   5. 退出系统");
                System.out.println("请输入你要选择的序号");
                menu = input.nextInt();
                switch (menu){
                    case 1:
                        System.out.println(business.toString());
                        break;
                    case 2:
                        business=businessView.updateBusiness(business);
                        break;
                    case 3:
                        business = businessView.updateBusiness_password(business);
                        break;
                    case 4:
                        foodManager(business.getBusinessId());
                        break;
                    case 5:
                        System.out.println("欢迎下次登录");
                        break;
                    default:
                        System.out.println("没有这个选项");
                        break;

                }
            }

        }else {
            System.out.println("登录失败, 用户名密码错误");
        }

    }
    public static  void foodManager(Integer businessId){

        Scanner input =  new Scanner(System.in);
        FoodViewImpl foodView = new FoodViewImpl();
        int menu = 0;
        while (menu != 5){
            System.out.println(">>> 二级菜单  1. 查看食品信息   2. 修改食品信息    3. 增加食品信息    4. 删除食品信息   5. 返回上一级菜单");
            System.out.println("请输入你要选择的序号");
            menu = input.nextInt();
            switch (menu){
                case 1:
                    foodView.showFoodList(businessId);
                    break;
                case 2:
                    foodView.updateFood(businessId);
                    break;
                case 3:
                    foodView.saveFood(businessId);
                    break;
                case 4:
                    foodView.removeFood(businessId);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("没哟这个选项");
                    break;

            }
        }

    }
}
