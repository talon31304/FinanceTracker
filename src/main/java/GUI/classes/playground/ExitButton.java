package GUI.classes.playground;

import GUI.abstractClasses.InsideBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rick on 9/28/2014.
 */
public class ExitButton extends InsideBox {
    private static class ExitButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }


    private String Value;
    private ActionListener Listener;
    public ExitButton(String text)
    {
        Value=text;
        Listener= new ExitButtonHandler();
    }
    public Component toComponent()
    {
        JButton button = new JButton(Value);
        button.addActionListener(Listener);

        return button;
    }
    public JPanel toJPanel()
    {
        JPanel panel= new JPanel();
        panel.add(toComponent());
        return panel;
    }
    public String getValue(){return Value;}
    public void setValue(String value){Value=value;}

}
