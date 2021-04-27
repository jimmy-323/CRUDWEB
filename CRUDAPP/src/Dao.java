import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	
	public static Connection getConnection()
	{
		 String path="jdbc:mysql://localhost/EMPLOYEE_DB";
		 String username="root";
		 String password="";
		
			
			 Connection conn=null;
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection(path, username, password);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    return conn;
	}
	
	public static List<employee> getAll(){
		
		List<employee> emps=new ArrayList<>();
		try {
			
			Connection conn=Dao.getConnection();
			PreparedStatement smt=conn.prepareStatement("select * from file");
			ResultSet rs=smt.executeQuery();
			while(rs.next())
			{
				
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String last=rs.getString(3);
				double salary=rs.getDouble(4);
				employee e=new employee(id,name,last,salary);
				emps.add(e);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emps;
	}
	
	public static boolean delete(int id)
	{
		System.out.print("Call");
		boolean status=false;
		
		Connection conn=Dao.getConnection();
		PreparedStatement smt;
		try {
			smt = conn.prepareStatement("delete from file where id=?");
			smt.setInt(1, id);
			status=smt.execute();
			System.out.print(status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static boolean upadate(employee e)
	{
		boolean status=false;
		Connection conn=Dao.getConnection();
		try {
			PreparedStatement smt=conn.prepareStatement("UPDATE `file` SET `ID`=?,`FIRSTNAME`=?,`LASTNAME`=?,`SALARY`=? WHERE ID=?");
			smt.setInt(1, e.getId());
			smt.setString(2,e.getName());
			smt.setString(3, e.getLast());
			smt.setDouble(4, e.getSalary());
			smt.setInt(5, e.getId());
			status=smt.execute();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}
	
	public static employee getById(int id)
	{
		boolean status=false;
		employee em=null;
		Connection conn=Dao.getConnection();
		try {
			PreparedStatement smt=conn.prepareStatement("select * from file where id=?");
			smt.setInt(1, id);
			ResultSet rs=smt.executeQuery();
			while(rs.next())
			{
				int idd=rs.getInt(1);
				String name=rs.getString(2);
				String last=rs.getString(3);
				double sal=rs.getDouble(4);
				 em=new employee(idd,name,last,sal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return em;
	}

    public static int insert(employee e)
    {
    	int t=0;
    	int id=e.getId();
    	String name=e.getName();
    	String last=e.getLast();
    	double salary=e.getSalary();
    	
    	
    	try {
    		Connection conn=Dao.getConnection();
			PreparedStatement smt=conn.prepareStatement("INSERT INTO `file`(`ID`, `FIRSTNAME`, `LASTNAME`, `SALARY`) VALUES (?,?,?,?)");
			smt.setInt(1, id);
			smt.setString(2, name);
			smt.setString(3, last);
			smt.setDouble(4, salary);
			 t=smt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	return t;
    }
}
