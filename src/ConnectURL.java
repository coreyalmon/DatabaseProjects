import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectURL {

    public static void main(String[] args) {
        
        //LOOK HERE! 192.168.69.58 IS MY ADDRESS! USE YOURS!!
        String connectionURL = "jdbc:sqlserver://mommymilkers.asuscomm.com:12001;databaseName=TSQLV4;user=sa;password=PH@123456789";
        
        try (Connection con = DriverManager.getConnection(connectionURL); Statement stmt = con.createStatement();){
            String SQL = "SELECT TOP 10 * FROM Sales.Orders";
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next()) {
                System.out.println(rs.getString("orderid"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}