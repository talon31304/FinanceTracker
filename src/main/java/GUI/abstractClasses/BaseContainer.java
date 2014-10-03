package gui.abstractClasses;
import gui.interfaces.GuiContainer;

import javax.swing.*;

/**
 * Base abstract class that contains much, but not all functionality needed for GUI container objects.
 */

public abstract class BaseContainer extends BaseGuiObject implements GuiContainer {

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
}
