package GUI.classes.playground;

import GUI.abstractClasses.TableBox;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rick on 9/27/2014.
 */
public class SimpleTable extends TableBox {

    public SimpleTable (String title, Object rowData[][], String columnNames[]) {

        super(title,rowData,columnNames,false);
    }

    public Component toComponent()
    {
        JTable table = new JTable(getRowData(), getColumnNames());
        JScrollPane scrollPane = new JScrollPane(table);
        return scrollPane;
    }
}
