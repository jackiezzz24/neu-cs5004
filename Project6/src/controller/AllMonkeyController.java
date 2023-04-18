package controller;

import model.housing.Sanctuary;
import view.AllMonkeyList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This AllMonkeyController implements the ActionListener interface.
 * It has two instance variables: allMonkeyList, an object of the AllMonkeyList class,
 * and sanctuary, an object of the Sanctuary class.
 */
public class AllMonkeyController implements ActionListener {

    private AllMonkeyList allMonkeyList;
    private Sanctuary sanctuary;

    /**
     * The constructor takes a Sanctuary object as a parameter, creates a new AllMonkeyList object,
     * sets it to visible, and assigns the passed Sanctuary object to the sanctuary instance variable.
     * The publishButtonListener method is called on the allMonkeyList object, which adds an action listener to
     * the "Publish" button on the view.
     * @param sanctuary the sanctuary model contains all the methods
     */
    public AllMonkeyController(Sanctuary sanctuary) {
        allMonkeyList = new AllMonkeyList();
        allMonkeyList.setVisible(true);
        this.sanctuary = sanctuary;
        allMonkeyList.publishButtonListener(this);
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e update the textArea once publish button pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        updateTextArea();
    }

    /**
     * update the text area to show all the monkeys in alphabet order based on monkey names
     */
    public void updateTextArea() {
        allMonkeyList.getMonkeyList().setText("");
        String text = sanctuary.monkeyList();
        allMonkeyList.getMonkeyList().setText(text);
    }
}
