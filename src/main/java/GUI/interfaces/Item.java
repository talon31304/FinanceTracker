package GUI.interfaces;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rick on 9/27/2014.
 */
public interface Item {
    //BoxedItem AddToBox(BoxedItem box);
    Component toComponent();
    JPanel toJPanel();
    JFrame toJFrame(String title);
    JFrame toJFrame(String title, int hSize, int vSize, int hLocation, int vLocation);



}
