package GUI.interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HelloWorld {
        private static class HelloWorldDisplay extends JPanel {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString( "Hello World!", 20, 30 );
            }
        }

        private static class ButtonHandler implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }


        public static void main(String[] args) {

           // HelloWorldDisplay displayPanel = new HelloWorldDisplay();
            JPanel displayPanel = new JPanel();


            //displayPanel
            JButton okButton = new JButton("OK");
            ButtonHandler listener = new ButtonHandler();
            okButton.addActionListener(listener);

            JPanel content = new JPanel();
            content.setLayout(new BorderLayout());
            content.add(displayPanel, BorderLayout.CENTER);
            content.add(okButton, BorderLayout.SOUTH);



            JFrame window = new JFrame("GUI.GUI Test");
            window.setContentPane(content);
            window.setSize(350,300);
            window.setLocation(100,100);
            window.setVisible(true);

        }

    }

