package controller;

import model.housing.Sanctuary;
import model.monkey.Monkey;
import view.MoveMonkeyPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


/**
 * This MoveMonkeyController implements ActionListener interface to handle user action in the MoveMonkeyPanel view
 */
public class MoveMonkeyController {

    private MoveMonkeyPanel moveMonkeyPanel;
    private Sanctuary sanctuary;

    /**
     * Constructs a Sanctuary object and initializes a MoveMonkeyPanel object,
     * which is a view component that displays the current list of monkeys in isolation and in enclosures,
     * and provides a combo box for the user to select a monkey to move.
     * The constructor also adds an action listener to the "move" button on the MoveMonkeyPanel,
     * which calls the MoveButtonListener class
     * @param sanctuary the sanctuary model contains all the methods
     */
    public MoveMonkeyController(Sanctuary sanctuary) {
        moveMonkeyPanel = new MoveMonkeyPanel();
        moveMonkeyPanel.setVisible(true);
        this.sanctuary = sanctuary;
        moveMonkeyPanel.moveButtonListener(new MoveButtonListener());
        updateComboBox();
        updateTextArea();
    }

    /**
     * MoveButtonListener class implements the ActionListener interface and listens for the "move" button to
     * be pressed. When the button is pressed, the selected monkey is retrieved from the combo box,
     * and the boolean value of the "medical attention" checkbox is retrieved.
     * If the selected monkey is found in the Isolation enclosure of the sanctuary,
     * its medicalAttention attribute is set to the value of the checkbox, and the moveToEnclosure method of
     * the Sanctuary object is called to move the monkey to an enclosure. If the move is successful,
     * a message dialog is displayed to indicate success, and the list of monkeys in isolation on the
     * MoveMonkeyPanel is updated to remove the moved monkey. If the move is unsuccessful,
     * an error message is displayed.
     */

    private class MoveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedMonkey = (String) moveMonkeyPanel.getMonkeyComboBox().getSelectedItem();
            boolean medicalAttention = moveMonkeyPanel.getMedicalTrueButton().isSelected();
            if (sanctuary.getIsolation() != null && sanctuary.getIsolation().getMonkeys() != null) {
                for (Monkey monkey: sanctuary.getIsolation().getMonkeys()) {
                    if (Objects.equals(monkey.getName(), selectedMonkey)) {
                        monkey.setMedicalAttention(medicalAttention);
                        try {
                            sanctuary.moveToEnclosure(monkey);
                            JOptionPane.showMessageDialog(moveMonkeyPanel, "Monkey moved to enclosure successfully.");
                            updateTextArea();
                            moveMonkeyPanel.getMonkeyComboBox().removeItem(monkey.getName());
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(moveMonkeyPanel, "Error: "
                                    + exception.getMessage());
                        }
                    }
                }

            }

        }
    }

    /**
     *  Populates the combo box with the monkeys currently in isolation
     */
    private void updateComboBox() {
        if (sanctuary.getIsolation() != null && sanctuary.getIsolation().getMonkeys() != null) {
            for (Monkey monkey: sanctuary.getIsolation().getMonkeys()) {
                moveMonkeyPanel.getMonkeyComboBox().addItem(monkey.getName());
            }
        }
    }

    /**
     * Updates the text areas on the MoveMonkeyPanel that display the lists of monkeys in isolation and in enclosures.
     */
    private void updateTextArea() {
        moveMonkeyPanel.getMonkeyListIsolation().setText("");
        String textIsolation = sanctuary.monkeyListForIsolation();
        moveMonkeyPanel.getMonkeyListIsolation().setText(textIsolation);
        moveMonkeyPanel.getMonkeyListEnclosure().setText("");
        String textEnclosure = sanctuary.monkeyListForEnclosure();
        moveMonkeyPanel.getMonkeyListEnclosure().setText(textEnclosure);
    }
}
