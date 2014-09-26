package CommonClasses;

import java.util.Date;

/**
 * Created by Rick on 9/26/2014.
 */
public interface DataSummary {
    String getTitle();
    void setTitle();
    Date getDataDateRangeStart();
    void setDataDateRangeStart(Date date);
    Date getDataDateRangeEnd();
    void setDataDateRangeEnd(Date date);
    int getPageNumber();
    void setPageNumber();
    int getTotalPages();
    void setTotalPages();

}
