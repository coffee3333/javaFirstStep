package Programm;
import javax.swing.*;


public class View {
    Controller actionListener = new Controller(this);

    JFrame frame = new JFrame("Request App");
    JTextField textField = new JTextField();
    JButton button = new JButton("Get data");
    JLabel mainLabel = new JLabel("Request App");
    JLabel descLabel = new JLabel("Input your name");

    
    public View() {
        textField.setBounds(50,125,200,30);
        mainLabel.setBounds(50, 5, 200, 100);
        descLabel.setBounds(50, 60, 200, 100);
        button.setBounds(50, 200, 200, 30);
        button.addActionListener(actionListener);

        frame.setSize(300, 300);
        frame.add(textField);
        frame.add(button);
        frame.add(mainLabel);
        frame.add(descLabel);
        frame.setLayout(null);        
        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}