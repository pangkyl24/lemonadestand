//LemonadeStand.java

//Import Doodlepad Library
import doodlepad.*;

//Main Class as a subclass of Pad
public class LemonadeStand extends Pad
{	
	public boolean gameStarted;
	Text startGame;
	public int lemons;
	public int ice;
	public int cups;
	public int sugar;
	
	public double funds;
	
	
	Text showLemons;
	Text showIce;
	Text showSugar;
	Text showCups;
		
	Text showFunds;
	
	
	
	//Define constructor to set up the UI
	public LemonadeStand() {
		
		//Invoke the Pad constructor to set Window Title and Size
		super("LemonadeStand", 800, 650);	
		gameStarted = false;
		
		//Inventory
		lemons = 5;
		ice = 0;
		cups = 0;
		sugar = 5;
		
		funds = 20.0;
		
		//Draw the Field
		Rectangle background = new Rectangle(0, 0, 1000, 1000); //Background
		background.setFillColor(80, 170, 255);
		Rectangle grass = new Rectangle(0, 500, 1000, 1000); //Grass
		grass.setFillColor(0, 255, 50);
		Oval sun = new Oval(-75, -75, 150, 150); //Sun
		sun.setFillColor(255, 180, 0);

		Rectangle base = new Rectangle(200, 400, 200, 150); //LemonadeStand
		base.setFillColor(255, 255, 0);
		Rectangle base2 = new Rectangle(190, 400, 220, 15);
		base2.setFillColor(255, 255, 180);
		Rectangle base3 = new Rectangle(225, 440, 150, 25);
		base3.setFillColor(255, 255, 255);
		Text sign = new Text("Lemonade Stand", 230, 445, 18);
		sign.setFillColor(0, 0, 0);
		Rectangle pillar1 = new Rectangle(200, 300, 5, 100);
		pillar1.setFillColor(0, 0, 0);
		Rectangle pillar2 = new Rectangle(395, 300, 5, 100);
		pillar2.setFillColor(0, 0, 0);
		RoundRect top = new RoundRect(190, 250, 220, 50, 15, 15);
		top.setFillColor(255, 255, 0);
		
		startGame = new Text("Press to Play", 230 ,150, 25); //Play Button -> Game Start Condition
		
		while (gameStarted == false){
			
			startGame.setMouseClickedHandler( this::begin );
			
		}
		//System.out.println("Game has Started"); //Debug
		//Rest of the Game Code Below::: WIP
		
		//Shopping
		Rectangle buyLemons = new Rectangle(25, 100, 100, 30);
		Rectangle buyIce = new Rectangle(150, 100, 100, 30);
		Rectangle buySugar = new Rectangle(275, 100, 100, 30);
		Rectangle buyCups = new Rectangle(400, 100, 100, 30);
		
		Text textLemons = new Text("Buy Lemons: $1.25 for 5", 25, 90, 10);
		Text textIce = new Text("Buy Ice: $0.75 for 25", 150, 90, 10);
		Text textSugar = new Text("Buy Sugar: $2.50 for 5", 275, 90, 10);
		Text textCups = new Text("Buy Cups: $0.50 for 20", 400, 90, 10);
		
		showLemons = new Text("" + lemons, 30, 110, 15);
		showIce = new Text("" + ice, 155, 110, 15);
		showSugar = new Text("" + sugar, 280, 110, 15);
		showCups = new Text("" + cups, 405, 110, 15);
		
		showFunds = new Text("Funds: $" + String.format("%.2f", funds), 300, 50, 30);
		
		boolean gamePlaying = true;
		String gamePhase = "buying";
		
		do{ // Play Game Method[][][]
			
			while (gamePhase.equals("buying")){
				
				buyLemons.setMouseClickedHandler( this::lemonbuy );
				buyIce.setMouseClickedHandler( this::icebuy );
				buySugar.setMouseClickedHandler( this::sugarbuy );
				buyCups.setMouseClickedHandler( this::cupsbuy );
				
			}
			
			
			
		} while (gamePlaying == true);
		
		
		
			
	}
	//[[Events]]\\
	//Set gameStarted to True
	public void begin(Shape shp, double x, double y, int button){
		
		shp.setVisible(false);
		gameStarted = true;
		
	}
	
	public void updateInventory(){ //Updates the Text in the inventory when called on
		showLemons.setText("" + lemons);
		showIce.setText("" + ice);
		showSugar.setText("" + sugar);
		showCups.setText("" + cups);
		showFunds.setText("Funds: $" + String.format("%.2f", funds));
	}
	public void lemonbuy(Shape shp, double x, double y, int button){
		if (funds >= 1.25){
			lemons += 5;
			funds -= 1.25;
		}
		updateInventory();
	}
	public void icebuy(Shape shp, double x, double y, int button){
		if (funds >= 0.75){
			ice += 25;
			funds -= 0.75;
		}
		updateInventory();
	}
	public void cupsbuy(Shape shp, double x, double y, int button){
		if (funds >= 0.50){
			cups += 20;
			funds -= 0.50;
		}
		updateInventory();
	}
	public void sugarbuy(Shape shp, double x, double y, int button){
		if (funds >= 2.50){
			sugar += 5;
			funds -= 2.50;
			
		}
		updateInventory();
	}
	
	
	
	//Main Method -> Starts Game	
	public static void main(String[] args){
		new LemonadeStand();
	}
	
}
