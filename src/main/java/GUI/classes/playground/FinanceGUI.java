package GUI.classes.playground;

import GUI.abstractClasses.BaseBox;
import GUI.interfaces.BoxedItem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Rick on 9/28/2014.
 */
public class FinanceGUI extends BaseBox {
    private java.util.List <BoxedItem> contents;
    public FinanceGUI() {
    contents= new ArrayList<BoxedItem>();
    }
    public void add(BoxedItem subContentHolder){
        contents.add(subContentHolder);
    }
    public void addAt(BoxedItem subContentHolder, int hPos, int vPos){}
    public void add(BoxedItem [] subContentItems,int vGap){}
    public Component toComponent(){
        JPanel panel=new JPanel();
        for (final BoxedItem item : contents) {
            panel.add(item.toComponent());
        }
        return panel;
    }
    public JPanel toJPanel(){
        JPanel panel=new JPanel();
        for (final BoxedItem item : contents) {
            panel.add(item.toComponent());
        }
        return panel;
    }
    public boolean hasBoxes()
    {
        return !contents.isEmpty();
    }

}
