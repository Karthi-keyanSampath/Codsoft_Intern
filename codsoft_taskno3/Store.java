package com.karthi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class Store {
	Scanner sc = new Scanner(System.in);
	public void connector() throws ClassNotFoundException, SQLException {
	String url = "jdbc:mysql://localhost:3306/student";
	String uname ="root";
	String pass ="1234";
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection(url, uname, pass);

	if(con!=null)
		System.out.println("Connected");
	else
	{
		System.out.println("Not connected");
	}
	}
public void add() throws SQLException{
    System.out.println("Enter Roll No" );
    int userid =sc.nextInt();
    System.out.println("Enter Name");
    String name = sc.next();
    System.out.println("Enter phoneno");
    int phoneno= sc.nextInt();
    System.out.println("Enter email");
    String email = sc.next();
    System.out.println("Enter DOB");
    String DOB = sc.next();
    
    String sql = "insert into login (userid,name,phoneno,email,DOB) values(?,?,?,?,?)";
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");
	PreparedStatement ps1 = con.prepareStatement(sql);
	ps1.setInt(1,userid);
	ps1.setString(2,name);
	ps1.setInt(3,phoneno);
	ps1.setString(4,email);
	ps1.setString(5, DOB);
	ps1.executeUpdate();
	System.out.println("new student data Inserted Successfully");

}
public void display() throws SQLException {
	int userid=0,phoneno=0;
	String name=null,email=null,DOB=null;
	System.out.println("Enter the student ID:");
	userid=sc.nextInt();
	sc.nextLine();
	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");
	 String sql = "select * from login where userid=?";
	 PreparedStatement ps = con.prepareStatement(sql);
	 ps.setInt(1, userid);
	 ResultSet rs=ps.executeQuery();
		while(rs.next()){
			userid=rs.getInt(1);
			name=rs.getString(2);
			phoneno=rs.getInt(3);
			email=rs.getString(4);
			DOB=rs.getString(5);
		System.out.printf("userid :%d\nname: %s\nphoneno:%d\nemail: %s\nDOB: %s\n",userid,name,phoneno,email,DOB);
}
}
public void remove() throws SQLException {
	int userid =0;
	System.out.println("Enter the student ID:");
	userid=sc.nextInt();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");
	 String sql = "delete from login where userid=?";
	 PreparedStatement ps2 = con.prepareStatement(sql);
	 ps2.setInt(1, userid);
	 ps2.executeUpdate();
	 System.out.println("deleted successfully");
}
public void update() throws SQLException {
	System.out.println("Enter Roll No" );
    int userid =sc.nextInt();
    System.out.println("Enter Name");
    String name = sc.next();
    System.out.println("Enter phoneno");
    int phoneno= sc.nextInt();
    System.out.println("Enter email");
    String email = sc.next();
    System.out.println("Enter DOB");
    String DOB = sc.next();
    
    String sql = "update login set name=?,phoneno=?,email=?,DOB=? where userid=?";
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");
	PreparedStatement ps1 = con.prepareStatement(sql);
	ps1.setString(1,name);
	ps1.setInt(2,phoneno);
	ps1.setString(3,email);
	ps1.setString(4, DOB);
	ps1.setInt(5,userid);
	ps1.executeUpdate();
	System.out.println("student data updated Successfully");
}
}
