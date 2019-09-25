package dao;

import common.BaseDao;
import dao.impl.IPetDao;
import model.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PetDao
 * @Description TODO
 * @Author 郑思婷
 * @Date 2019/7/311:04
 * @Version 1.0
 **/
public class PetDao implements IPetDao {
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
     * 获取全部宠物信息
     */
    public List<Pet> getAllPet() {
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pet> petlist = new ArrayList<Pet>();
        String sql = "select * from pet";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Pet p = new Pet();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                p.setBirthday(rs.getString("birthday"));
                p.setHealth(rs.getInt("health"));
                p.setLove(rs.getInt("love"));
                p.setOwnerid(rs.getInt("ownerid"));
                p.setStoreid(rs.getInt("storeid"));
                p.setMoney(rs.getInt("money"));
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

    public Pet getid(int id) {
            /**
            * 查询制定宠物对象
            */
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pet p  = null;
        String sql = "select * from pet where id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            p = new Pet();
            while(rs.next()){
                p.setId(rs.getInt("id"));
                p.setType(rs.getString("type"));
                p.setBirthday(rs.getString("birthday"));
                p.setHealth(rs.getInt("health"));
                p.setLove(rs.getInt("love"));
                p.setName(rs.getString("name"));
                p.setOwnerid(rs.getInt("ownerid"));
                p.setStoreid(rs.getInt("storeid"));
                p.setMoney(rs.getInt("money"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, ps, conn);
        }
        return p;
    }

    public List<Pet> getsomePet(int id) {
        /**
         * 查询某个商店里的宠物
         */
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pet> petlist = new ArrayList<Pet>();
        String sql = "select * from pet where storeid=? and ownerid =0 ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                Pet p = new Pet();
                p.setId(rs.getInt("id"));
                p.setType(rs.getString("type"));
                p.setBirthday(rs.getString("birthday"));
                p.setHealth(rs.getInt("health"));
                p.setLove(rs.getInt("love"));
                p.setName(rs.getString("name"));
                p.setMoney(rs.getInt("money"));
                p.setStoreid(rs.getInt("storeid"));
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

    public List<Pet> getnewPet(int id) {
        /**
         * 查询某个商店里新培育的宠物
         */
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pet> petlist = new ArrayList<Pet>();
        String sql = "select * from pet where storeid=? and ownerid is null";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                Pet p = new Pet();
                p.setId(rs.getInt("id"));
                p.setType(rs.getString("type"));
                p.setBirthday(rs.getString("birthday"));
                p.setHealth(rs.getInt("health"));
                p.setLove(rs.getInt("love"));
                p.setName(rs.getString("name"));
                p.setMoney(rs.getInt("money"));
                p.setStoreid(rs.getInt("storeid"));
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

    public List<Pet> getPet() {
        /**
         * 查询所有商店里的宠物
         */
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pet> petlist = new ArrayList<Pet>();
        String sql = "select * from pet where ownerid =0 ";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Pet p = new Pet();
                p.setId(rs.getInt("id"));
                p.setType(rs.getString("type"));
                p.setBirthday(rs.getString("birthday"));
                p.setHealth(rs.getInt("health"));
                p.setLove(rs.getInt("love"));
                p.setName(rs.getString("name"));
                p.setMoney(rs.getInt("money"));
                p.setStoreid(rs.getInt("storeid"));
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

    public List<Pet> getnewPet() {
        /**
         *查询新培育宠物
         */
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pet> petlist = new ArrayList<Pet>();
        String sql = "select * from pet where ownerid is null ";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Pet p = new Pet();
                p.setId(rs.getInt("id"));
                p.setType(rs.getString("type"));
                p.setBirthday(rs.getString("birthday"));
                p.setHealth(rs.getInt("health"));
                p.setLove(rs.getInt("love"));
                p.setName(rs.getString("name"));
                p.setMoney(rs.getInt("money"));
                p.setStoreid(rs.getInt("storeid"));
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

    public List<Pet> getsomesPet(int id) {
        /**
         *查询宠物主人拥有的宠物
         */
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pet> petlist = new ArrayList<Pet>();

        try {
            String sql = "select * from pet where ownerid =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                Pet p = new Pet();
                p.setId(rs.getInt("id"));
                p.setType(rs.getString("type"));
                p.setBirthday(rs.getString("birthday"));
                p.setHealth(rs.getInt("health"));
                p.setLove(rs.getInt("love"));
                p.setName(rs.getString("name"));
                p.setOwnerid(rs.getInt("ownerid"));
                p.setStoreid(rs.getInt("storeid"));
                p.setMoney(rs.getInt("money"));
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
    public Pet getbuyPet(int id) {
        /**
         *查询目前买到的宠物
         */
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pet p = new Pet();
        try {
            String sql = "select * from pet where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){

                p.setId(rs.getInt("id"));
                p.setType(rs.getString("type"));
                p.setBirthday(rs.getString("birthday"));
                p.setHealth(rs.getInt("health"));
                p.setLove(rs.getInt("love"));
                p.setName(rs.getString("name"));
                p.setOwnerid(rs.getInt("ownerid"));
                p.setStoreid(rs.getInt("storeid"));
                p.setMoney(rs.getInt("money"));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, ps, conn);
        }
        return p;

    }
    public Pet getselllPet(int id) {
        /**
         *查询目前卖出的宠物
         */
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pet p = new Pet();
        try {
            String sql = "select * from pet where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){

                p.setId(rs.getInt("id"));
                p.setType(rs.getString("type"));
                p.setBirthday(rs.getString("birthday"));
                p.setHealth(rs.getInt("health"));
                p.setLove(rs.getInt("love"));
                p.setName(rs.getString("name"));
                p.setOwnerid(rs.getInt("ownerid"));
                p.setStoreid(rs.getInt("storeid"));
                p.setMoney(rs.getInt("money"));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, ps, conn);
        }
        return p;
    }
}
