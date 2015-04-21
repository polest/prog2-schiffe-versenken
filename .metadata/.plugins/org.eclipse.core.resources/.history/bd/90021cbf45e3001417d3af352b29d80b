/**
 * @author ML
 * 13.04.2015 version 1.0.0
 */
public class Player {

	private boolean isActive;
	private boolean isAlive;
	private int totalShips;
	private int destroyer;
	private int frigate;
	private int corvette;
	private int submarine;
	private String playerName;
	private BattleField field;
	
	
	/**
	 * Konstruktor eins Spielers
	 * @param isActive - Gibt an ob der Spieler an der Reihe ist
	 * @param totalShips - Anzahl aller Schiffe
	 * @param destroyer - Anzahl aller Zerstörer
	 * @param frigate - Anzahl aller Fregatten
	 * @param corvette - Anzahl aller Korvetten
	 * @param submarine - Anzahl aller UBoote
	 * @param playerName - Spieler Name
	 */
	public Player(boolean isActive, int totalShips, int destroyer, int frigate,
			int corvette, int submarine, String playerName, BattleField field) {
		this.isAlive = true;
		this.isActive = isActive;
		this.totalShips = totalShips;
		this.destroyer = destroyer;
		this.frigate = frigate;
		this.corvette = corvette;
		this.submarine = submarine;
		this.playerName = playerName;
		this.field = field;
	}

	/**
	 * @return boolean - Gibt an, ob der Spieler an der Reihe ist, oder nicht
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @return  boolean - Gibt an ob der Spieler noch im Spiel dabei,
	 * oder ausgeschieden ist
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * @return Gibt die gesamt Anzahl der Schiffe des Spielers an
	 */
	public int getTotalShips() {
		return totalShips;
	}

	/**
	 * @return Gibt die Anzahl an Zerstörer an, die der Spieler besitzt
	 */
	public int getDestroyer() {
		return destroyer;
	}

	/**
	 * @return Gibt die Anzahl an Fregatten an, die der Spieler besitzt
	 */
	public int getFrigate() {
		return frigate;
	}

	/**
	 * @return Gibt die Anzahl an Korvetten an, die der Spieler besitzt
	 */
	public int getCorvette() {
		return corvette;
	}

	/**
	 * @return Gibt die Anzahl an UBooten an, die der Spieler besitzt
	 */
	public int getSubmarine() {
		return submarine;
	}

	/**
	 * @return Gibt den Spielernamen zurück
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @return Gibt das Spielfeld des Spielers zurück
	 */
	public BattleField getField() {
		return field;
	}

	/**
	 * @param isActive setzt ob der Spieler an der Reihe ist
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @param isAlive setzt ob der Spieler noch im Spiel, oder ausgeschieden ist
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	/**
	 * @param totalShips setzt die gesamt Anzahl der Schiffe des Spielers
	 */
	public void setTotalShips(int totalShips) {
		this.totalShips = totalShips;
	}

	/**
	 * @param destroyer setzt die Anzahl an Zerstörern des Spielers
	 */
	public void setDestroyer(int destroyer) {
		this.destroyer = destroyer;
	}

	/**
	 * @param frigate setzt die Anzahl an Fregatten des Spielers
	 */
	public void setFrigate(int frigate) {
		this.frigate = frigate;
	}

	/**
	 * @param corvette setzt die Anzahl an Korvetten des Spielers
	 */
	public void setCorvette(int corvette) {
		this.corvette = corvette;
	}

	/**
	 * @param submarine setzt die Anzahl an UBooten des Spielers
	 */
	public void setSubmarine(int submarine) {
		this.submarine = submarine;
	}

	/**
	 * @param field setzt das Spielfeld des Spielers
	 */
	public void setField(BattleField field) {
		this.field = field;
	}
	
	
	
}
