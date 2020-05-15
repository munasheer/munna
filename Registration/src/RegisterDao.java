import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao 
{
	private String dburl="jdbc:mysql://localhost:3306/database2";
	private String dbuname="root";
	private String dbpassword="mysql";
	private String bddriver="com.mysql.jdbc.Driver";
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		
		Connection con=null;
		try {
			DriverManager.getConnection(dburl, dbuname, dbpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	//User register
	public String insert(Member member)
	{
		loadDriver(bddriver);
		Connection con=getConnection();
		String result="data entered successfully";
		String sql="insert into member values(?,?,?,?)";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, member.getUname());
					ps.setString(2, member.getPass());
					ps.setString(3, member.getEmail());
					ps.setString(4, member.getPhone());
					ps.executeUpdate();
				} catch (SQLException e) {
					
					e.printStackTrace();
					result="Data not enterd";
				}
		
		return result;
		
	}
	
}
