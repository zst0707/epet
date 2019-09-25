package dao.impl;

import model.Pet;
import model.PetOwner;
import model.PetStore;

import java.util.List;

/**
 * @ClassName IPetOwnerDao
 * @Description TODO
 * @Author 郑思婷
 * @Date 2019/7/310:56
 * @Version 1.0
 **/
public interface IPetOwnerDao {

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
    public List<PetOwner> getAllower();

    /**
     * 主人购买宠物方法
     */
    public void buy(Pet pet, PetOwner p, PetStore ps);

    /**
     * 卖宠物
     */
    public void Sell(Pet pet, PetOwner p, PetStore ps);

    /**
     * 登录
     * @param p
     * @return
     */
    public PetOwner login(PetOwner p);

    /**
     * 查询单个
     */
    public PetOwner getone(PetOwner p);

    /**
     *查询主人
     */
    public PetOwner select(int id);


}
