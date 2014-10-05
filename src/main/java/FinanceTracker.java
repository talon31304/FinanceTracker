import dbadapter.DBAdapter;
import dbadapter.DBAdapterImpl;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Keith Boermeester on 10/5/2014.
 */
public class FinanceTracker {

    public static void main(String args[])
    {
        DBAdapter mAdp = new DBAdapterImpl();
        try {

            /*Establish a database connection*/
            Connection mConnection = mAdp.getConnection("jdbc:jtds:sqlserver://localhost:1433/financetracker;", "financeuser", "financeuser");

            /*Close the connection*/
            mConnection.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }


    }

}
