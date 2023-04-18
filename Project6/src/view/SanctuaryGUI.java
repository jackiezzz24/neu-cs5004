package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *The SanctuaryGUI class is responsible for creating the main window of the Monkey Sanctuary application.
 */
public class SanctuaryGUI extends JFrame {
    private JPanel mainPanel;
    private JButton addMonkeyButton, moveMonkeyButton, viewEnclosureButton, allMonkeyButton;
    private AddMonkeyPanel addMonkeyPanel = new AddMonkeyPanel();
    private MoveMonkeyPanel moveMonkeyPanel = new MoveMonkeyPanel();
    private MonkeyListForEnclosure monkeyListForEnclosure = new MonkeyListForEnclosure();
    private AllMonkeyList allMonkeyList = new AllMonkeyList();

    /**
     * Constructs a new instance of SanctuaryGUI and initializes its components.
     */
    public SanctuaryGUI() {

        setLayout(new BorderLayout());
        setLocation(100, 100);
        setSize(400, 400);
        setTitle("Monkey Sanctuary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new GridLayout(0, 1));
        addMonkeyButton = new JButton("Add Monkey to Isolation");
        addMonkeyButton.setActionCommand("Add Monkey to Isolation");
        moveMonkeyButton = new JButton("Move Monkey to Enclosure");
        viewEnclosureButton = new JButton("Monkeys housed in Enclosure");
        allMonkeyButton = new JButton("All Monkeys");

        mainPanel.add(addMonkeyButton);
        mainPanel.add(moveMonkeyButton);
        mainPanel.add(viewEnclosureButton);
        mainPanel.add(allMonkeyButton);

        add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * Adds an ActionListener to the addMonkeyButton.
     * @param actionListener the ActionListener to add
     */
    public void addMonkeyButtonListener(ActionListener actionListener) {
        addMonkeyButton.addActionListener(actionListener);
    }

    /**
     * Adds an ActionListener to the moveMonkeyButton.
     * @param actionListener the ActionListener to add
     */
    public void moveMonkeyButtonListener(ActionListener actionListener) {
        moveMonkeyButton.addActionListener(actionListener);
    }

    /**
     * Adds an ActionListener to the viewEnclosureButton.
     * @param actionListener the ActionListener to add
     */

    public void viewEnclosureButtonListener(ActionListener actionListener) {
        viewEnclosureButton.addActionListener(actionListener);
    }


    /**
     * Adds an ActionListener to the allMonkeyButton.
     * @param actionListener the ActionListener to add
     */
    public void allMonkeyButtonListener(ActionListener actionListener) {
        allMonkeyButton.addActionListener(actionListener);
    }

}
