package controller;

import model.housing.Sanctuary;
import view.SanctuaryGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class serves as the main controller for the sanctuary program. It creates and manages
 * instances of various controllers, which handle user input and interact with the model and view.
 * It also initializes the main GUI for the program.
 */

public class Controller{

    private Sanctuary sanctuary;
    private SanctuaryGUI sanctuaryGUI;

    /**
     * Create a constructor for the Controller class, which takes a Sanctuary object as a parameter.
     * It initializes the sanctuary field of the Controller object with the parameter,
     * creates a new SanctuaryGUI object, sets it to be visible,
     * and adds listeners to its buttons using anonymous inner classes.
     * @param sanctuary
     */
    public Controller(Sanctuary sanctuary) {
        this.sanctuary = sanctuary;
        sanctuaryGUI = new SanctuaryGUI();
        sanctuaryGUI.setVisible(true);
        sanctuaryGUI.addMonkeyButtonListener(new Controller.addMonkeyControllerListener());
        sanctuaryGUI.moveMonkeyButtonListener(new Controller.moveMonkeyControllerListener());
        sanctuaryGUI.viewEnclosureButtonListener(new Controller.enclosureListControllerListener());
        sanctuaryGUI.allMonkeyButtonListener(new Controller.allMonkeyControllerListener());
    }

    /**
     * addMonkeyControllerListener implements the ActionListener interface.
     * It listens for events triggered by the "Add Monkey to Isolation" button in the GUI,
     * and creates a new instance of AddMonkeyController passing it the sanctuary object.
     * This is done so that when the user clicks the "Add Monkey to Isolation" button,
     * it triggers an action that creates a new AddMonkeyController object,
     * which handles the adding of a new monkey to the isolation.
     */
    private class addMonkeyControllerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddMonkeyController addMonkeyController = new AddMonkeyController(sanctuary);
        }
    }

    /**
     * moveMonkeyControllerListener implements the ActionListener interface.
     * It listens for events triggered by the "Move Monkey to Enclosure" button in the GUI,
     * and creates a new instance of MoveMonkeyController passing it the sanctuary object.
     * This is done so that when the user clicks the "Move Monkey to Enclosure" button,
     * it triggers an action that creates a new MoveMonkeyController object,
     * which handles the moving of a monkey to the enclosure.
     */
    private class moveMonkeyControllerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MoveMonkeyController moveMonkeyController  = new MoveMonkeyController(sanctuary);
        }
    }

    /**
     * enclosureListControllerListener implements the ActionListener interface.
     * It listens for events triggered by the "Monkeys housed in Enclosure" button in the GUI,
     * and creates a new instance of EnclosureListController passing it the sanctuary object.
     * This is done so that when the user clicks the "Monkeys housed in Enclosure" button,
     * it triggers an action that creates a new EnclosureListController object,
     * which handles the producing of a list of monkeys in the enclosure.
     */

    private class enclosureListControllerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            EnclosureListController enclosureListController  = new EnclosureListController(sanctuary);
        }
    }

    /**
     * allMonkeyControllerListener implements the ActionListener interface.
     * It listens for events triggered by the "All Monkeys" button in the GUI,
     * and creates a new instance of AllMonkeyController passing it the sanctuary object.
     * This is done so that when the user clicks the "All Monkeys" button,
     * it triggers an action that creates a new AllMonkeyController object,
     * which handles the producing of a list of all monkeys in the sanctuary.
     */
    private class allMonkeyControllerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AllMonkeyController allMonkeyController = new AllMonkeyController(sanctuary);
        }
    }


}
