package gui.interfaces;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.Component;

/**
 * interface JGuiConvertible defines the interactions
 * expected to convert the object to usable javax.swing GUI JClasses JFrame and  JPanel, as well as
 * java.awt.Component.
 */
public interface JGuiConvertible {

    /**
     * Returns the JGuiConvertible object as a java.awt.Component.
     * @return Returns the JGuiConvertible object as a java.awt.Component.
     */
    Component toComponent();

    /**
     * Returns the JGuiConvertible object as a  javax.swing.JPanel.
     * @return Returns the JGuiConvertible object as a  javax.swing.JPanel.
     */
    JPanel toJPanel();

    /**
     *
     * @param title The title of the object.
     * Returns the JGuiConvertible object as a  javax.swing.JFrame.
     * @return Returns the JGuiConvertible object as a  javax.swing.JFrame.
     */
    JFrame toJFrame(String title);

    /**
     *
     * @param title The title of the object.
     * @param hSize The width of the object in pixels.
     * @param vSize The height of the object in pixels
     * @param hLocation The horizontal position of the item within the parent
     * @param vLocation The vertical postion of the item within the parent
     * Returns the JGuiConvertible object as a  javax.swing.JFrame.
     * @return Returns the JGuiConvertible object as a  javax.swing.JFrame.
     */
    JFrame toJFrame(String title, int hSize, int vSize, int hLocation, int vLocation);



}
