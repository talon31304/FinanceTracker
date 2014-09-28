package GUI.classes.playground;


public class FinanceTrackerApp {

    public static void main(String[] args) {

        FinanceGUI gui= new FinanceGUI();
        gui.add(new SimpleTextItem("You are Broke!!!"));

        String rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3"},
                { "Row2-Column1", "Row2-Column2", "Row2-Column3"} };
        String columnNames[] = { "Column One", "Column Two", "Column Three"};

        gui.add(new SimpleTable("My Data",rowData,columnNames));

        Object rows[][] = { { "Jason","Smith", 23 }, { "Rick","Martel", 24, }, { "Eric","Hanson", 21, },
                { "Ben", "Bergerson",27, }, { "Arthur","Zappo", 25, },
                { "Sara","Martel", 22, }, };

        String columns[] = { "First Name","Last Name", "Age" };

        gui.add(new SortableTable("My Data2",rows,columns));



        gui.add(new SimpleTextItem("Goodbye!"));
        gui.add(new ExitButton("Exit"));
        gui.toJFrame("Finance Tracker",600,600,50,50);
    }

}

