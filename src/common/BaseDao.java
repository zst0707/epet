package common;

import java.sql.*;

/**
 *@ClassName BaseDao（数据库工具类）
 *@Description TODO
 *@Author 郑思婷
 *@Date 2019/6/13  11:11
 *@Version 1.0
 **/
public class BaseDao {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/userpetshop?useSSL=false&useUnicode=true&characterEncoding=utf-8";
    private static String num = "root";
    private static String pwd = "root";
    static Connection conn = null;
    /**
     * 建立连接
     * @return Connection对象
     */
    public static Connection getconn(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,num,pwd);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 关闭连接
     * @param rs
     * @param st
     * @param conn
     */
    public static void closeAll(ResultSet rs, Statement st, Connection conn){
        try {
            if(rs != null)
                rs.close();
            if(st != null)
                st.close();
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

