package gui.abstractClasses;
import gui.interfaces.*;

import javax.swing.*;

/**
 * Base abstract class that contains much, but not all functionality needed for GUI objects.
 */

public  abstract class BaseGuiObject implements JGuiConvertible,Renderable {
private boolean enabled,visible;
private int width, height,verticalPosition,horizontalPosition,borderWidth;
private String objTitle,backgroundColor;


    /**
     * Returns the JGuiConvertible object as a  javax.swing.JPanel.
     * @return Returns the JGuiConvertible object as a  javax.swing.JPanel.
     */
    public JPanel toJPanel()
    {
        JPanel panel= new JPanel();
        panel.add(toComponent());
        return panel;
    }

    /**
     *
     * @param title The title of the object.
     * Returns the JGuiConvertible object as a  javax.swing.JFrame.
     * @return
     */
    public JFrame toJFrame(String title)
    {
        return toJFrame(title,350,200,100,100);
    }

    /**
     *
     * @param title The title of the object.
     * @param hSize The width of the object in pixels.
     * @param vSize The height of the object in pixels
     * @param hLocation The horizontal position of the item within the parent
     * @param vLocation The vertical postion of the item within the parent
     * Returns the JGuiConvertible object as a  javax.swing.JFrame.
     * @return
     */
    public JFrame toJFrame(String title,int hSize,int vSize, int hLocation,int vLocation)
    {
        JFrame window = new JFrame(title);
        window.setContentPane(toJPanel());
        window.setSize(hSize,vSize);
        window.setLocation(hLocation,vLocation);
        window.setVisible(true);
        return window;
    }

    /**
     * Sets the size of the object in pixels
     * @param hSize Sets the width of the object in pixels
     * @param vSize Sets the height of the object in pixels
     */
    public void setSize(int hSize, int vSize){
        width=hSize;
        height=vSize;
    }



    /**
     *
     * @param hLocation Sets the vertical location of the the top left corner of the object
     *                  from the top left corner of container.
     * @param vLocation Sets the horizontal location of the the top left corner of the object
     *                  from the top left corner of container.
     */
    public void setLocation(int hLocation, int vLocation)
    {
        verticalPosition=vLocation;
        horizontalPosition=hLocation;
    }

    /**
     * Sets the visibility of the object
     * @param isVisible A boolean value setting the object visible if true, invisible if false.
     */
    public void setVisible(boolean isVisible){visible=isVisible;}

    /**
     * Sets the background color to the given hex color code.
     * @param hexColor A hex color code.
     */
    public void setBackgroundColor(String hexColor){backgroundColor=hexColor;}

    /**
     * Sets the width of the border in pixels
     * @param widthPx The width of the border in pixels
     */
    public void setBorderWidth(int widthPx){borderWidth=widthPx;}

    /**
     * Sets the title of the object to the given string.
     * @param title The title of the object.
     */
    public void setTitle(String title){objTitle=title;}

    /**
     * Returns the title of the object
     * @return Returns the title of the object
     */
    public String getTitle(){return objTitle;}

    /**
     * Returns the width of the object.
     * @return Returns the width of the object.
     */
    public int getHSize(){return width;}

    /**
     * Returns the height of the object.
     * @return Returns the height of the object.
     */
    public int getVSize(){return height;}


    /**
     * Returns the visibility of the object.
     * @return Returns true if teh object is visible or false otherwise.
     */
    public boolean isVisible(){return visible;}

    /**
     * Sets the object as enabled or disabled.
     * @param enabled A boolean value, sets the object visible if true, false otherwise.
     */
    public void  setEnabled(boolean enable)
    {
         enabled=enable;
    }

    /**
     * Returns the enabled status of the object.
     * @return Returns true if the object is enabled or false otherwise.
     */
    public boolean isEnabled(){return enabled;}

}




