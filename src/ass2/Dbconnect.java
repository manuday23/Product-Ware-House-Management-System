package ass2;
import java.sql.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.*;

public class Dbconnect {
		public int key = 0;
		Scanner sc = new Scanner(System.in);
		private Connection con;
		private Statement st;
		private ResultSet rs;
		
		public Dbconnect(){
			
			try{
				//for Establishing the connection with dbms
				  Class.forName("com.mysql.jdbc.Driver");
				  //con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","2015133");
	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?autoReconnect=true&useSSL=false","root","2015133");
				  st = con.createStatement();
			}catch(Exception ex){
				System.out.println("Error "+ex);
			}
			
		}
		
		
		//For adding data into the purchase table
		public void addData(String username,int id,String pname,int qte,int price,String cat){
			int sn =1;
			try{
				String Querry = "select * from p_table";
				rs = st.executeQuery(Querry);
				while(rs.next())
				{
					sn++;
				}
				
				int total  = price*qte;
				String query = "insert into p_table values("+sn+",'"+username+"','"+pname+"',"+qte+","+price+",'"+cat+"',"+total+");";
				st.executeUpdate(query);
				}catch(Exception ex){
					System.out.println("Error "+ex);
				}
		}
		
		//This section is for getting the pid in purchase table
		int getData(String s){
			int pid =1;
			try{
				String Querry = "select * from purchse";
				rs = st.executeQuery(Querry);
				;
				while(rs.next())
				{
					pid++;
				}
			}catch(Exception ex){
					System.out.println("Error "+ex);
				}
				return pid;
					
		}
		
		
		// for getting the PRO_ID
		public int getData(){
			try{
				String Querry = "select * from new_table";
				rs = st.executeQuery(Querry);
				//System.out.println("Record from database");
				 key = 1;
				while(rs.next()){
					key++;
					/*int key = rs.getInt("Idloinaccount");
					String username = rs.getString("username");
					String password = rs.getString("password");
					System.out.println("KEY : "+ key +"     Username : " +username+ "     Password : "+password);
					*/
				}
				
				
			}catch(Exception ex){
				System.out.println("Error "+ex);
			}
			return key;
		}
		
		
		// Adding new log in details
		public void addData(String name,String username,String password, String phno) {
				
				key =getData();
				
				
				try{
					//String q = "insert into new_table(key,username,password)values("
					String q="insert into new_table values("+key+",'"+name+"','"+username+"','"+password+"','"+phno+"');";
					//String q ="insert into new_table value(5,'Neha','Dhupiya');";
				    st.executeUpdate(q);
					
				}catch(Exception ex){
					System.out.println("Error " +ex);
				}
				
			
			
		}
		
		public boolean checkData(String username , String password){
		
			
			
			
			try{
				//String q = "insert into new_table(key,username,password)values("
				String q = "select username,password from new_table where username = '"+username+"' AND password = '"+password+"';"; 
			
				rs =st.executeQuery(q);
				int  c =0;
				while(rs.next()){
					c++;
				}
				if(c==1)
				{
					//System.out.println("You are logged in "+username);
					JOptionPane.showMessageDialog(null, "Correct Login Credentials");
					c = 0;
					return true;
				
					
				}
				if(c==0)
				{
					//System.out.println("Either credentials are wrong or user does not exist ");
					JOptionPane.showMessageDialog(null, "Either credentials are wrong or user does not exist");
					return false;
				}
			}catch(Exception ex){
				System.out.println("Error " +ex);
	
			}
			return false;
		}
		
		public boolean checkData(String username ){
				
				try{
				//String q = "insert into new_table(key,username,password)values("
				String q = "select username from new_table where username = '"+username+"';";
			
				rs =st.executeQuery(q);
				int  c =0;
				while(rs.next()){
					c++;
				}
				if(c==1)
				{
					c=0;
					return true;
				
					
				}
				if(c==0)
				{
					return false;
				}
			}catch(Exception ex){
				System.out.println("Error " +ex);
	
			}
			return false;
		}
					

			
}
		
		
		
		
		
	


