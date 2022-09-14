import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.sql.Date;

public class you {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:sqlserver://DESKTOP-H55I65M;databaseName=project;encrypt=false;";
		String username = "sa";
		String password = "12345";
		
		try {
			Connection connection =  DriverManager.getConnection(url, username, password);
			Scanner sc = new Scanner(System.in);
			System.out.println("enter data");
			int year = sc.nextInt();
			int month = sc.nextInt();
			int dayOfmonth = sc.nextInt();
		    LocalDate today = LocalDate.now();
		    LocalDate birthday = LocalDate.of(year, month, dayOfmonth);
		    Date sqlDate = Date.valueOf(birthday);
		    int ye= Period.between(birthday, today).getYears();
		    System.out.println(birthday);
		    System.out.println(ye);
		    String sql = "insert into dobtable values(?,?)";
		    PreparedStatement stmt = connection.prepareStatement(sql);
		    stmt.setDate(1,sqlDate);
		    stmt.setInt(2,ye);
		    //Statement st = connection.createStatement();
		    int r = stmt.executeUpdate();
		    if(r>0) {
		    	System.out.println("jai shree ram");
		    }
		    connection.close();
	       }
		catch(SQLException e){
			System.out.println("Oops .");
			e.printStackTrace();
		}
	}

}
