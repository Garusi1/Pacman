package GUI;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import Coords.MyCoords;
import Geom.Point3D;
import Robot.Play;
import game.csvToGame;
import game.fruits;
import game.gameConverts;
import game.packman;
import game_Solution.Solution;
import game_Solution.solutionConverts;
import game_components.M;
import game_components.box;
import game_components.ghost;


// TODO: Auto-generated Javadoc
/**
 * This class is about showing all the game in gui(graphic user interface).
 * 
 * The class contains some parameters:
 * x_length-the distance between the two extremes at the top of the frame.
 * y_length-the distance between the two extremes at the side of the frame.
 * Width-the width of the frame in pixeles/
 * Heigth-the height of the frame in pixeles.
 *Point3D leftUp-The point at the top left of the frame
 *Point3D rightDown-The point at the right down of the frame
 *BufferedImage myImage-the image of the map of ariel
 *BufferedImage myImage2-the image of the packman.
 *BufferedImage myImage3-the image of the fruit.
 *packlist-arrayList of pack
 *frulist-list of fruits
 *weidth- the curren width of the frame
 *height-the current height of the frame.
 *A
 *@author naor eliav and michael garusi
 **/


public class Gui extends JFrame implements MouseListener
{

	MyThread3 t1 = new MyThread3("T1");

	/** The x length. */
	final double x_length=1114.8926260415562;

	/** The y length. */
	final double y_length=327.4627423203879;

	/** The Width. */
	int Width=1433;

	/** The Heigth. */
	int Heigth=642;
	private ServerToGui stg = new ServerToGui();

	private ArrayList<String> board_data = new ArrayList<String>();

	double azimuth=90;

	/** The left up. */
	final Point3D leftUp=new Point3D(35.202469,32.105770);

	/** The right down. */
	final Point3D rightDown=new Point3D(35.211588,32.101899);

	private Play play1;

	/** The my image. */
	public BufferedImage myImage;

	/** The my image 2. */
	public BufferedImage myImage2;

	/** The my image 3. */
	public BufferedImage myImage3;

	/** The my image 4. */
	public BufferedImage myImage4;
	/** The my image . */
	public BufferedImage myImage5;

	/** The pack. */
	ArrayList<packman> pack=new ArrayList<packman>();

	/** The fru. */
	ArrayList<fruits> fru=new ArrayList<fruits>();


	/** The ghosts. */
	ArrayList<ghost> gho=new ArrayList<ghost>();

	/** The boxes. */
	ArrayList<box> box=new ArrayList<box>();

	M player = new M(32.10488,35.20441) ;

	/** The sol. */
	Solution sol = new Solution();

	/** The i. */
	public static int i=0;

	/** The gameflag. */
	public int gameflag=0;

	/** The g. */
	game.Game g=new game.Game(pack,fru);

	/** The x. */
	int x = -1;

	/** The y. */
	int y = -1;

	/** The width. */
	int width=getWidth();

	/** The height. */
	int height=getHeight();

	/**
	 * This is the constructor of the gui.
	 */
	public Gui() 
	{
		initGUI();		
		this.addMouseListener(this); 
	}

	/**
	 * The function that run the gui.
	 */
	private void initGUI() 
	{
		////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////menus////////////////////////////////////////
		MenuBar menuBar = new MenuBar();

		Menu menu1 = new Menu("Load File"); 
		Menu menu2 = new Menu("Run Game"); 
//		Menu menu3 = new Menu("Export"); 
		Menu menu4 = new Menu("Clear"); 
		Menu menu5 = new Menu("Play"); 

		MenuItem item = new MenuItem("Open Csv File");
		MenuItem item3 = new MenuItem("Clear Game");
		MenuItem item4 = new MenuItem("Export to Csv");
		MenuItem item5 = new MenuItem("Export Game to Kml");
		MenuItem item6 = new MenuItem("run");
		MenuItem item7 = new MenuItem("Export Game Solution to Kml");
		MenuItem addPlayer = new MenuItem("Add player");


		//action listeners
		item.addActionListener(  new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				gameflag=0;
				readFileDialog();


			}
		}
				);


		item3.addActionListener(  new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pack.clear();
				fru.clear();
				sol.clearSolution();
				gho.clear();
				box.clear();
//				play1.stop();
				repaint();
				System.out.println("It was cleared");
			}
		}
				);
		item4.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				gameConverts ga=new gameConverts();
				ga.gameToCsv(g);
			}
		}
				);
		item5.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				gameConverts ga=new gameConverts();
				ga.gameToKml(g);
			}
		}
				);
		item6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameflag=4;	
				play1.start();
				t1.start();
				repaint();

			}
		});


		item7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				solutionConverts st = new solutionConverts();
				st.solutionTo(sol);
			}
		});
		addPlayer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameflag=1;
				
				repaint();
			}
		});

		menuBar.add(menu1);
		menuBar.add(menu2);
