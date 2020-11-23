package com.neusoft.Dao;

import com.neusoft.domain.Food;

import java.util.ArrayList;
import java.util.List;

public interface FoodDao {
    public List<Food> listFoodByBusinessId(Integer businessId);
    public Food getFoodById(Integer FoodId);
    public int saveFood(Food food);
    public int updateFood(Food food);
    public int removeFood(Integer foodId);

}
