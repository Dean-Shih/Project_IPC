
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
    String GUI_selected_INV;


    
    // Get scores from selected Investment tables
    String condition;
    for (int i=0; i<=2; i++) {
      condition = table_INV_name + "=" GUI_selected_INV [i] 
    List<Object> score_table_INV [i] = database.db_selectTable(table_INV_score,table_INV, condition, false);
    }
    // Get the average score from Investment
      


    
    // Calculate upper and lower 2 score*
    // Get Investments in the range*
    // Shows the investments in the range*
    //

  } // Main

}