//		menuBar.add(menu3);
		menuBar.add(menu4);
		menuBar.add(menu5);
		menu1.add(item);
		menu2.add(item6);
//		menu3.add(item4);
//		menu3.add(item5);
//		menu3.add(item7);
		menu5.add(addPlayer);

		menu4.add(item3);


		this.setMenuBar(menuBar);

		try {
			myImage = ImageIO.read(new File("Ariel1.PNG"));}
		catch (Exception e) {
			e.printStackTrace();
		}

		try {
			myImage2=ImageIO.read(new File("Packman.PNG"));}
		catch (Exception e) {
			e.printStackTrace();}

		try {
			myImage3 = ImageIO.read(new File("Fruit.JPEG"));}
		catch (Exception e) {
			e.printStackTrace();}



		try {
			myImage4 = ImageIO.read(new File("ghost.png"));}
		catch (Exception e) {
			e.printStackTrace();}

		try {
			myImage5 = ImageIO.read(new File("player.png"));}
		catch (Exception e) {
			e.printStackTrace();}

	}
	///////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////paint//////////////////////////////////////////
	/* (non-Javadoc)
	 * @see java.awt.Window#paint(java.awt.Graphics)
	 */
	//This is the function that make the painting on the jframe
	public void paint(Graphics g)
	{


		map m = new map();
		Image test=myImage.getScaledInstance(this.getWidth(), this.getHeight(), myImage.SCALE_SMOOTH);
		g.drawImage(test,10,50, this.getWidth()-20, this.getHeight()-55, null);
		//case of run game

		if(gameflag ==4 && play1.isRuning()) {
			System.out.println(123);


			board_data = play1.getBoard();
			gho = stg.serverToGhost(board_data);
			pack = stg.serverToPackman(board_data);
			fru = stg.serverToFruits(board_data);
			box = stg.serverToBox(board_data);
//			player= stg.serverToPlayer(board_data);
			player = stg.serverToPlayer(board_data);
			
			
			for (int i = 0; i < box.size(); i++) {

				map mm = new map();
				Point3D u1=m.GPS2Pixel(box.get(i).getP1());
				Point3D u2=m.GPS2Pixel(box.get(i).getP2());
				//				(u1.iy(),u2.ix(), mm.XInPix(u1, u2),mm.YInPix(u1, u2))
				g.drawRect(u2.ix()*getWidth()/Width-200,u1.iy()*getHeight()/Heigth-200,  u2.ix()-u1.ix(),u1.iy()-u2.iy());
//				g.drawRect(0,0, 100, 100);

				System.out.println(u1.y()+" " +u2.x());
				g.setColor(Color.black);
//				g.fillRect(0,0, 100, 100);

				g.fillRect(u2.ix()*getWidth()/Width-200,u1.iy()*getHeight()/Heigth-200,  u2.ix()-u1.ix()+10,u1.iy()-u2.iy()+10);
			}
			
			for (int i = 0; i < pack.size(); i++) {
				Point3D w=m.GPS2Pixel(pack.get(i).getPoint());
				g.drawImage(myImage2,((int)w.x()*getWidth())/Width,((int)w.y()*getHeight())/Heigth ,null);
			}

			for (int i = 0; i < fru.size(); i++) {
				Point3D u=m.GPS2Pixel(fru.get(i).getPoint());
				g.drawImage(myImage3,((int)u.x()*getWidth())/Width,((int)u.y()*getHeight())/Heigth,null);
			}
			for (int i = 0; i < gho.size(); i++) {
				Point3D u=m.GPS2Pixel(gho.get(i).getPoint());
				g.drawImage(myImage4,((int)u.x()*getWidth())/Width,((int)u.y()*getHeight())/Heigth,null);

			}
			
			Point3D w=m.GPS2Pixel(player.getP());
//			System.out.println(player.getP().x());
			g.drawImage(myImage5,(500),(599),null);

			
			g.drawImage(myImage5,((int)w.x()*getWidth()/Width),((int)w.y()*getHeight()/Heigth),null);


		}


		if(gameflag==0||gameflag==1) {

			for (int i = 0; i < box.size(); i++) {

				map mm = new map();
				Point3D u1=m.GPS2Pixel(box.get(i).getP1());
				Point3D u2=m.GPS2Pixel(box.get(i).getP2());
				//				(u1.iy(),u2.ix(), mm.XInPix(u1, u2),mm.YInPix(u1, u2))
				g.drawRect(u2.ix()*getWidth()/Width-200,u1.iy()*getHeight()/Heigth-200,  u2.ix()-u1.ix(),u1.iy()-u2.iy());
//				g.drawRect(0,0, 100, 100);

				System.out.println(u1.y()+" " +u2.x());
				g.setColor(Color.black);
//				g.fillRect(0,0, 100, 100);

				g.fillRect(u2.ix()*getWidth()/Width-200,u1.iy()*getHeight()/Heigth-200,  u2.ix()-u1.ix()+10,u1.iy()-u2.iy()+10);

			}
			for (int i = 0; i < pack.size(); i++) {
				Point3D w=m.GPS2Pixel(pack.get(i).getPoint());
				g.drawImage(myImage2,((int)w.x()*getWidth())/Width,((int)w.y()*getHeight())/Heigth ,null);
			}

			for (int i = 0; i < fru.size(); i++) {
				Point3D u=m.GPS2Pixel(fru.get(i).getPoint());
				g.drawImage(myImage3,((int)u.x()*getWidth())/Width,((int)u.y()*getHeight())/Heigth,null);
			}
			for (int i = 0; i < gho.size(); i++) {
				Point3D u=m.GPS2Pixel(gho.get(i).getPoint());
				g.drawImage(myImage4,((int)u.x()*getWidth())/Width,((int)u.y()*getHeight())/Heigth,null);

			}
			if(gameflag==1) {//add player
				
		
//			System.err.println(player.getP().x()+" "+player.getP().x());
			Point3D w=m.GPS2Pixel(player.getP());
		
			g.drawImage(myImage5,((int)w.x()*getWidth()/Width),((int)w.y()*getHeight()/Heigth),null);
			play1.setInitLocation(player.getP().y(),player.getP().x());

			
			}
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////mouse listener/////////////////////////////////
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg) {
		map m = new map();

		System.out.println("mouse Clicked");
		double xx = arg.getX();
		xx=xx/getWidth();
		double yy = arg.getY();
		yy=yy/getHeight();
		System.out.println("(" +arg.getX() + "," + arg.getY()+")");
		x = arg.getX()/getWidth();
		y = arg.getY()/getHeight();

		if(gameflag==1)
		{
			Point3D p= m.Pixel2GPS((( arg.getX()/(double)getWidth())*Width),(arg.getY())/((double)getHeight())*Heigth);
			player=new M(p.x(),p.y());
			
			System.out.println(player.getP().y()+" "+player.getP().x());
			play1.setInitLocation(player.getP().y(),player.getP().x());
			repaint();

			
		}
		if(gameflag==4 && play1.isRuning()) {
			System.out.println(456);
			
			MyCoords mc = new MyCoords();
			Point3D p= m.Pixel2GPS((( arg.getX()/(double)getWidth())*Width),(arg.getY())/((double)getHeight())*Heigth);
			azimuth = mc.azimuth(player.getP(), p);
//			play1.rotate(azimuth);
//			t1.run();
//			repaint();
		}

	}


	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {


	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}



	/**
	 * Read file dialog.
	 */
	public void readFileDialog() {

		//		try read from the file

		FileDialog fd = new FileDialog(this, "Open csv file", FileDialog.LOAD);

		fd.setFile("*.csv");

		//
		fd.setDirectory("C:\\Users\\naor9\\git\\Gis-class");

		fd.setFilenameFilter(new FilenameFilter() {


			@Override

			public boolean accept(File dir, String name) {

				return name.endsWith(".csv");

			}

		});

		fd.setVisible(true);

		String folder = fd.getDirectory();

		String fileName = fd.getFile();



		try {

			csvToGame ctg = new csvToGame();

			FileReader fr = new FileReader(folder + fileName);
			System.out.println(fileName);
			play1 = new Play(fileName);

			play1.setIDs(305615734,206338162);
			String map_data = play1.getBoundingBox();
			System.out.println("Bounding Box info: "+map_data);

			board_data = play1.getBoard();

			gho = stg.serverToGhost(board_data);
			pack = stg.serverToPackman(board_data);
			fru = stg.serverToFruits(board_data);
			box = stg.serverToBox(board_data);

			BufferedReader br = new BufferedReader(fr);

			repaint();



			br.close();

			fr.close();

		} catch (IOException ex) {

			System.out.print("Error reading file " + ex);

			System.exit(2);

		}


	}
	
	class MyThread3 extends Thread{
		MyThread3(String name){
			super(name);
		}
		synchronized
		public void run(){
			while (play1.isRuning()) {
//				System.out.println(azimuth);
				
				try{
					play1.rotate(azimuth);
					sleep(100);
				}
				catch(InterruptedException ex){}
				repaint();

			}
			System.out.println("Done");
			
		}
	}


}