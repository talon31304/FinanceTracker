package GUI.abstractClasses;
import GUI.interfaces.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;

/**
 * Created by Rick on 9/27/2014.
 */
public  abstract class InsideBox implements BoxedItem{
    private String Title;
    private int HSize,VSize;
    private boolean Visible,Enabled;
    public void render() {

    }
    public void setSize(int hSize,int vSize){}
    public void setLocation(int hLocation,int vLocation){}
    public void setVisible(boolean isVisible){}
    public void setBackgroundColor(String hexColor){}
    public void setBorderWidth(int widthPx){}
    public void setTitle(String title){}
    public String getTitle(){return Title;}
    public int getHSize(){return HSize;}
    public int getVSize(){return getVSize();}
    public boolean isVisible(){return Visible;}
    public void  setEnabled(boolean enabled){}
    public boolean isEnabled(){return Enabled;}
    public void  setVisibility(boolean isVisible){}
    public final void add(BoxedItem innerBox) throws NotImplementedException{
        throw new NotImplementedException();
    }
    public final void addAt(BoxedItem  innerBox, int hPos, int vPos) throws NotImplementedException{
        throw new NotImplementedException();
    }
    public final void add(BoxedItem [] innerBoxes, int vGap) throws NotImplementedException{
        throw new NotImplementedException();
    }
    public  final boolean hasBoxes(){
        return false;
    }
    public JPanel toJPanel()
    {
        JPanel panel= new JPanel();
        panel.add(toComponent());
        return panel;
    }
    public JFrame toJFrame(String title)
    {
        return toJFrame(title,350,200,100,100);
    }
    public JFrame toJFrame(String title,int hSize,int vSize, int hLocation,int vLocation)
    {
        JFrame window = new JFrame(title);
        window.setContentPane(toJPanel());
        window.setSize(hSize,vSize);
        window.setLocation(hLocation,vLocation);
        window.setVisible(true);
        return window;
    }


}




