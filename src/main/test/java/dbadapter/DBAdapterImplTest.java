package dbadapter;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class DBAdapterImplTest extends TestCase {

    private DBAdapter mAdp = new DBAdapterImpl();
    private Connection mConnection = null;
    @Before
    public void setUp() throws Exception {

        try {

            /*Setup Database for Tests*/

            mConnection = mAdp.getConnection("jdbc:jtds:sqlserver://localhost:1433/financetracker;", "financeuser", "financeuser");

            /*Add a user*/
            mAdp.addUser(mConnection,"system_user","System","User","test@abc.com");

            /*Add one of each account type*/
            mAdp.addAccount(mConnection, "Test Checking Account", "Test Checking Account", "Checking", "system_user");
            mAdp.addAccount(mConnection, "Test Savings Account", "Test Savings Account", "Savings", "system_user");
            mAdp.addAccount(mConnection, "Test Loan Account", "Test Loan Account", "Loan", "system_user");
            mAdp.addAccount(mConnection, "Test Investment Account", "Test Investment Account", "Investment", "system_user");
            mAdp.addAccount(mConnection,"Test Collateral Account","Test Collateral Account","Collateral","system_user");

        }
        catch (Exception e)
        {

        }

    }

    @After
    public void tearDown() throws Exception {

        PreparedStatement stmt = null;

        /*Clean up test data*/
        stmt = mConnection.prepareStatement("DELETE FROM AccountDetail");
        stmt.execute();

        stmt = mConnection.prepareStatement("DELETE FROM Accounts");
        stmt.execute();

        stmt = mConnection.prepareStatement("DELETE FROM Users");
        stmt.execute();

    }

    /*If the connection isn't closed, assume we have a connections*/
    @Test
    public void testGetConnection() throws Exception{
        assertEquals("DB Connection Open",mConnection.isClosed(),false);
    }

    /*Check to see if we added a user during setup*/
    @Test
    public void testAddUser() throws Exception {
        //mAdp.addAccount(mConnection,);
        PreparedStatement stmt = mConnection.prepareStatement("SELECT COUNT(*) as count FROM Users");

        ResultSet rs = stmt.executeQuery();
        rs.next();
        assertEquals("User Added to DB: ",1,rs.getInt("count"));

    }

    /*Check to see if we have all accounts added during setup*/
    @Test
    public void testAddAccount() throws Exception {
        PreparedStatement stmt = mConnection.prepareStatement("SELECT COUNT(*) as count FROM Accounts");

        ResultSet rs = stmt.executeQuery();
        rs.next();
        assertEquals("Accounts Added to DB: ",5,rs.getInt("count"));
    }

    /*Query the database, and see if we have all accounts that were added during setup*/
    @Test
    public void testGetAccounts() throws Exception {


        int counter = 0;
        ResultSet rs =  mAdp.getAccounts(mConnection, "system_user");
        while (rs.next()) {
            counter++;
        }
        assertEquals("Accounts Queried from DB: ",5,counter);
    }

    /*See if we have the correct number of transactions.  One transaction will be added for each transaction type
    and account*/
    @Test
    public void testGetAccountDetail() throws Exception {
        int counter = 0;
        int adcounter = 0;
        ResultSet rs = mAdp.getAccounts(mConnection, "system_user");
        ResultSet adrs = null;

        while (rs.next()) {
            counter++;

            adrs = mAdp.getAccountDetail(mConnection,rs.getInt("account_id"));

            while (adrs.next()) {
                adcounter++;

            }

        }
        PreparedStatement stmt = mConnection.prepareStatement("SELECT COUNT(*) as count FROM AccountDetail");

        rs = stmt.executeQuery();

        rs.next();
        int count = rs.getInt("count");

        assertEquals("Transactions Queried from DB: ",adcounter,count);

    }

    /*Add transactions to the database, and ensure all of them were added.  One transaction will be added for
    each transaction type and account*/
    @Test
    public void testAddTransaction() throws Exception {

        Calendar mCal = Calendar.getInstance();
        Timestamp mDate = new Timestamp(mCal.getTimeInMillis());

        int counter = 0;
        ResultSet rs = mAdp.getAccounts(mConnection, "system_user");

        while (rs.next()) {
            counter++;

            mAdp.addTransaction(mConnection, rs.getInt("account_id"), "Deposit", 1.00, "Test Deposit", "Test Memo",mDate);
            mAdp.addTransaction(mConnection, rs.getInt("account_id"), "Withdrawal", 1.00, "Test Withdrawal", "Test Memo",mDate);
            mAdp.addTransaction(mConnection, rs.getInt("account_id"), "Loan Payment", 1.00, "Test Loan Payment", "Test Memo",mDate);
            mAdp.addTransaction(mConnection, rs.getInt("account_id"), "Collateral Adjustment - Increase", 1.00, "Test Collateral Adjustment - Increase", "Test Memo",mDate);
            mAdp.addTransaction(mConnection, rs.getInt("account_id"), "Collateral Adjustment - Decrease", 1.00, "Test Collateral Adjustment - Decrease", "Test Memo",mDate);

        }

        PreparedStatement stmt = mConnection.prepareStatement("SELECT COUNT(*) as count FROM AccountDetail");

        rs = stmt.executeQuery();

        rs.next();
        int count = rs.getInt("count");

        assertEquals("Transactions Added to DB: ",counter*5,count);
    }

    /*Be sure transactions can be deleted.  Delete all transactions for all accounts and ensure the table is empty*/
    @Test
    public void testDeleteTransaction() throws Exception {

        testAddTransaction();

        int counter = 0;
        int adcounter = 0;
        ResultSet rs = mAdp.getAccounts(mConnection, "system_user");
        ResultSet adrs = null;

        while (rs.next()) {
            counter++;

            adrs = mAdp.getAccountDetail(mConnection,rs.getInt("account_id"));

            while (adrs.next()) {
                adcounter++;
                mAdp.deleteTransaction(mConnection,adrs.getInt("account_detail_id"));

            }

        }
        PreparedStatement stmt = mConnection.prepareStatement("SELECT COUNT(*) as count FROM AccountDetail");

        rs = stmt.executeQuery();

        rs.next();
        int count = rs.getInt("count");

        assertEquals("Transactions Queried from DB (Delete): ",0,count);
    }

    @Test
    public void testAddReminder() throws Exception {

    }

    /*Get the default number of days for a reminder*/
    @Test
    public void testGetReminderDays() throws Exception {

        int days = mAdp.getReminderDays(mConnection);

        assertEquals("Reminder Days: ",7,days);

    }

    /*Test the defaul path for import and export*/
    @Test
    public void testGetImportExportPath() throws Exception {
        String path = mAdp.getImportExportPath(mConnection);

        assertEquals("Import Export Path: ","C:\\FinanceTracker\\Files\\",path);
    }
}