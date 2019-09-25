package dao;

import common.BaseDao;
import dao.impl.IPetOwnerDao;
import model.Pet;
import model.PetOwner;
import model.PetStore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PetOwnerDao
 * @Description TODO
 * @Author 郑思婷
 * @Date 2019/7/311:05
 * @Version 1.0
 **/
public class PetOwnerDao implements IPetOwnerDao {
    AccountDao ad=new AccountDao();
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

    public List<PetOwner> getAllower() {
        /**
         * 查询全部主人对象
         */
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<PetOwner> ownerlist = new ArrayList<PetOwner>();
        String sql = "select * from petowner ";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                PetOwner p = new PetOwner();
                p.setId(rs.getInt("id"));
                p.setMoney(rs.getInt("money"));
                p.setName(rs.getString("name"));
                p.setPassword(rs.getString("password"));
                ownerlist.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, ps, conn);
        }
        return ownerlist;
    }

    public void buy(Pet pet, PetOwner p, PetStore ps) {
        /**
         * 主人购买宠物方法
         */
            String sql = "UPDATE pet set ownerid=? WHERE id=?";
            Object[] ob = {p.getId(),pet.getId()};
            int zsg = zsg(sql, ob);
            String sql1 = "UPDATE petowner set money=?  WHERE id=?";
            Object[] ob1 = {(p.getMoney()-pet.getMoney()),p.getId()};
           zsg(sql1, ob1);
            System.out.println(p.getMoney()-pet.getMoney());
            String sql2 = "UPDATE petstore set balance =? WHERE id=?";
            Object[] ob2 = {(ps.getBalance()+pet.getMoney()),ps.getId()};
            zsg(sql2, ob2);
            ad.charge(pet);

    }

    public void Sell(Pet pet, PetOwner p, PetStore ps) {
        /**
         * 卖宠物
         */
        String sql = "UPDATE pet set ownerid=? WHERE id=?";
        Object[] ob = {0,pet.getId()};
        zsg(sql, ob);
        String sql1 = "UPDATE petowner set money=?  WHERE id=?";
        Object[] ob1 = {(p.getMoney()+pet.getMoney()),p.getId()};
        zsg(sql1, ob1);
        System.out.println("您账户所剩元宝数：");
        System.out.println(p.getMoney()+pet.getMoney());
        String sql2 = "UPDATE petstore set balance =? WHERE id=?";
        Object[] ob2 = {(ps.getBalance()-pet.getMoney()),ps.getId()};
        zsg(sql2, ob2);
        System.out.println("商店所剩元宝数：");
        System.out.println(ps.getBalance()-pet.getMoney());
        ad.charge2(pet);
    }

    public PetOwner login(PetOwner p) {
        /**
         * 登录
         * @param p
         * @return
         */
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        PetOwner po = null;
        String sql = "select * from petowner where name=? and password=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getPassword());
            rs = ps.executeQuery();
            if(rs.next()){
                po = new PetOwner();
                po.setId(rs.getInt("id"));
                po.setName(rs.getString("name"));
                po.setPassword(rs.getString("password"));
                po.setMoney(rs.getInt("money"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, ps, conn);
        }
        return po;
    }

    public PetOwner getone(PetOwner p) {
        /**
         * 查询单个
         */
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        PetOwner po = null;
        String sql = "select * from petowner where name=? and password=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getPassword());
            rs = ps.executeQuery();
            if(rs.next()){

                po = new PetOwner();
                po.setId(rs.getInt("id"));
                po.setName(rs.getString("name"));
                po.setPassword(rs.getString("password"));
                po.setMoney(rs.getInt("money"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, ps, conn);
        }
        return po;
    }
    public PetOwner select(int id) {
        /**
         *查询主人
         */
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        PetOwner po = null;
        String sql = "select * from petowner where id= ?";
        try {
            ps = conn.prepareStatement(sql);
           ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){

                po = new PetOwner();
                po.setId(rs.getInt("id"));
                po.setName(rs.getString("name"));
                po.setPassword(rs.getString("password"));
                po.setMoney(rs.getInt("money"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, ps, conn);
        }
        return po;
    }
}
