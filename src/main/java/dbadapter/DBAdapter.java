package dbadapter;


import java.sql.*;
import java.util.Date;

/**
 * Created by kboermeester on 9/28/2014.
 */
public interface DBAdapter {

    /*Establish a connnection to the database server*/
    Connection getConnection(String connectionString, String user, String Password) throws SQLException;

    /*Add a user to the database*/
    void addUser(Connection conn, String userId, String firstname, String lastname, String email) throws SQLException;

    /*Create an account for the current user*/
    void addAccount(Connection conn, String name, String description, String type, String userId) throws SQLException;

    /*Return a list of accounts for the current user*/
    ResultSet getAccounts(Connection conn,String userId) throws SQLException;

    /*Get account transaction details for account selected */
    ResultSet getAccountDetail(Connection conn, int account) throws SQLException;

    /*Add a transaction for to the given account*/
    void addTransaction (Connection conn,int accountID, String type, Double amount, String description, String memo, Timestamp transactionDate) throws SQLException;

    /*Delete a transaction from the selected account*/
    void deleteTransaction (Connection conn, int transactionId) throws SQLException;

    /*Add a reminder so that the user is notified of upcoming transactions*/
    void addReminder (Connection conn, int accountID, String description, Date reminderDate) throws SQLException;

    /*Get the default number of days for reminders*/
    int getReminderDays (Connection conn);

    /*Get the configured path for importing and exporting files*/
    String getImportExportPath (Connection conn);

    int getAccountType(Connection conn, String accountType);

    int getTransactionType(Connection conn, String transactionType);

}
