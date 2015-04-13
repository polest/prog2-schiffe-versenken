
/**
 * Write a description of class GameStructure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameStructure
{
	private Player player[];
	private int fieldSize[][];
	private GameOptions game = new GameOptions();
	private BattleField[] field;

	public void StartGame(){

		initGameOptions();
		initGamePlayer();
		setShipsToField();
		startRound();
	}

	private void initGameOptions(){
		game.initGame();
		int count = game.getFieldSize();

		this.player = new Player[game.getPlayer()];
		this.fieldSize = new int[count][count];
	}

	private void initGamePlayer(){
		boolean isPlayerFirst = true;
		String[] names = game.getPlayerNames(); 

		for(int i = 0; i < this.player.length; i++){
			BattleField battleField = new BattleField(game.getFieldSize(), isPlayerFirst);
			player[i] = new Player(isPlayerFirst, game.getShips(), game.getDestroyer(), 
					game.getFrigate(), game.getCorvette(), game.getSubmarine(), names[i], battleField);
			isPlayerFirst = false;
		}

	}

	private void setShipsToField(){

		for(int i = 0; i < player.length; i++){
			int c = i+1;
			IO.println("Der Reihe nach platziert jeder Spieler sein Schiffe!");

			IO.println(player[i].getPlayerName() + " : ");
			player[i].getField().printField();
			int destroyer = player[i].getDestroyer();
			int frigate = player[i].getFrigate();
			int corvette = player[i].getCorvette();
			int submarine = player[i].getSubmarine();
			
			
			IO.println("Bitte geben sie die Koordinaten ein(X, Y)");
			
			for(int d = destroyer; d > 0; d--){
				IO.println("Zerstörer (" + d + ")");
				boolean checked = false;
				
				while(checked == false){
					
					String pos = IO.readString();
					int[] koordinaten = checkPos(pos);
					
					if(koordinaten == null){
						IO.println("Fehler in der Eingabe! (X, Y)");
					}
					else{
						IO.println("Horizontal h \nVertikal v");
						char orientation = IO.readChar();
						 player[i].getField().setShips(EShipType.DESTROYER, koordinaten[0], koordinaten[1], orientation);
						 player[i].getField().printField();
						checked = true;
					}
				}
			}
			
			for(int f = frigate; f > 0; f--){
				IO.println("Fregatte (" + f + ")");
				boolean checked = false;
				
				while(checked == false){
					
					String pos = IO.readString();
					int[] koordinaten = checkPos(pos);
					
					if(koordinaten == null){
						IO.println("Fehler in der Eingabe! (X, Y)");
					}
					else{
						IO.println("Horizontal h \nVertikal v");
						char orientation = IO.readChar();
						player[i].getField().setShips(EShipType.FRIGATE, koordinaten[0], koordinaten[1], orientation);
						 player[i].getField().printField();
						checked = true;
					}
				}
			}

			for(int k = corvette; k > 0; k--){
				IO.println("Korvette (" + k + ")");
				boolean checked = false;
				
				while(checked == false){
					
					String pos = IO.readString();
					int[] koordinaten = checkPos(pos);
					
					if(koordinaten == null){
						IO.println("Fehler in der Eingabe! (X, Y)");
					}
					else{
						IO.println("Horizontal h \nVertikal v");
						char orientation = IO.readChar();
						player[i].getField().setShips(EShipType.CORVETTE, koordinaten[0], koordinaten[1], orientation);
						player[i].getField().printField();
						checked = true;
					}
				}
			}
			
			for(int s = submarine; s > 0; s--){
				IO.println("UBoot (" + s + ")");
				boolean checked = false;
				
				while(checked == false){
					
					String pos = IO.readString();
					int[] koordinaten = checkPos(pos);
					
					if(koordinaten == null){
						IO.println("Fehler in der Eingabe! (X, Y)");
					}
					else{
						IO.println("Horizontal h \nVertikal v");
						char orientation = IO.readChar();
						player[i].getField().setShips(EShipType.SUBMARINE, koordinaten[0], koordinaten[1], orientation);
						 player[i].getField().printField();
						checked = true;
					}
				}
			}
		}
	}

	private int[] checkPos(String pos){
		String[] sKoordinaten = pos.split(",");
		int[] iKoordinaten = new int[2];

		if(sKoordinaten.length != 2){
			return null;
		}
		for(int i = 0; i < 2; i++){
			int toInt = Integer.parseInt(sKoordinaten[i]);
			if(toInt < 0 || toInt > fieldSize.length){
				return null;
			}
			else{
				iKoordinaten[i] = toInt;
			}
		}

		return iKoordinaten;
	}
	
	
	private void startRound(){
		
	}

}