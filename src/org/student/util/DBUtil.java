package org.student.util;


import org.student.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//数据库帮助类， 数据库增删改查等通用的数据库操作方法
public class DBUtil {

    final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/queryprac";
    final static String USER = "user";
    final static String PSW = "password";
    public static Connection conn = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(URL, USER, PSW);
        return conn;
    }

    public static PreparedStatement createPreparedStatement(String sql, Object[] params) throws SQLException, ClassNotFoundException {
        //通用的数据类型传入使用object数组
        //Object[] obs = {name, age, ………}

        //获取对象链接
        pstmt = getConnection().prepareStatement(sql);
        //setXxxx 的个数跟数组长度一样
        if(params!=null)
            for(int i=0; i<params.length; i++){
                pstmt.setObject(i+1, params[i]);
            }
        return pstmt;
    }

    public static void closeAll(ResultSet rs, Statement stmt, Connection conn){
        try {
            if (conn != null) conn.close();
            if (stmt != null) stmt.close();
            if (rs != null) rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }




    //增删改
    public static boolean executeUpdate(String sql, Object[] params){

        try {

            pstmt = createPreparedStatement(sql, params);
            int count = pstmt.executeUpdate();//如果sql语句不是确定的，不要传入sql参数
            if(count>0)
                return true;
            else
                return false;

        } catch (SQLException se) {
            se.printStackTrace();
            //没有这个student
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeAll(null, pstmt, conn);
        }
    }


    //通用查询: 返回值是一个集合(结果集)
    public static ResultSet executeQuery(String sql, Object[] params){
        try {

            pstmt = createPreparedStatement(sql, params);
            rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException se) {
            se.printStackTrace();
            //没有这个student
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
