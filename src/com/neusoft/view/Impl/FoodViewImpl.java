package com.neusoft.view.Impl;

import com.neusoft.Dao.FoodDao;
import com.neusoft.Dao.impl.FoodDaoImpl;
import com.neusoft.domain.Food;
import com.neusoft.view.FoodView;

import java.util.List;
import java.util.Scanner;

public class FoodViewImpl implements FoodView {

    @Override
    public void showFoodList(Integer BusinessId) {
        FoodDao foodDao =new FoodDaoImpl();
        List<Food> foodList = foodDao.listFoodByBusinessId(BusinessId);
        for (Food e : foodList){
            System.out.println(e);
        }

    }

    @Override
    public void saveFood(Integer BusinessId) {
        FoodDao foodDao = new FoodDaoImpl();
        Scanner input = new Scanner(System.in);
        Food food = new Food();
        System.out.println("请输入要保存的食品名称：");
        food.setFoodName(input.next());
        System.out.println("请输入要保存的食品备注：");
        food.setFoodExplain(input.next());
        System.out.println("请输入要保存的食品价格：");
        food.setFoodPrice(input.nextDouble());
        food.setBusinessId(BusinessId);
        int result = foodDao.saveFood(food);
        if(result!=0){
            System.out.println("添加成功！");
        }
        else {
            System.out.println("添加失败！");
        }
    }

    @Override
    public void updateFood(Integer BusinessId) {
        FoodDao foodDao = new FoodDaoImpl();
        Scanner input = new Scanner(System.in);
        Food food = new Food();
        System.out.println("请输入要修改的食品编号：");
        food.setFoodId(input.nextInt());
        System.out.println("请输入要修改的食品名称：");
        food.setFoodName(input.next());
        System.out.println("请输入要修改的食品备注：");
        food.setFoodExplain(input.next());
        System.out.println("请输入要修改的食品价格：");
        food.setFoodPrice(input.nextDouble());
        food.setBusinessId(BusinessId);
        int result = foodDao.updateFood(food);
        if(result!=0){
            System.out.println("修改成功！");
        }
        else {
            System.out.println("修改失败！");
        }
    }

    @Override
    public void removeFood(Integer BusinessId) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要删除的食品编号：");
        Integer foodId= input.nextInt();
        FoodDao foodDao = new FoodDaoImpl();
        int result =foodDao.removeFood(foodId);
        if (result!=0){
            System.out.println("删除成功！");
        }
        else {
            System.out.println("删除失败！");
        }

    }
}
