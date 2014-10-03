package gui.classes.playground;

import gui.abstractClasses.BaseContainer;
import gui.interfaces.JGuiConvertible;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Rick on 9/28/2014.
 */
public class FinanceGUI extends BaseContainer {
    private java.util.List <JGuiConvertible> contents;
    public FinanceGUI() {
    contents= new ArrayList<JGuiConvertible>();
    }

    //public void add(GuiContainer[] subContentItems,int vGap){}
   // public void add(GuiContainer subContentHolder){
     //   contents.add(subContentHolder);
    //}
    public void add(JGuiConvertible[] subContentItems,int vGap){}
    public void add(JGuiConvertible subContent){
        contents.add(subContent);
    }
    public Component toComponent(){
        JPanel panel=new JPanel();
        for (final JGuiConvertible item : contents) {
            panel.add(item.toComponent());
        }
        return panel;
    }
    public JPanel toJPanel(){
        JPanel panel=new JPanel();
        for (final JGuiConvertible item : contents) {
            panel.add(item.toComponent());
        }
        return panel;
    }
    public boolean hasBoxes()
    {
        return !contents.isEmpty();
    }

}
