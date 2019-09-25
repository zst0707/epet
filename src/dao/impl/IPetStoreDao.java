package dao.impl;

import model.Pet;
import model.PetStore;

import java.util.List;

public interface IPetStoreDao {

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
    public List<PetStore> getAllStore();

    /**
     * 查询单个对象
     */
    public PetStore getOneStore(int id);

    /**
     * 培育新宠物方法
     */
    public Pet breed(Pet p);

    /**
     * 商家登录
     */
    public PetStore login(PetStore p);


}
