
public class GameOptions {

	private int player;
	private String[] playerNames;
	private int fieldSize;
	private int destroyer;
	private int frigate;
	private int corvette;
	private int submarine;
	private int ships;


	/**
	 * Kontruktor der Optionen
	 * Setzt Standard Werte der Einstellungen
	 */
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

	/**
	 * Spielstart ruft die Optionen für Spieler, Spielfeld und Schiffe auf
	 */
	public void initGame(){
		IO.println("Willkommen bei BATTLESHIP special LARS edition!\n"
				+ "um das Spiel zu beginnen, müssen Sie zunächst einmal\n"
				+ "das Spiel konfigurieren.");

		initPlayer();
		initField();
		initShips();
	}


	/**
	 * @return gibt die Anzahl der Spieler zurück
	 */
	public int getPlayer() {
		return player;
	}

	/**
	 * @return gibt die festgelegte Feldgröße zurück
	 */
	public int getFieldSize() {
		return fieldSize;
	}

	/**
	 * @return gibt die festgelegte Anzahl an Zerstörern zurück
	 */
	public int getDestroyer() {
		return destroyer;
	}

	/**
	 * @return gibt die festgelegte Anzahl an Fregatten zurück
	 */
	public int getFrigate() {
		return this.frigate;
	}


	/**
	 * @return gibt die festgelegte Anzahl an Korvetten zurück
	 */
	public int getCorvette() {
		return corvette;
	}

	/**
	 * @return gibt die festgelegte Anzahl an UBooten zurück
	 */
	public int getSubmarine() {
		return submarine;
	}


	/**
	 * @return gibt die Liste der Spielernamen zurück
	 */
	public String[] getPlayerNames(){
		return this.playerNames;
	}

	/**
	 * @return gibt die gesamt Anzahl an Schiffen zurück
	 */
	public int getShips(){
		return ships;
	}

	/**
	 * Einstellungen der Spieleranzahl und ihre Namen
	 */
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

	/**
	 * Einstellung der Größe des Spielfeldes
	 */
	private void initField(){
		IO.println("Bitte geben sie die Seitengröße des quadratischen Feldes ein: (mind. 6!)");

		int anzahl = IO.readInt();

		while(anzahl < 6){
			IO.println("Ungültige Eingabe. Bitte eine Zahl größer als 5 eingeben!");
			anzahl = IO.readInt();
		}

		this.fieldSize = anzahl;
	}

	/**
	 * Einstellung der Anzahl jeweiliger Schiffe
	 */
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
