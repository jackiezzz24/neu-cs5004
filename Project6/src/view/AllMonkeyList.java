package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * AllMonkeyList class represents a view for displaying a list of all the monkeys in a sanctuary.
 * It extends the JFrame class and contains a JLabel to display the title of the list, a JTextArea to
 * display the list itself, and a JButton to publish the list.
 */
public class AllMonkeyList extends JFrame {

    JLabel monkeyLabel;
    JTextArea monkeyList;
    JButton createList;

    /**
     * The constructor sets up the layout of the window, the size, the location, and the close operation.
     * The JTextArea is set to be not editable and a JScrollPane is used to make it scrollable.
     * The add() method is used to add the textPanel and the buttonPanel to the JFrame in the center and
     * south respectively.
     */
    public AllMonkeyList() {
        setLayout(new BorderLayout());
        setLocation(100, 100);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        monkeyLabel = new JLabel("All monkeys in Sanctuary: ");
        monkeyList = new JTextArea(100, 20);
        monkeyList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(monkeyList);
        createList = new JButton("Publish");

        JPanel textPanel = new JPanel(new GridLayout(0, 1));
        textPanel.add(monkeyLabel);
        textPanel.add(scrollPane);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(createList);

        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * The getMonkeyList() method returns the JTextArea used to display the list
     * @return the JTextArea used to display the list
     */
    public JTextArea getMonkeyList() {
        return monkeyList;
    }

    /**
     *  publishButtonListener() method is used to add an ActionListener to the button to perform an
     *  action when it is clicked.
     * @param listener the ActionListener to add
     */
    public void publishButtonListener(ActionListener listener) {
        createList.addActionListener(listener);
    }
}
