package gui.classes.playground;

import gui.abstractClasses.BaseGridView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

/**
 * Created by Rick on 9/27/2014.
 */
public class SortableTable extends BaseGridView {

    public SortableTable (String title, Object rowData[][], String columnNames[]) {

        setRowData(rowData);
        setColumnNames(columnNames);
        setTitle(title);
        setSortable(true);
    }
    public Component toComponent()
    {
        TableModel model = new DefaultTableModel(getRowData(), getColumnNames()) {
            public Class getColumnClass(int column) {
                Class returnValue;
                if ((column >= 0) && (column < getColumnCount())) {
                    returnValue = getValueAt(0, column).getClass();
                } else {
                    returnValue = Object.class;
                }
                return returnValue;
            }
        };
        JTable table = new JTable(model);
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);
        JScrollPane pane = new JScrollPane(table);
        return pane;
    }

}
