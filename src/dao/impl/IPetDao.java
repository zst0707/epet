package dao.impl;

import model.Pet;

import java.util.List;

public interface IPetDao {
    /**
     * 增删改通用方法
     * @param sql
     * @param ob
     * @return
     */
    public int zsg(String sql, Object[] ob);

    /**
     * 查询所有方法
     * @return
     */
    public List<Pet> getAllPet();

    /**
     * 查询制定宠物对象
     */
    public Pet getid(int id);


    /**
     * 查询某个商店里的宠物
     */
    public List<Pet> getsomePet(int id);


    /**
     * 查询某个商店里新培育的宠物
     */
    public List<Pet> getnewPet(int id);

    /**
     * 查询所有商店里的宠物
     */
    public List<Pet> getPet();

    /**
     *查询新培育宠物
     */
    public List<Pet> getnewPet();


    /**
     *查询宠物主人拥有的宠物
     */
    public List<Pet> getsomesPet(int id);

    /**
     *查询目前买到的宠物
     */
    public Pet getbuyPet(int id);

    /**
     *查询目前卖出的宠物
     */
    public Pet getselllPet(int id);





}
