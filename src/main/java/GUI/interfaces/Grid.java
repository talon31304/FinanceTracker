package GUI.interfaces;

/**
 * Created by Rick on 9/28/2014.
 */
public interface Grid extends BoxedItem{
   boolean isSortable();
   boolean hasData();
   int getRowCount();
   int getColumnCount();
   Object [][] getRowData();
   String [] getColumnNames();
}
