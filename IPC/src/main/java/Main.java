
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // Classes
    database db = new database();
    // Variables
      // SQL
      String table_INV = "tabela_investimento";
      String table_INV_name = "Cnome_investimento";
      String table_INV_score = "Cscore_investimento";
      // In Program

    // Stable Connection with SQL server
    Connection connection = database.db_connect();
    if (connection == null) {
      System.out.println("Unable to connect to the database.");
    }

    // Extract INV Table
    List<Object> name_table_INV = database.db_selectTable(table_INV_name,table_INV,true);   // List to store INV_table_name
    // ----------- Confirm Selected INV -----------
    // Pull the selected Investments
      investment INV1 = new investment();
      investment INV2 = new investment();
      investment INV3 = new investment();
      String condition;


    
    // Get scores from selected Investment tables

    // Get the average score from Investment
      


    
    // Calculate upper and lower 2 score*
    // Get Investments in the range*
    // Shows the investments in the range*
    //

  } // Main

  
  }
}
