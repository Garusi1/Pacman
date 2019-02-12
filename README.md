# Pacman
Ex-4
GIS PROJECT AND PACKMAN GAME
For the ex-4 project get into GIS-CLASS-->EX_2-->SRC-->(GAME + GAME SOLUTION + GUI + MAINS) For the ex-3 diagram get into GIS-CLASS-->EX_2-->ex3_Diagram2
Description:
The game:
In this packman game you should avoid hitting the ghosts, and the boxes. In addition you need to as many fruits as you can. 
You are in a competition with other packmans, they might eat your fruit!
Each touch in the boxes or the ghosts will minus your points, while any eating will add you points.
In this game there are tow modules :
1.	human Player vs the server 
2.	automatic algorithm vs the server

program structure:

***Game components: This package includes 3 classes: 
1. Box class- This class represent the object "Box". Is the game, any touch of the packman in the box Takes him 1 point. 

2. Ghost class -This class represent the object "ghost". This object has location and id. It runs after the packman, and any touch of the packman takes him 1 point.
 3. M class- This class represent the object "player". That directs by the player by clicking the right direction in the map.

***Gui package: This package includes 3 classes:
1. Map class- This class has two functions that converting pixeles cordinates to gps cordinates and gps cordinates to piexel cordinates.
2. Gui class- This class is simply about showing the game in user graphic interface. The goal of the game is to eat all the packmans in the shortest time. You can run the game in 2 different ways. tou can add packmans and friut by clicking on the man and than you need to click "run game". The second option is to open the game from csv file by clicking on "Load file" and than click run. When you click run you can show the path each packman did to eat the fruits in the shortest time. Another option of the game is to export the game to kml file and to csv file by clicking "Export". There is another button calles "clear" that clear the screen.
3. Main class- This is the class that runs the gui.
***Algo package: 
1.	Algorithm class: this class includes the algorithm that suppose to run the player to eat as many fruits, and avoid the boxes and the ghosts as he can. The main frame function which runs the algorithm till the fruits ends.   
2.	Calculation class: functions that makes all the calculations regarding the path of the player. 
a.	Calculate the most profitable fruit (location and distance from another pacmans) and builds a path.
b.	intersect function – checks if the path intersect with the boxes
c.	Rotate function – if the path that calculated intersects the boxes this function will rotate the path in 10 degrees till it will the 'b' function return false.
3.	Output class:
a.	Paths  - of the 'player'
b.	Statistics
c.	points

Prerequisites:
Installation a workspace that works with java is needed. You need to download the attached jar file called "jak".
Running the tests:
A test file is attached to the project. You just need to run it.
Built With:
Eclipse
Authors:
Naor Eliav and Michael Garusi
Acknowledgments:
In the project I used Wikipedia to write a number of functuations in the class. We used jak library for the converting to kml file. We used wikipedia to understand what gis project is and sites like stackoverflow and and geeksforgeeks. We used youtube to learn about gui.

