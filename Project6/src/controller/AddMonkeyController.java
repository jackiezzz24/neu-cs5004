package controller;

import model.housing.Sanctuary;
import model.monkey.Food;
import model.monkey.Monkey;
import model.monkey.Sex;
import model.monkey.Species;
import view.AddMonkeyPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This AddMonkeyController implements ActionListener interface to handle user action in the AddMonkeyPanel view
 */
public class AddMonkeyController implements ActionListener{

    private AddMonkeyPanel addMonkeyPanel;
    private Sanctuary sanctuary;

    /**
     * This constructor take Sanctuary object as a parameter, initializes the AddMonkeyPanel
     * and sets the action listeners for the Add and Clear buttons.
     * @param sanctuary the sanctuary model contains all the methods
     */
    public AddMonkeyController(Sanctuary sanctuary) {
        addMonkeyPanel = new AddMonkeyPanel();
        addMonkeyPanel.setVisible(true);
        this.sanctuary = sanctuary;
        addMonkeyPanel.addButtonListener(this);
        addMonkeyPanel.clearButtonListener(this);
        updateIsolationTextArea();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed. If user selects "Add" button, it runs addMonkey method.
     *          if user selects "Clear" button, it clears all the inputs.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {
            addMonkey();
        } else if (e.getActionCommand().equals("Clear")) {
            clearInput();
        }
    }

    /**
     * addMonkey method gets the input data from the AddMonkeyPanel and create monkey objects.
     * It would show a message if monkey added to isolation successfully. It would update the monkey list
     * in the isolation in the text area and clear the previous input as well.
     */
    private void addMonkey() {
        try {
            String monkeyName = addMonkeyPanel.getNameField().getText();
            Species monkeySpecies = (Species) addMonkeyPanel.getSpeciesJComboBox().getSelectedItem();
            Sex monkeySex = (Sex) addMonkeyPanel.getSexJComboBox().getSelectedItem();
            int monkeyAge = Integer.parseInt(addMonkeyPanel.getAge().getText());
            double monkeySize = Double.parseDouble(addMonkeyPanel.getSizeField().getText());
            double monkeyWeight = Double.parseDouble(addMonkeyPanel.getWeight().getText());
            Food monkeyFood = (Food) addMonkeyPanel.getFoodJComboBox().getSelectedItem();
            boolean medical = addMonkeyPanel.getMedicalAttentionButtonGroup()
                    .isSelected(addMonkeyPanel.getMedicalTrueButton().getModel());

            Monkey monkey = new Monkey(monkeyName, monkeySpecies
                    , monkeySex, monkeySize, monkeyWeight, monkeyAge, monkeyFood);

            monkey.setMedicalAttention(medical);
            sanctuary.addToIsolation(monkey);
            JOptionPane.showMessageDialog(addMonkeyPanel, "Monkey added to isolation successfully.");
            updateIsolationTextArea();
            clearInput();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(addMonkeyPanel, "Error: "
                    + exception.getMessage());
        }
    }

    /**
     * Clear the input files in the AddMonkeyPanel
     */
    public void clearInput() {
        addMonkeyPanel.getNameField().setText("");
        addMonkeyPanel.getSexJComboBox().setSelectedIndex(0);
        addMonkeyPanel.getSpeciesJComboBox().setSelectedIndex(0);
        addMonkeyPanel.getAge().setText("");
        addMonkeyPanel.getSizeField().setText("");
        addMonkeyPanel.getWeight().setText("");
        addMonkeyPanel.getFoodJComboBox().setSelectedIndex(0);
        addMonkeyPanel.getMedicalFalseButton().setSelected(true);
    }


    /**
     * updates the monkey list for isolation housing once add a new monkey object
     */
    public void updateIsolationTextArea() {
        addMonkeyPanel.getMonkeyListForIsolation().setText("");
        String text = sanctuary.monkeyListForIsolation();
        addMonkeyPanel.getMonkeyListForIsolation().setText(text);
    }
}
