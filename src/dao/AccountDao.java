package dao;

import common.BaseDao;
import dao.impl.IAccountDao;
import model.Accounts;
import model.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static common.BaseDao.getconn;

/**
 * @ClassName AccountDao
 * @Description TODO
 * @Author 郑思婷
 * @Date 2019/7/311:04
 * @Version 1.0
 **/
public class AccountDao implements IAccountDao {
    /**
     * 增删改通用方法
     */
    public int zsg(String sql, Object[] ob) {
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = conn.prepareStatement(sql);
            if(ob != null){
                for (int i = 0; i < ob.length; i++) {
                    ps.setObject(i+1, ob[i]);
                }
            }
            count = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(null, ps, conn);
        }
        return count;
    }
    public static Object data(){
        Object udate = new java.util.Date();//获取系统时间
        Object sdate = new java.sql.Date(((Date) udate).getTime());//类型转换
        return sdate;

    }

    public void charge(Pet pet) {
        /**
         * 商家卖出记账(主人购买)
         */
        String sql = "insert into accounts(dealtype, petid, sellerid, buyerid, price,dealtime) values (?,?,?,?,?,?)";
        Object[] ob = {2,pet.getId(),pet.getStoreid(),pet.getOwnerid(),pet.getMoney(),data()};
        zsg(sql, ob);
    }


    public void charge2(Pet pet) {
        /**
         * 商家买入记账（主人卖出）
         */
        String sql = "insert into accounts(dealtype, petid, sellerid, buyerid, price,dealtime) values (?,?,?,?,?,?)";
        Object[] ob = {1,pet.getId(),pet.getOwnerid(),pet.getStoreid(),pet.getMoney(),data()};
        zsg(sql, ob);
    }
    public List<Accounts> bill(){
        /**
         * 台账
         */
        Connection conn = getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Accounts> petlist = new ArrayList<Accounts>();
        try {
            String sql = "select * from accounts";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Accounts p = new Accounts();
                p.setId(rs.getInt("petid"));
                p.setDealtype(rs.getInt("dealtype"));
                p.setDealtime(rs.getString("dealtime"));
                p.setSellerid(rs.getInt("sellerid"));
                p.setBuyerid(rs.getInt("buyerid"));
                petlist.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, ps, conn);
        }
        return petlist;
    }
}
