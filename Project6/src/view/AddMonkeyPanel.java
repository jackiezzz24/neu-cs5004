package view;

import model.monkey.Food;
import model.monkey.Sex;
import model.monkey.Species;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The AddMonkeyPanel class represents a view component that allows the user to add a monkey to the system.
 * It extends the JFrame class and contains various swing components such as JLabels, JTextFields, JRadioButtons,
 * JComboBoxes, JTextAreas, and JButtons. It also contains methods to retrieve user input and add action listeners
 * to the add and clear buttons.
 */
public class AddMonkeyPanel extends JFrame {

    private JLabel nameLabel, speciesLabel, weightLabel, sizeLabel;
    private JLabel ageLabel, sexLabel, foodLabel, medicalLabel, listLabel;
    private JTextField name , weight, size, age;
    private JComboBox<Species> speciesJComboBox;
    private JComboBox<Sex> sexJComboBox;
    private JComboBox<Food> foodJComboBox;
    private JRadioButton medicalTrueButton, medicalFalseButton;
    private ButtonGroup medicalAttentionButtonGroup;
    private JTextArea monkeyListForIsolation;
    private JButton addButton, clearButton;

    public AddMonkeyPanel() {
        setLayout(new BorderLayout());
        setLocation(100, 100);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JPanel monkeyPanel = new JPanel(new GridLayout(0, 4));

        nameLabel = new JLabel("Name: ");
        name = new JTextField(10);
        speciesLabel = new JLabel("Species: ");
        speciesJComboBox = new JComboBox<>(Species.values());
        sexLabel = new JLabel("Sex: ");
        sexJComboBox = new JComboBox<>(Sex.values());
        ageLabel = new JLabel("Age: ");
        age = new JTextField();
        sizeLabel = new JLabel("Size: ");
        size = new JTextField();
        weightLabel = new JLabel("Weight: ");
        weight = new JTextField();
        foodLabel = new JLabel("Favorite Food: ");
        foodJComboBox = new JComboBox<>(Food.values());
        medicalLabel = new JLabel("Medical Attention Completed: ");
        medicalFalseButton = new JRadioButton("False", true);
        medicalTrueButton = new JRadioButton("True");
        medicalAttentionButtonGroup = new ButtonGroup();
        medicalAttentionButtonGroup.add(medicalTrueButton);
        medicalAttentionButtonGroup.add(medicalFalseButton);
        listLabel = new JLabel("Monkeys housed in Isolation: ");
        monkeyListForIsolation = new JTextArea(100 , 20);
        monkeyListForIsolation.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(monkeyListForIsolation);
        addButton = new JButton("Add");
        clearButton = new JButton("Clear");

        monkeyPanel.add(nameLabel);
        monkeyPanel.add(name);
        monkeyPanel.add(speciesLabel);
        monkeyPanel.add(speciesJComboBox);
        monkeyPanel.add(sexLabel);
        monkeyPanel.add(sexJComboBox);
        monkeyPanel.add(ageLabel);
        monkeyPanel.add(age);
        monkeyPanel.add(sizeLabel);
        monkeyPanel.add(size);
        monkeyPanel.add(weightLabel);
        monkeyPanel.add(weight);
        monkeyPanel.add(foodLabel);
        monkeyPanel.add(foodJComboBox);
        monkeyPanel.add(medicalLabel);
        monkeyPanel.add(medicalTrueButton);
        monkeyPanel.add(new JLabel());
        monkeyPanel.add(new JLabel());
        monkeyPanel.add(new JLabel());
        monkeyPanel.add(medicalFalseButton);

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.add(listLabel, BorderLayout.WEST);
        textPanel.add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);

        add(monkeyPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

    }


    public JTextField getNameField() {
        return name;
    }

    public JTextField getWeight() {
        return weight;
    }

    public JTextField getSizeField() {
        return size;
    }

    public JTextField getAge() {
        return age;
    }

    public JComboBox<Species> getSpeciesJComboBox() {
        return speciesJComboBox;
    }

    public JComboBox<Sex> getSexJComboBox() {
        return sexJComboBox;
    }

    public JComboBox<Food> getFoodJComboBox() {
        return foodJComboBox;
    }

    public ButtonGroup getMedicalAttentionButtonGroup() {
        return medicalAttentionButtonGroup;
    }

    public JRadioButton getMedicalTrueButton() {
        return medicalTrueButton;
    }

    public JRadioButton getMedicalFalseButton() {
        return medicalFalseButton;
    }
    public JTextArea getMonkeyListForIsolation() {
        return monkeyListForIsolation;
    }

    public void addButtonListener(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void clearButtonListener(ActionListener actionListener) {
        clearButton.addActionListener(actionListener);
    }

}
