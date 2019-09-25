package service.impl;

import model.Pet;

import java.util.List;

public interface IPetService {
    public void selectallpet();//查询全部宠物
    public Pet selectpet(int id);//查询单个
    public void selectstorepet(int id);//查询某个商店里的宠物
    public void getallpet(); //查询所有商店里的宠物
    public void selectnewpet();//查询新培育宠物
    public void selectownerpet(int id);//查询宠物主人拥有的宠物
    public void getnewpet(int id);//查询某个商店里新培育的宠物
    public Pet getbuypet(int id);//查询所购买的宠物
    public Pet getsellpet(int id);//查询所卖出的宠物
}
