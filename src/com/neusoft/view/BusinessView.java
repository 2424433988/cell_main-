package com.neusoft.view;

import com.neusoft.domain.Business;

public interface BusinessView {
    public void ListAllBusiness();
    public void SelectBusiness();

    public void saveBusiness();
    public void removeBusiness();
    public Business updateBusiness(Business business);
    public Business updateBusiness_password(Business business);

    public Business login();
}
