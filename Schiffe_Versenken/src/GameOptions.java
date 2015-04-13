
public class GameOptions {

	private int player;
	private String[] playerNames;
	private int fieldSize;
	private int destroyer;
	private int frigate;
	private int corvette;
	private int submarine;
	private int ships;

	public GameOptions(){
		this.player = 2;
		this.fieldSize = 10;
		this.destroyer = 1;
		this.frigate = 2;
		this.corvette = 2;
		this.submarine = 1;
		this.ships = 6;

		this.playerNames = new String[2];
		this.playerNames[0] = "Spieler 1";     
		this.playerNames[1] = "Spieler 2";

	}

	public void initGame(){
		IO.println("Willkommen bei BATTLESHIP special LARS edition!\n"
				+ "um das Spiel zu beginnen, müssen Sie zunächst einmal\n"
				+ "das Spiel konfigurieren.");

		initPlayer();
		initField();
		initShips();
	}

	public int getPlayer() {
		return player;
	}

	public int getFieldSize() {
		return fieldSize;
	}

	public int getDestroyer() {
		return destroyer;
	}

	public int getFrigate() {
		return this.frigate;
	}


	public int getCorvette() {
		return corvette;
	}

	public int getSubmarine() {
		return submarine;
	}

	public String[] getPlayerNames(){
		return this.playerNames;
	}

	public int getShips(){
		return ships;
	}

	private void initPlayer(){

		IO.println("Bitte wählen sie die Anzahl der Spieler aus [2-6]: ");
		int anzahl = IO.readInt();

		while(anzahl < 2 || anzahl > 6){
			IO.println("Ungültige Eingabe. Bitte zwischen 2-6 auswählen!");
			anzahl = IO.readInt();
		}

		this.player = anzahl;
		this.playerNames = new String[anzahl];
		for(int i = 0; i < anzahl; i++){
			int c = i+1;
			IO.println("Spieler " + c + " Name: ");
			this.playerNames[i] = IO.readString();

		}
	}

	private void initField(){
		IO.println("Bitte geben sie die Seitengröße des quadratischen Feldes ein: (mind. 5!)");

		int anzahl = IO.readInt();

		while(anzahl < 5){
			IO.println("Ungültige Eingabe. Bitte eine Zahl größer als 5 eingeben!");
			anzahl = IO.readInt();
		}

		this.fieldSize = anzahl;
	}

	private void initShips(){

		IO.println("Bitte geben sie nun die Anzahl der Schiffe an:\n"
				+"Zerströrer:");
		this.destroyer = IO.readInt();

		IO.println("Fregatten:");
		this.frigate = IO.readInt();

		IO.println("Korvetten:");
		this.corvette = IO.readInt();

		IO.println("UBoote:");
		this.submarine = IO.readInt();

		this.ships = this.destroyer + this.frigate + this.corvette + this.submarine;
	}



}