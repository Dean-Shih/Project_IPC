import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class database {
  // Database Connect
  public static Connection db_connect() {
    final String dbUrl = "jdbc:postgresql://your-database-server:5432/your-database-name"; // DB URL
    final String username = "your-username";
    final String password = "your-password";

    Connection connection = null;
    try {
      connection = DriverManager.getConnection(dbUrl, username, password);
      System.out.println("Connection established.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

  // Database Close Connection
  public static void db_closeConnect(Connection connection) {
      try {
        connection.close();
        System.out.println("Connection closed.");
      } catch (SQLException e) {
        e.printStackTrace();
      }
  }

  // Database Select Table
  public static List<Object> db_selectTable(String colum, String table, boolean isString) {
    List<Object> db_selected = new ArrayList<Object>();
    String sql_command = "SELECT" + colum + "FROM" + table;
      try (
        Connection connection = db_connect();
        PreparedStatement pstmt = connection.prepareStatement(sql_command);
        ResultSet rs = pstmt.executeQuery()) {
          while (rs.next()) {
            if (isString = true) {
            db_selected.add(rs.getString(colum));
          } else {
            db_selected.add(rs.getInt(colum));
          }
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    return db_selected;
    }
  // Database Select Table CONDITIONAL
    public static List<Object> db_selectTable(String colum, String table, String condition, boolean isString) {
      List<Object> db_selected = new ArrayList<Object>();
      String sql_command = "SELECT" + colum + "FROM" + table + "WHERE" + condition;
        try (
          Connection connection = db_connect();
          PreparedStatement pstmt = connection.prepareStatement(sql_command);
          ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
              db_selected.add(rs.getString(colum));
            }
  
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return db_selected;
        }
      }

}

}
