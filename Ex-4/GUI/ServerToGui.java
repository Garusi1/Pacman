package GUI;

import java.util.ArrayList;

import Geom.Point3D;
import game.fruits;
import game.packman;
import game_components.M;
import game_components.box;
import game_components.ghost;

public class ServerToGui {

	public ArrayList<ghost> serverToGhost(ArrayList<String> ser){

		ArrayList<ghost> gs = new ArrayList<ghost>();				

		for (int i = 1; i < ser.size(); i++) {
			if(ser.get(i).substring(0, 1).equals("G")) {
				String ss[] = ser.get(i).split(","); 
				int id = Integer.parseInt(ss[1]);
				Point3D p = new Point3D(Double.parseDouble(ss[3]), Double.parseDouble(ss[2]),0);
				double speed =Double.parseDouble( ss[5]);
				double radius = Double.parseDouble( ss[6]);
				ghost g = new ghost(p, id, speed, radius);
				gs.add(g);
			}
		}


		return gs;

	}
	public ArrayList<packman> serverToPackman(ArrayList<String> ser){

		ArrayList<packman> ps = new ArrayList<packman>();				

		for (int i = 1; i < ser.size(); i++) {
			String ss[] = ser.get(i).split(","); 

			if(ss[0].equals("P")) {
//				String ss[] = ser.get(i).split(","); 
				int id = Integer.parseInt(ss[1]);
				Point3D p = new Point3D(Double.parseDouble(ss[3]), Double.parseDouble(ss[2]),0);
				double speed =Double.parseDouble( ss[5]);
				double radius = Double.parseDouble( ss[6]);
				packman pp = new packman(p, id, speed, radius);
				ps.add(pp);
			}
		}


		return ps;

	}

	public ArrayList<box> serverToBox(ArrayList<String> ser){

		ArrayList<box> Bs = new ArrayList<box>();				

		for (int i = 1; i < ser.size(); i++) {
			if(ser.get(i).substring(0, 1).equals("B")) {
				String ss[] = ser.get(i).split(","); 
				int id = Integer.parseInt(ss[1]);
				System.out.println(+i+":  ");
				Point3D p1 = new Point3D(Double.parseDouble(ss[3]), Double.parseDouble(ss[2]),0);
				System.out.println(+i+"2:  ");
				Point3D p2 = new Point3D(Double.parseDouble(ss[6]), Double.parseDouble(ss[5]),0);

				box b = new box(p1, p2, id);

				Bs.add(b);
			}
		}


		return Bs;

	}
	public ArrayList<fruits> serverToFruits(ArrayList<String> ser){

		ArrayList<fruits> Fs = new ArrayList<fruits>();				

		for (int i = 1; i < ser.size(); i++) {
			String ss[] = ser.get(i).split(","); 

			if(ss[0].equals("F")) {
//				String ss[] = ser.get(i).split(","); 
				int id = Integer.parseInt(ss[1]);
				Point3D p = new Point3D(Double.parseDouble(ss[3]), Double.parseDouble(ss[2]),0);
				double weight =Double.parseDouble( ss[5]);
				fruits ff = new fruits(p, id,weight);
				Fs.add(ff);
			}
		}


		return Fs;

	}
	
	public M serverToPlayer(ArrayList<String> ser){
		M player  = new M();
		for (int i = 1; i < ser.size(); i++) {
			String ss[] = ser.get(i).split(","); 
			if(ss[0].equals("M")) {
				System.out.println("fjdslkfjdlskjfdklsjfklsd");
//				String ss[] = ser.get(i).split(","); 
//				int id = Integer.parseInt(ss[1]);
				Point3D p = new Point3D(Double.parseDouble(ss[3]), Double.parseDouble(ss[2]),0);
//				M player = new M(p,id, Double.parseDouble(ss[5]), Double.parseDouble(ss[6]));
				player = new M(p);

			}
		}
		return player;



	}
	
	public static void main (String [] a) {
		
		
		
	}
}
