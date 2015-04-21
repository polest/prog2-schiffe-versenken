package GameLogic;
import GameFields.BattleField;
import GamePlayer.Player;
import GameTools.EShipType;
import GameTools.IO;


/**
 * Write a description of class GameStructure here.
 * 
 * @author (ML) 
 * @version (v 1.0.0 13.04.2015)
 */
public class GameLogic
{
	private Player player[];
	private int fieldSize;
	private GameOptions game = new GameOptions();
	private int round = 1;


	public void StartGame(){

		initGameOptions();
		initGamePlayer();
		setShipsToField();
		for(int i = 0; i < 50; i++){
			System.out.println("");
		}
		startRound();
	}

	/**
	 * Ruft die für das Spiel benötigten Startwerte auf sowie die Spieloption 
	 */
	private void initGameOptions(){
		game.initGame();
		int size = game.getFieldSize();

		this.player = new Player[game.getPlayer()];
		this.fieldSize = size;
	}


	/**
	 * Legt die zuvor vom Anwender festgelegten 
	 * einzelnen Spieler mit ihren Spielfeldern und Schiffen an
	 * der erste in den Startoptionen festgelegte Spieler wird das Spiel beginnen
	 */
	private void initGamePlayer(){
		boolean isPlayerFirst = true;
		String[] names = game.getPlayerNames(); 

		for(int i = 0; i < this.player.length; i++){
			BattleField battleField = new BattleField(game.getFieldSize());
			player[i] = new Player(isPlayerFirst, game.getShips(), game.getDestroyer(), 
					game.getFrigate(), game.getCorvette(), game.getSubmarine(), names[i], battleField, this.player.length);
			isPlayerFirst = false;
		}

	}

	/**
	 *  Positionierung der Schiffe von jedem Spieler (nacheinander)
	 */
	private void setShipsToField(){
		IO.println("Der Reihe nach platziert jeder sein Schiffe!\n");

		for(int i = 0; i < player.length; i++){

			/*
			 * Das Spielfeld des Spieler wird auf der Konsole ausgedruckt
			 * und seine Schiffe vorbereitet
			 */
			//IO.println(player[i].getPlayerName() + " : ");
			player[i].getPrivateField().printPrivateField(player[i].getPlayerName());
			int destroyer = player[i].getDestroyer().length;
			int frigate = player[i].getFrigate().length;
			int corvette = player[i].getCorvette().length;
			int submarine = player[i].getSubmarine().length;

			IO.println("Spieler \"" + player[i].getPlayerName() + "\" ist an der Reihe. \n Bitte geben sie die Koordinaten ein (X,Y)");

			/*
			 * der Benutzer aufgefordert seine Schiffe zu positionieren
			 * Solange wie die eingegebenen Koordinaten ungültig sind,
			 * wird erneut aufgefordert das Schiff zu positionieren
			 */

			//ZERSTÖRER
			for(int d = 0; d < destroyer; d++){
				IO.println("Zerstörer (" + (d+1) + ")");
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
						
						this.player[i].getDestroyer()[d].setStartPosition(koordinaten);
						this.player[i].getDestroyer()[d].setOrientation(orientation);
						
						if(player[i].getPrivateField().setShips(EShipType.DESTROYER, koordinaten[0], koordinaten[1], orientation) == true){
							player[i].getPrivateField().printPrivateField(player[i].getPlayerName());
							checked = true;
						}
						else{
							IO.println("Schiff kann dort nicht positioniert werden!\nBitte erneut Koordinaten eingeben");
						}
					}
				}
			}

