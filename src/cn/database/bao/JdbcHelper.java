package cn.database.bao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.frame.login.GradeBean;


public class JdbcHelper implements JdbcConfig {
    // 获得数据库的连接
    private static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);// 加载数据库驱动
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// 获得数据库连接
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
   
    public static int save(GradeBean grade) {
        String sql = "insert into tb_transcript (studentName, studentClass, testSubject, score, testTime, remark) values (?, ?, ?, ?, ?, ?);";
        Connection conn = getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, grade.getStudentName());
            ps.setString(2, grade.getStudentClass());
            ps.setString(3, grade.getTestSubject());
            ps.setString(4, grade.getScore());
            ps.setString(5, grade.getTestTime());
            ps.setString(6, grade.getRemark());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }
    

    public static int update(GradeBean grade) {
        String sql = "update tb_transcript set studentName = ?, studentClass = ?, testSubject = ?, score = ?, testTime = ?, remark = ? where studentName = ?;";
        Connection conn = getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, grade.getStudentName());
            ps.setString(2, grade.getStudentClass());
            ps.setString(3, grade.getTestSubject());
            ps.setString(4, grade.getScore()); 
            ps.setString(5, grade.getTestTime());
            ps.setString(6, grade.getRemark());
            ps.setString(7, grade.getStudentName());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
          finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
          }
        return -1;
    }
    
    public static List<GradeBean> query(GradeBean grade) {
        String studentName = grade.getStudentName();
        String studentClass = grade.getStudentClass();
        String testSubject = grade.getTestSubject();
        String score = grade.getScore();
        String testTime = grade.getTestTime();
        String remark = grade.getRemark();
        StringBuilder sql = new StringBuilder("select * from tb_transcript where 1=1 ");
        List<GradeBean> results = new ArrayList<GradeBean>();
        Connection conn = getConnection();
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql.toString());
            while (rs.next()) {
                GradeBean tempGrade = new GradeBean();
                tempGrade.setStudentName(rs.getString("studentName"));
                tempGrade.setStudentClass(rs.getString("studentClass"));
                tempGrade.setTestSubject(rs.getString("testSubject"));
                tempGrade.setScore(rs.getString("score"));
                tempGrade.setTestTime(rs.getString("testTime"));
                tempGrade.setRemark(rs.getString("remark"));
                results.add(tempGrade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return results;
    }
    }    

    public static int delete(GradeBean grade) {
        String sql = "delete from tb_transcript where studentName = '"+ grade.getStudentName()  +"'";
        Connection conn = getConnection();
        Statement stat = null;
        try {
            stat = conn.createStatement();
            return stat.executeUpdate(sql);
            
        } catch (SQLException e) {  
            e.printStackTrace();
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }
}
