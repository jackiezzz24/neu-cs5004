package controller;

import model.housing.Sanctuary;
import model.monkey.Species;
import view.MonkeyListForEnclosure;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This EnclosureListController implements the ActionListener interface.
 * It has a monkeyListForEnclosure instance variable which represents the view,
 * and a sanctuary instance variable which represents the model.
 */
public class EnclosureListController implements ActionListener {

    private MonkeyListForEnclosure monkeyListForEnclosure;
    private Sanctuary sanctuary;

    /**
     * The constructor initializes the view, sets the instance variables,
     * and registers an action listener on the view's publish button.
     * @param sanctuary the sanctuary model contains all the methods
     */
    public EnclosureListController(Sanctuary sanctuary) {
        monkeyListForEnclosure = new MonkeyListForEnclosure();
        monkeyListForEnclosure.setVisible(true);
        this.sanctuary = sanctuary;
        monkeyListForEnclosure.publishButtonListener(this);
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
     * update the text area to show the monkey list for a given enclosure.
     */

    public void updateTextArea() {
        monkeyListForEnclosure.getMonkeyList().setText("");
        Species selectedSpecies = (Species) monkeyListForEnclosure.getSpeciesJComboBox().getSelectedItem();
        String text = sanctuary.monkeyListForGivenEnclosure(selectedSpecies);
        monkeyListForEnclosure.getMonkeyList().setText(text);
    }
}