			//FREGATTE
			for(int f = 0; f < frigate; f++){
				IO.println("Fregatte (" + (f+1) + ")");
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

						this.player[i].getFrigate()[f].setStartPosition(koordinaten);
						this.player[i].getFrigate()[f].setOrientation(orientation);
						
						if(player[i].getPrivateField().setShips(EShipType.FRIGATE, koordinaten[0], koordinaten[1], orientation) == true){
							player[i].getPrivateField().printPrivateField(player[i].getPlayerName());
							checked = true;
						}
						else{
							IO.println("Schiff kann dort nicht positioniert werden!\nBitte erneut Koordinaten eingeben");
						}
					}
				}
			}

			//KORVETTE
			for(int k = 0; k < corvette; k++){
				IO.println("Korvette (" + (k+1) + ")");
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
						
						this.player[i].getCorvette()[k].setStartPosition(koordinaten);
						this.player[i].getCorvette()[k].setOrientation(orientation);
					
						if(player[i].getPrivateField().setShips(EShipType.CORVETTE, koordinaten[0], koordinaten[1], orientation) == true){
							player[i].getPrivateField().printPrivateField(player[i].getPlayerName());
							checked = true;
						}
						else{
							IO.println("Schiff kann dort nicht positioniert werden!\nBitte erneut Koordinaten eingeben");
						}
					}
				}
			}

			//UBOOT
			for(int s = 0; s < submarine; s++){
				IO.println("UBoot (" + (s+1) + ")");
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

						this.player[i].getSubmarine()[s].setStartPosition(koordinaten);
						this.player[i].getSubmarine()[s].setOrientation(orientation);
					
						if(player[i].getPrivateField().setShips(EShipType.SUBMARINE, koordinaten[0], koordinaten[1], orientation) == true){
							player[i].getPrivateField().printPrivateField(player[i].getPlayerName());
							checked = true;
						}
						else{
							IO.println("Schiff kann dort nicht positioniert werden!\nBitte erneut Koordinaten eingeben");
						}
					}
				}
			}
		}
	}


	/**
	 * @param pos - die zu überprüfenden Koordinaten 
	 * @return Gibt zurück, ob die eingegebenen Koordinaten korrekt sind
	 */
	private int[] checkPos(String pos){
		try{
			pos = pos.replaceAll("\\s+", "");

			String[] sKoordinaten = pos.split(",");
			int[] iKoordinaten = new int[2];

			if(sKoordinaten.length != 2){
				return null;
			}
			for(int i = 0; i < 2; i++){
				int toInt = Integer.parseInt(sKoordinaten[i]);
				if(toInt < 0 || toInt > fieldSize){
					return null;
				}
				else{
					iKoordinaten[i] = toInt;
				}
			}

			return iKoordinaten;
		}
		catch(Exception e){
			System.out.println("Ungültige Eingabe");

		}
		return null;
	}

	private void startRound(){

		boolean gameHasEnded = false;
		int enemy = -1;
		int shipId = -1;
		EShipType shipType = null;
		int[] coordinates = new int[2];
		char orientation = 'h';

		while(gameHasEnded == false){

			for(int i = 0; i < this.player.length; i++){
				IO.println("Spieler \"" + this.player[i].getPlayerName() + "\" ist an der Reihe.");
				
				if(this.player.length > 2){
					enemy = this.chooseEnemy(i);
				}
				else{
					if(i == 0){
						enemy = 1;
					}
					else{
						enemy = 0;
					}
				}

				shipId = this.chooseShip(i);

				this.player[enemy].getPublicField().printPublicField(this.player[enemy].getPlayerName());

				coordinates = this.chooseCoordinates();

				System.out.println("Horizontal (h) \nVertikal (v)");

				boolean orientationChecked = false;

				while(orientationChecked == false){
					char tempOrientation = IO.readChar();

					if(tempOrientation == 'h' || tempOrientation == 'v'){
						orientationChecked = true;
						orientation = tempOrientation;
					}
					else{
						System.out.println("Fehler! Bitte h oder v eingeben: ");
					}

				}

				switch(shipId){
				case 1: 
					shipType = EShipType.DESTROYER;
					break;
				case 2: 
					shipType = EShipType.FRIGATE;
					break;
				case 3: 
					shipType = EShipType.CORVETTE;
					break;
				case 4: 
					shipType = EShipType.SUBMARINE;
					break;


				}

				player[i].shoot(shipType, round);
				player[enemy].getAttack(shipType, coordinates, orientation);

				round++;
			}
		}

	}

	private int chooseEnemy(int playerId){
		int enemy = -1;

		IO.println("Wähle einen Gegner aus: ");
		int[] enemyId = this.printEnemyList(playerId);
		boolean enemyIsChoosen = false;

		while(enemyIsChoosen == false){

			int tempId = IO.readInt();

			for(int t = 0; t <= tempId; t++){
				if(enemyId[t] == tempId){
					enemyIsChoosen = true;
					enemy = tempId;
					IO.println("Gegner ist \" " + this.player[enemy].getPlayerName() + "\"");
				}
			}
		}
		return enemy;
	}

	private int chooseShip(int playerId){
		try{
			System.out.println("Wählen sie nun eines Ihrer Schiffe zum Schiessen aus: ");
			int[] shipId = this.printShipList(playerId);
			int ship = -1;
			boolean shipIsChoosen = false;

			while(shipIsChoosen == false){
				ship = IO.readInt();

				if(shipId[ship-1] > 0){
					shipIsChoosen = true;
				}

				if(shipIsChoosen == false){
					System.out.println("Ungültige Eingabe! Bitte Schiff auswählen: ");
				}
			}

			return ship;
		}
		catch(Exception e){
			System.out.println("Fehler in der Eingabe!");
		}
		return -1;
	}

	private int[] chooseCoordinates(){

		System.out.println("Bitte geben sie die Koordiaten an, auf die sie Schießen möchten: (X, Y)");
		boolean isChecked = false;
		int[] coordinates = null;

		while(isChecked == false){

			String tempCoordinates = IO.readString();
			coordinates = checkPos(tempCoordinates);

			if(coordinates == null){
				System.out.println("Ungültige eingabe, bitte erneut ");
			}
			else{
				isChecked = true;
			}
		}

		return coordinates;
	}

	private int[] printEnemyList(int player){
		int[] enemyIds = new int[this.player.length];
		//Druckt eine Liste aller noch im Spiel aktiven Spieler aus
		for(int j = 0; j < this.player.length; j++){
			if(j != player){
				if(this.player[j].isAlive() == true){
					IO.println(this.player[j].getPlayerName() + " (" + j + ")");
					enemyIds[j] = j;

				}
				else{
					enemyIds[j] = -123;
				}
			}
		}

		return enemyIds;
	}

	private int[] printShipList(int id){
		Player playerOnTurn = this.player[id];

		int[] shipIdToChoose = {-123,-123,-123,-123};
		/*
		 * Anzahl der Zerströrer ausgeben, welche nicht am Laden sind
		 */
		int destroyer = 0;

		for(int d = 0; d < playerOnTurn.getDestroyer().length; d++){
			if(playerOnTurn.getDestroyer()[d].isLoaded(round) == true 
					&& playerOnTurn.getDestroyer()[d].isSunk() == false){
				destroyer++;
			}

		}
		if(destroyer > 0){
			System.out.println(destroyer + "x Zerstörer (1)");
			shipIdToChoose[0] = destroyer;
		}


		/*
		 * Anzahl der Fregatten ausgeben, welche nicht am Laden sind
		 */
		int frigate = 0;

		for(int f = 0; f < playerOnTurn.getFrigate().length; f++){
			if(playerOnTurn.getFrigate()[f].isLoaded(round) == true 
					&& playerOnTurn.getFrigate()[f].isSunk() == false){
				frigate++;
			}

		}
		if(frigate > 0){
			System.out.println(frigate + "x Fregatte (2)");
			shipIdToChoose[1] = frigate;
		}

		/*
		 * Anzahl der Korvetten ausgeben, welceh nicht am Laden sind
		 */
		int corvette = 0;

		for(int c = 0; c < playerOnTurn.getCorvette().length; c++){
			if(playerOnTurn.getCorvette()[c].isLoaded(round) == true 
					&& playerOnTurn.getCorvette()[c].isSunk() == false){
				corvette++;
			}

		}
		if(corvette > 0){
			System.out.println(corvette + "x Korvette (3)");
			shipIdToChoose[2] = corvette;
		}

		/*
		 * Anzahl der UBoote ausgeben welche nicht am Laden sind
		 */
		int submarine = 0;

		for(int s = 0; s < playerOnTurn.getSubmarine().length; s++){
			if(playerOnTurn.getSubmarine()[s].isLoaded(round) == true 
					&& playerOnTurn.getSubmarine()[s].isSunk() == false){
				submarine++;
			}

		}
		if(submarine > 0){
			System.out.println(submarine + "x UBoot (4)");
			shipIdToChoose[3] = submarine;
		}

		return shipIdToChoose;
	}

}

