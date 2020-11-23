package com.neusoft.view;

import com.neusoft.domain.Food;

import java.util.List;

public interface FoodView {
    public void showFoodList(Integer BusinessId);
    //添加食品种类
    public void saveFood(Integer BusinessId);
    public void updateFood(Integer BusinessId);

    //删除墨
    public void removeFood(Integer BusinessId);

    //

}
