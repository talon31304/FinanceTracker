package dbadapter;


import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Created by kboermeester on 9/28/2014.
 */
public interface DBAdapter {

    Connection getConnection() throws SQLException;

    DriverManager dManager(String ConnectionString) throws SQLException;

    ResultSet getAccounts(Connection conn, String sqlQuery) throws SQLException;

    ResultSet getAccountDetail(Connection conn, String sqlQuery) throws SQLException;

    void addTransaction (Connection conn, String sqlQuery) throws SQLException;

    void deleteTransaction (Connection conn, String sqlQuery) throws SQLException;

    void addReminder (Connection conn, String sqlQuery) throws SQLException;

}
