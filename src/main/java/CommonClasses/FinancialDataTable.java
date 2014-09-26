package CommonClasses;

import java.util.Date;

/**
 * Created by Rick on 9/26/2014.
 */
public interface FinancialDataTable extends DataTable {

    DataSummary getDataSummary();
    void setDataSummary();
}
