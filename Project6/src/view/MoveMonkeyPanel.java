package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The MoveMonkeyPanel class creates a panel for moving monkeys between enclosures and isolation.
 * The panel has a JComboBox to select a monkey, radio buttons to indicate if medical attention has been completed,
 * JTextAreas to display lists of monkeys in isolation and enclosures, and a JButton to move the selected monkey.
 */
public class MoveMonkeyPanel extends JFrame {

    private JLabel monkeyLabel, medicalLabel, monkeyIsolationListLabel, monkeyEnclosureListLabel;
    private JRadioButton medicalTrueButton, medicalFalseButton;
    private ButtonGroup medicalAttentionButtonGroup;
    private JComboBox<String> monkeyComboBox;
    private JTextArea monkeyListIsolation, monkeyListEnclosure;
    private JButton moveButton;

    public MoveMonkeyPanel() {
        setLayout(new BorderLayout());
        setLocation(100, 100);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JPanel moveMonkeyPanel = new JPanel(new GridLayout(0, 2));
        monkeyLabel = new JLabel("Select Monkey: ");
        monkeyComboBox = new JComboBox<>();
        medicalLabel = new JLabel("Medical Attention Completed: ");
        medicalFalseButton = new JRadioButton("False");
        medicalTrueButton = new JRadioButton("True", true);
        medicalAttentionButtonGroup = new ButtonGroup();
        medicalAttentionButtonGroup.add(medicalTrueButton);
        medicalAttentionButtonGroup.add(medicalFalseButton);
        monkeyIsolationListLabel = new JLabel("Monkey housed in Isolation: ");
        monkeyListIsolation = new JTextArea(50 , 50);
        monkeyListIsolation.setEditable(false);
        JScrollPane scrollPaneIsolation = new JScrollPane(monkeyListIsolation);
        monkeyEnclosureListLabel = new JLabel("Monkey housed in Enclosure: ");
        monkeyListEnclosure = new JTextArea(50 , 50);
        monkeyListEnclosure.setEditable(false);
        JScrollPane scrollPaneEnclosure = new JScrollPane(monkeyListEnclosure);

        moveButton = new JButton("Move");

        moveMonkeyPanel.add(monkeyLabel);
        moveMonkeyPanel.add(monkeyComboBox);
        moveMonkeyPanel.add(medicalLabel);
        moveMonkeyPanel.add(medicalTrueButton);
        moveMonkeyPanel.add(new JLabel());
        moveMonkeyPanel.add(medicalFalseButton);

        JPanel textPanel = new JPanel(new GridLayout(0, 2));
        textPanel.add(monkeyIsolationListLabel);
        textPanel.add(scrollPaneIsolation);
        textPanel.add(monkeyEnclosureListLabel);
        textPanel.add(scrollPaneEnclosure);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(moveButton);

        add(moveMonkeyPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JComboBox<String> getMonkeyComboBox() {
        return monkeyComboBox;
    }

    public JRadioButton getMedicalTrueButton() {
        return medicalTrueButton;
    }

    public JTextArea getMonkeyListIsolation() {
        return monkeyListIsolation;
    }

    public JTextArea getMonkeyListEnclosure() {
        return monkeyListEnclosure;
    }

    /**
     * Adds an ActionListener to the moveButtonListener.
     * @param listener the ActionListener to add
     */
    public void moveButtonListener(ActionListener listener) {
        moveButton.addActionListener(listener);
    }
}
