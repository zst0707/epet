package dao;

import common.BaseDao;
import dao.impl.IPetStoreDao;
import model.Accounts;
import model.Pet;
import model.PetStore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PetStoreDao
 * @Description TODO
 * @Author 郑思婷
 * @Date 2019/7/311:05
 * @Version 1.0
 **/
public class PetStoreDao implements IPetStoreDao {
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
    /**
     * 返回全部宠物店对象
     */
    public List<PetStore> getAllStore() {
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<PetStore> petstorelist = new ArrayList<PetStore>();
        String sql = "select * from petstore";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                PetStore p = new PetStore();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPassword(rs.getString("password"));
                p.setBalance(rs.getInt("balance"));
                petstorelist.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, ps, conn);
        }
        return petstorelist;
    }

    public PetStore getOneStore(int id) {
        /**
         * 查询单个对象
         */
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        PetStore p = new PetStore();
        String sql = "select * from petstore where id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPassword(rs.getString("password"));
                p.setBalance(rs.getInt("balance"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, ps, conn);
        }

        return p;
    }


    public Pet breed(Pet p) {
        /**
         * 培育新宠物方法
         */
        String sql = "insert into pet(id,name,type,storeid,health,love,birthday,money) values(?,?,?,?,?,?,?,?)";
        Object ob[]={p.getId(),p.getName(),p.getType(),p.getStoreid(),p.getHealth(),p.getLove(),p.getBirthday(),p.getMoney()};
        zsg(sql, ob);
        return p;
    }

    public PetStore login(PetStore p) {
        /**
         * 商家登录
         */
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        PetStore pts = null;
        String sql = "select * from petstore where id=? and password=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(p.getId()));
            ps.setString(2, p.getPassword());
            rs = ps.executeQuery();
            if(rs.next()){
                pts = new PetStore();
                pts.setName(rs.getString("name"));
                pts.setPassword(rs.getString("password"));
                pts.setBalance(rs.getInt("balance"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, ps, conn);
        }
        return pts;
    }
}
