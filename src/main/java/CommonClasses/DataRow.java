package CommonClasses;

/**
 * Created by Rick on 9/26/2014.
 */
public interface DataRow {
DataCell getCellAt(int index);
DataCell[] getCells();
void add(DataCell cell);
void addAt(int index, DataCell cell);
}
