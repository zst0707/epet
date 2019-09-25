package dao.impl;

import model.Accounts;
import model.Pet;

import java.util.List;

public interface IAccountDao {
    /**
     * 增删改通用方法
     * @param sql
     * @param ob
     * @return
     */
    public int zsg(String sql, Object[] ob);
    /**
     * 商家卖出记账(主人购买)
     */
    public void charge(Pet pet);
    /**
     * 商家买入记账（主人卖出）
     */
    public void charge2(Pet pet);
    /**
     * 台账
     */
    public List<Accounts> bill();
}
