package GUI.classes.playground;

import GUI.abstractClasses.InsideBox;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rick on 9/27/2014.
 */
public class SimpleTextItem extends InsideBox {
    private String Value;
    public SimpleTextItem(String text)
    {
        Value=text;
    }
    public Component toComponent()
    {
        return new JLabel(Value);
    }


    public String getValue(){return Value;}
    public void setValue(String value){Value=value;}
}
