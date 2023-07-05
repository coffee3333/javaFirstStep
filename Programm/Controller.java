package Programm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements ActionListener {
    View view;
    Model model;


    Controller(View view) {
        this.view = view;
        this.model = new Model(view);
    }

    public void actionPerformed(ActionEvent event) {
        model.setEventView();
    }
}