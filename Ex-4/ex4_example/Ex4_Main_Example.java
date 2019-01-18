package ex4_example;
import java.util.ArrayList;

import com.mysql.fabric.Server;

import GUI.ServerToGui;
import Robot.Play;
import game_components.ghost;
/**
 * This is the basic example of how to work with the Ex4 "server" like system:
 * 1. Create a "play" with one of the 9 attached files 
 * 2. Set your ID's - of all the group members (numbers only);
 * 3. Get the GPS coordinates of the "arena" - as in Ex3.
 * 4. Get the game-board data
 * 5. Set the "player" init location - should be a valid location
 * 6. Start the Server
 * 7. while (the game is running):
 * 7.1 "Play" as long as there are "fruits" and time
 * 7.2 get the current score of the game
 * 7.3 get the game-board current state
 * 7.4 goto 7
 * 8. done - report the results to the DB.
 * @author ben-moshe
 *
 */


public class Ex4_Main_Example {
	
	public static void main(String[] args) {
		// 1) Create a "play" from a file (attached to Ex4)
		String file_name = "Ex4_OOP_example9.csv";
		Play play1 = new Play(file_name);
		
		// 2) Set your ID's - of all the gr	oup members
		play1.setIDs(305615734,206338162);
		
		// 3)Get the GPS coordinates of the "arena"
		String map_data = play1.getBoundingBox();
		System.err.println("Bounding Box info: "+map_data);
		
		// 4) get the game-board data
		ArrayList<String> board_data = play1.getBoard();
		
		ServerToGui stg = new ServerToGui();
		
		ArrayList<ghost> gs = stg.serverToGhost(board_data);
		
//		System.err.println("naor   nndahuihds ndsakjda");
		
		for (int i = 0; i<gs.size() ; i++) {
			System.err.println(gs.get(i).getPoint());
			
		}
		
		// save it inside the right classes and paint it into the gui
		for(int i=0;i<board_data.size();i++) {
			System.out.println(board_data.get(i));
		}
		System.out.println();
		System.out.println("Init Player Location should be set using the bounding box info");
		
		// 5) Set the "player" init location - should be a valid location
		play1.setInitLocation(32.10488,35.20441);
		
		// 6) Start the "server"
		play1.start(); // default max time is 100 seconds (1000*100 ms).
		System.out.println(play1.getStatistics());
//		play1.stop();
		System.out.println(play1.getStatistics());

		
		// 7) "Play" as long as there are "fruits" and time
		for(int i=0;i<10;i++) {
		 i=0;
			while(play1.isRuning()) {
				i++;
				
		// 7.1) this is the main command to the player (on the server side)
			play1.rotate(36*i); 
			System.out.println("***** "+i+"******");
			
		// 7.2) get the current score of the game
			String info = play1.getStatistics();
			System.out.println(info);
//		 7.3) get the game-board current state
			board_data = play1.getBoard();
			for(int a=0;a<board_data.size();a++) {
				System.out.println(board_data.get(a));
			}
			System.out.println();
		}
		// 8) stop the server - not needed in the real implementation.
		play1.stop();
		System.out.println("**** Done Game (user stop) ****");
		
		// 9) print the data & save to the course DB
		String info = play1.getStatistics();
		System.out.println(info);
//		
//	}
}

}}