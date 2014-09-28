package GUI.abstractClasses;
import GUI.interfaces.BoxedItem;

import javax.swing.*;

/**
 * Created by Rick on 9/28/2014.
 */
public abstract class BaseBox implements  BoxedItem{

    public void setSize(int hSize,int vSize){}
    public void setLocation(int hLocation,int vLocation){}
    public void setVisible(boolean isVisible){}
    public void setBackgroundColor(String hexColor){}
    public void setBorderWidth(int widthPx){}
    public void setTitle(String title){}
    public String getTitle(){return "";}
    public int getHSize(){return 0;}
    public int getVSize(){return 0;}
    public boolean isVisible(){return true;}
    public void setVisibility(boolean isVisible){}
    public void  setEnabled(boolean enabled){}
    public boolean isEnabled(){return true;}
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
