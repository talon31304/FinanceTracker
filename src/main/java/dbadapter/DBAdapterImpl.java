package dbadapter;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Date;
/**
 * Created by Keith Boermeester on 10/5/2014.
 */
public class DBAdapterImpl implements DBAdapter{
    /*Establish a connection to the database server*/
    @Override
    public Connection getConnection(String connectionString, String user, String password) throws SQLException {
        return DriverManager.getConnection(connectionString, user, password);
    }

    /*Add a user to the database*/
    @Override
    public void addUser(Connection conn, String userId, String firstname, String lastname, String email) throws SQLException {

        try {

            /*Prepare the SQL Statement to add to the user tables*/
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Users (user_id, firstname, lastname, emailaddress)" +
                    " VALUES(?,?,?,?)");
            stmt.setString(1,userId);
            stmt.setString(2,firstname);
            stmt.setString(3, lastname);
            stmt.setString(4,email);

            /*Execute the SQL Statement*/
            stmt.execute();

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /*Return a list of accounts for the current user*/
    @Override
    public void addAccount(Connection conn, String name, String description, String type, String userId) throws SQLException {

        try {



            /*Prepare the SQL Statement to add to the account list*/
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Accounts (name, description, account_type_id, user_id)" +
                    " VALUES(?,?,?,?)");
            stmt.setString(1,name);
            stmt.setString(2, description);
            stmt.setInt(3,getAccountType(conn,type));
            stmt.setString(4,userId);

            /*Execute the SQL Statement*/
            stmt.execute();

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public ResultSet getAccounts(Connection conn, String userId) throws SQLException {

        ResultSet rs = null;

        try {

            /*Prepare the SQL Statement to retrieve the account list*/
            PreparedStatement stmt = conn.prepareStatement("SELECT account_id, name, description, account_type_id, user_id FROM Accounts WHERE user_id = ?");
            stmt.setString(1,userId);

            /*Execute the SQL Statement*/
            rs = stmt.executeQuery();

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return rs;
    }

    /*Get account transaction details for account selected */
    @Override
    public ResultSet getAccountDetail(Connection conn, int account) throws SQLException {

        ResultSet rs = null;

        try {
            /*Prepare the SQL Statement to get the transaction details for the selected account*/
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM AccountDetail WHERE account_id = ?");
            stmt.setInt(1,account);

            /*Execute the SQL Statment*/
            rs = stmt.executeQuery();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return rs;
    }

    /*Add a transaction for to the given account*/
    @Override
    public void addTransaction(Connection conn,int accountID, String type, Double amount, String description, String memo, Timestamp transactionDate) throws SQLException {

        try{

            /*Prepare the SQL Statement to add a new transaction to the current account*/
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO AccountDetail (account_id,transaction_type_id, amount, description, memo, date) " +
                    "VALUES (?,?,?,?,?,?)");

            stmt.setInt(1,accountID);
            stmt.setInt(2,getTransactionType(conn,type));
            stmt.setDouble(3,amount);
            stmt.setString(4,description);
            stmt.setString(5,memo);
            stmt.setTimestamp(6,transactionDate);

            /*Execute the SQL Statement*/
            stmt.executeUpdate();

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }

    /*Delete a transaction from the selected account*/
    @Override
    public void deleteTransaction(Connection conn, int transactionId) throws SQLException {


        try {
            /*Prepare the SQL Statement to delete the transaction detail record for the selected account*/
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM AccountDetail WHERE account_detail_id = ?");
            stmt.setInt(1,transactionId);

            /*Execute the SQL Statement*/
            stmt.execute();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }


    }

    /*Add a reminder so that the user is notified of upcoming transactions*/
    @Override
    public void addReminder(Connection conn, int accountID, String description, Date reminderDate) throws SQLException {

    }

    /*Get the default number of days for reminders*/
    @Override
    public int getReminderDays(Connection conn) {
        int reminderDays = 0;

        try {

            /*Prepare the SQL Statement to get the default reminder days for reminders*/
            Statement stmt = conn.createStatement();

            /*Get the result set and return it*/
            ResultSet rs = stmt.executeQuery("SELECT configuration_value FROM configuration" +
                    " WHERE configuration_property = 'Reminder Days'");

            rs.next();

            reminderDays = rs.getInt("configuration_value");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return reminderDays;
    }

    /*Get the configured path for importing and exporting files*/
    @Override
    public String getImportExportPath (Connection conn) {

        String importexportpath = null;

        try {
            /*Prepare the SQL Statement to get the file path for imports and exports*/
            Statement stmt = conn.createStatement();

            /*Execute the SQL Statement and return the result*/
            ResultSet rs = stmt.executeQuery("SELECT configuration_value FROM configuration" +
                    " WHERE configuration_property = 'Import/Export Path'");

            rs.next();

            importexportpath = rs.getString("configuration_value");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

            return importexportpath;
        }

    @Override
    public int getAccountType (Connection conn, String accountType){

        int accounttype = 0;

        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT account_type_id FROM AccountType WHERE name=?");

            stmt.setString(1,accountType);
            ResultSet rs = stmt.executeQuery();

            rs.next();

            accounttype = rs.getInt("account_type_id");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return accounttype;
    }

    public int getTransactionType (Connection conn, String transactionType) {

        int transtype = 0;

        try {
        /*Prepare the SQL Statement to get the transaction type ID from the database for the passed type*/
            PreparedStatement stmt = conn.prepareStatement("SELECT transaction_type_id FROM transactiontype WHERE name = ?");
            stmt.setString(1, transactionType);

            /*Execute the SQL Statement and store the result in a variable*/
            ResultSet rs = stmt.executeQuery();
            rs.next();

            transtype = rs.getInt("transaction_type_id");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return transtype;

    }
}
