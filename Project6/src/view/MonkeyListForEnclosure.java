package view;

import model.monkey.Species;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * This class represents a view for a list of monkeys that belong to a specific enclosure, grouped by species.
 * It extends the JFrame class and contains a combo box to select the species of monkeys to display, a text area to
 * show the list of monkeys, and a button to publish the list. The class provides getter methods for the text area and
 * the combo box, and a method to register a listener for the publish button.
 */

public class MonkeyListForEnclosure extends JFrame {
    private JTextArea monkeyList;
    private JButton createList;

    private JComboBox<Species> speciesJComboBox;

    public MonkeyListForEnclosure() {
        setLayout(new BorderLayout());
        setLocation(100, 100);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JLabel speciesLabel = new JLabel("Species: ");
        speciesJComboBox = new JComboBox<>(Species.values());
        JLabel label = new JLabel("Monkey housed in the enclosure: ");
        monkeyList = new JTextArea(100, 20);
        monkeyList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(monkeyList);
        createList = new JButton("Publish");

        JPanel speciesPanel = new JPanel(new GridLayout(0, 2));
        speciesPanel.add(speciesLabel);
        speciesPanel.add(speciesJComboBox);
        JPanel textPanel = new JPanel(new GridLayout(0, 1));
        textPanel.add(label);
        textPanel.add(scrollPane);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(createList);

        add(speciesPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JTextArea getMonkeyList() {
        return monkeyList;
    }

    public JComboBox<Species> getSpeciesJComboBox() {
        return speciesJComboBox;
    }

    /**
     * Adds an ActionListener to the publishButtonListener.
     * @param listener the ActionListener to add
     */
    public void publishButtonListener(ActionListener listener) {
        createList.addActionListener(listener);
    }
}
