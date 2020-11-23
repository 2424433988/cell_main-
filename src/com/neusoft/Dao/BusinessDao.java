package com.neusoft.Dao;

import com.neusoft.domain.Business;

import java.lang.invoke.StringConcatFactory;
import java.util.List;

public interface BusinessDao {
    //存储所有商家信息
    public List<Business> listBusiness(String businessName,String businessAddress);
    //保存商家 返回值是保存商家时自动生成的主键id的值
    public int saveBusiness(Business business);
    public int saveBusiness(String BusinessName, String password);
    //删除商家
    public int removeBusiness(Integer BusinessId/*,String BusinessName,String password*/);
    //修改商家
    public int updateBusiness(Business business);
//    public int updateBusiness_password(Integer BusinessId,String BusinessName,String password);

    //通过id查询商家信息
    public Business getBusinessById(int id);

}
