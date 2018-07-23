package ass2;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.Query;

/**
*
* @author 1bestcsharp.blogspot.com
*/
public class MyQuery {
	public Connection con;
   
  public Connection getConnection() {
       try {
    	   Class.forName("com.mysql.jdbc.Driver");
			  //con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","2015133");
			    con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?autoReconnect=true&useSSL=false","root","2015133");
       } catch(Exception ex){
			System.out.println("Error "+ex);
		}
       
       return con;
   }
   
   public ArrayList<Product2> BindTable(String s){
       
  ArrayList<Product2> list = new ArrayList<Product2>();
  Connection con = getConnection();
  Statement st;
  ResultSet rs;
  
  try {
  st = con.createStatement();
  rs = st.executeQuery("SELECT `ID_PRO`, `PRO_NAME`, `QTE_IN_STOCK`, `PRICE`, `PRO_IMAGE`, `ID_CAT` FROM `products` Where ID_CAT = '"+s+"'");
  
  Product2 p;
  while(rs.next()){
  p = new Product2(
  rs.getString("ID_PRO"),
  rs.getString("PRO_NAME"),
  rs.getInt("QTE_IN_STOCK"),
  rs.getString("PRICE"),
  rs.getBytes("PRO_IMAGE"),
  rs.getString("ID_CAT")
  );
  list.add(p);
  }
  
  } catch (SQLException ex) {
  Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
  }
  return list;
  }
   
   
   public ArrayList<Product2> BindTable2(String s){
       
	   ArrayList<Product2> list = new ArrayList<Product2>();
	   Connection con = getConnection();
	   Statement st;
	   ResultSet rs;
	   
	   try {
	   st = con.createStatement();
	   //rs = st.executeQuery("SELECT `ID_PRO`, `PRO_NAME`, `QTE_IN_STOCK`, `PRICE`, `PRO_IMAGE`, `ID_CAT` FROM `products` WHERE PRO_NAME = '"+s+"'");
	   rs = st.executeQuery("SELECT * FROM products");
	   Product2 p;
	   while(rs.next()){
	   p = new Product2(
	   rs.getString("ID_PRO"),
	   rs.getString("PRO_NAME"),
	   rs.getInt("QTE_IN_STOCK"),
	   rs.getString("PRICE"),
	   rs.getBytes("PRO_IMAGE"),
	   rs.getString("ID_CAT")
	   );
	   list.add(p);
	   }
	   
	   } catch (SQLException ex) {
	   Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
	   }
	   return list;
	   }
}