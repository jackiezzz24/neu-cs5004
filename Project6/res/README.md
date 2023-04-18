## README

### Overview

The Jungle Friends Primate SanctuaryLinks to an external site. provides a permanent home and high-quality sanctuary 
care for New World primates who have been cast-off from the pet trade, retired from research, or confiscated by 
authorities. They are seeking to replace all of their paper records with computer records where they can keep track 
of the individual animals that are in their care. Your task in this assignment is to design and implement the model 
for such a system that can satisfy their needs:

The Sanctuary consists of two different types of housing:

- **Isolation** is used to keep monkeys when they first arrive at the sanctuary and anytime they are receiving medical 
    attention. Isolation consists of a series of cages each of which can house a single animal.
- **Enclosures** are much larger and can host a single troop (i.e., a group) of monkeys. Each troop consists of a 
    single species that is found in the New World (some of which are pictured below): drill, guereza, howler, 
    mangabey, saki, spider, squirrel, and tamarin.

This program would be able to register new monkey into sanctuary, move monkey from isolation to the right enclosure 
and produce monkey lists for every enclosure and produce an alphabetical list (by name) of all the monkeys 
housed in the Sanctuary.

### List of features

This program has the following features:

1. register new monkeys into the isolation
2. move a monkey from isolation to the right enclosure once the monkey have received medical attention
3. produce a list of monkeys for every enclosure
4. produce an alphabetical list of all monkeys housed in the Sanctuary

### How to run the program

A JAR file is saved under res/ folder. 
In the intellij, users can press Ctrl+Shift+A, find and run the Edit Configurations action. 
In the Run/Debug Configurations dialog, click + and select JAR Application. Add a name for the new configuration.
In the Path to JAR field, click the Browse button and specify the path to the JAR file under res/ folder. On the 
toolbar, select the created configuration and click the Run button to the right of the run configuration selector.

### How to use the program 
Once the program ran, a window would show. There are four buttons which assigned to each feature. 
1. Add Monkey to Isolation:  After click the button, a new window shows. Users can enter the monkey name, age, size, 
    and weight. Species, sex and favorite food can be chosen from the drop-down menus. The medical attention is set to 
    be false. If not the fields are filled, a message dialog will pop up to ask user fill in the blank field. Once a 
    monkey added successfully, textarea would update to show the monkey list in the isolation area. If all 20 spaces 
    used, a error message would show and prevent user to continue entering the data.
2. Move Monkey to Enclosure: User could select the monkey name from the Select Monkey drop-down menu. It would show all
    the monkeys in the isolation area. User would change the medial attention status here. Once the medial attention 
    changes to true. Monkey would be able to move from isolation to particular enclosure. The textarea for both 
    isolation and enclosure would change. Also, once the monkey moved to enclosure, it will remove from the Select 
    monkey menu. 
3. Monkeys housed in Enclosure: Users could select a specific species. Once the publish button clicked, the monkey list
    for the selection species would show in the textarea.
4. All Monkeys:  Once the publish button clicked, an alphabetical monkey list for all the monkeys housed in the 
    sanctuary would show in the textarea.

### Design Version 1.0
This is the first version of the program. 

### Assumption

The medial attention is set as false for all the new monkeys. Once the medical attention completed, it can set to true 
and monkey could be able to move from isolation to encolsure. 


### Limitation

1. Size, weight and age have to be a positive number.
2. Sex can only choose from M/F.
3. Species can only choose from:
   Drill, Guereza, Howler, Mangabey, Saki, Spider, Squirrel, Tamarin
4. Favorite food can only choose from:
   Eggs, Fruits, Insects, Leaves, Nuts, Seeds, TreeSap
5. The isolation housing has 20 spaces and enclosure housing has 8 spaces.

### Citation

​	1. *How to Run Jar* 
https://www.jetbrains.com/help/idea/compiling-applications.html#run_packaged_jar

