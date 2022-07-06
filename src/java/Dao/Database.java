package Dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private static Connection conn = null;
    private static Statement stmt = null;

    public Database() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static void ketNoiDB() throws FileNotFoundException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlphongmayvalth", "root", "");
            stmt = conn.createStatement();
            stmt.executeQuery("set names 'utf8'");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet select(String cmd) {
        ResultSet rs = null;
        try {
            ketNoiDB();
            rs = stmt.executeQuery(cmd);
        } catch (Exception e) {
            System.err.print(e);
        }

        return rs;
    }

    public boolean update(String cmd) {
        boolean result;
        try {
            int primkey = 0 ;
            ketNoiDB();
            stmt.execute(cmd);
            
            result = true;
        } catch (Exception e) {
            System.err.print(e);
            result = false;
        }
        return result;
    }
}
