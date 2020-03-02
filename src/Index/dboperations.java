/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Index; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author KIRAN KN
 */
public class dboperations {
    Connection conn = null;
    dboperations() 
    {
        try 
        {
            conn = Connect.ConnectDB();
        } 
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validate(String u,String p) throws SQLException, Exception
    {
        MD5Hashing m = new MD5Hashing();
        String sql= "select password from `users` where `username`= ?";
        PreparedStatement stmt= conn.prepareStatement(sql);
        stmt.setString(1,u);
        ResultSet rs=stmt.executeQuery();
        if(rs.next())
        {
            String pass =rs.getString("password");
            if(pass.compareTo(m.md5encryption(p))==0)
            {
             return true;
             }
            else
            {
                return false;
            }
        }
        return false;
    }
    
    public void insert_users(String username,String name,String password) throws SQLException
    {
        try {
            MD5Hashing m = new MD5Hashing();
            password = m.md5encryption(password);
            String create1 = "CREATE TABLE IF NOT EXISTS users (username VARCHAR PRIMARY KEY  NOT NULL , name VARCHAR NOT NULL , password VARCHAR)";
            String create2 = "CREATE TABLE IF NOT EXISTS user_files (fno INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , location VARCHAR NOT NULL  UNIQUE , username VARCHAR NOT NULL references users )";
            Statement stmt = conn.createStatement();
            stmt.execute(create1);
            stmt.execute(create2);
            String sql= "insert into users (username,name,password) values('"+username+"','"+name+"','"+password+"')";
            PreparedStatement p;
            p = conn.prepareStatement(sql);
            p.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null ,"You are already registered");
            //Logger.getLogger(dboperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insert_info(String username, String location) throws SQLException
    {
        encdec e = new encdec(location,"a","a");
        String file_location = e.path+"\\"+e.filename+".kkk";
        String statement = "insert into user_files (location,username) values('"+file_location+"','"+username+"')";
        PreparedStatement p=conn.prepareStatement(statement);
        p.execute();
    }
    public void delete_info(String loc) throws SQLException
    {
        String s = "delete from user_files where location = '"+loc+"'";
        PreparedStatement p = conn.prepareStatement(s);
        //p.setString(1, loc);
        p.execute();
    }

    public String getname(String u) throws SQLException, Exception
    {          
            String name = "";
            String sql= "select name from `users` where `username`= ?";
            PreparedStatement stmt= conn.prepareStatement(sql);
            stmt.setString(1,u);
            ResultSet rs=stmt.executeQuery();
            if(rs.next())
            {
                name =rs.getString("name");
            }
            return name;
    }
}