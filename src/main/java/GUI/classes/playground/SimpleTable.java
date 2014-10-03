package gui.classes.playground;

import gui.abstractClasses.BaseGridView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rick on 9/27/2014.
 */
public class SimpleTable extends BaseGridView {

    public SimpleTable (String title, Object rowData[][], String columnNames[]) {

        setRowData(rowData);
        setColumnNames(columnNames);
        setTitle(title);
        setSortable(false);
    }

    public Component toComponent()
    {
        JTable table = new JTable(getRowData(), getColumnNames());
        JScrollPane scrollPane = new JScrollPane(table);
        return scrollPane;
    }
}
