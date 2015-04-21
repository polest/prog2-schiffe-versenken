package GamePlayer;
import GameFields.BattleField;
import GameShips.Corvette;
import GameShips.Destroyer;
import GameShips.Frigate;
import GameShips.Submarine;
import GameTools.EShipType;

/**
 * @author ML
 * 13.04.2015 version 1.0.0
 */
public class Player {

	private boolean isActive;
	private boolean isAlive;
	private int totalShips;
	private Destroyer[] destroyer;
	private Frigate[] frigate;
	private Corvette[] corvette;
	private Submarine[] submarine;
	private String playerName;
	private BattleField privateField;
	private BattleField publicField;


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
			int corvette, int submarine, String playerName, BattleField field, int enemySize) {
		this.isAlive = true;
		this.isActive = isActive;
		this.totalShips = totalShips;

		this.destroyer = new Destroyer[destroyer];
		this.frigate = new Frigate[frigate];
		this.corvette = new Corvette[corvette];
		this.submarine = new Submarine[submarine];

		for(int d = 0; d < destroyer; d++){
			this.destroyer[d] = new Destroyer();
		}

		for(int f = 0; f < frigate; f++){
			this.frigate[f] = new Frigate();
		}

		for(int c = 0; c < corvette; c++){
			this.corvette[c] = new Corvette();
		}

		for(int s = 0; s < submarine; s++){
			this.submarine[s] = new Submarine();
		}


		this.playerName = playerName;
		this.privateField = field;
		this.publicField = new BattleField(field.getSize());
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
	public Destroyer[] getDestroyer() {
		return destroyer;
	}

	/**
	 * @return Gibt die Anzahl an Fregatten an, die der Spieler besitzt
	 */
	public Frigate[] getFrigate() {
		return frigate;
	}

	/**
	 * @return Gibt die Anzahl an Korvetten an, die der Spieler besitzt
	 */
	public Corvette[] getCorvette() {
		return corvette;
	}

	/**
	 * @return Gibt die Anzahl an UBooten an, die der Spieler besitzt
	 */
	public Submarine[] getSubmarine() {
		return submarine;
	}

	/**
	 * @return Gibt den Spielernamen zurück
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @return Gibt das private Spielfeld des Spielers zurück
	 */
	public BattleField getPrivateField() {
		return this.privateField;
	}

	/**
	 * @return Gibt das öffentliche Spielfeld des Spielers zurück
	 */
	public BattleField getPublicField() {
		return this.publicField;
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
	 * @param field setzt das private Spielfeld des Spielers
	 */
	public void setPrivateField(BattleField field) {
		this.privateField = field;
	}

	/**
	 * @param field setzt das öffentliche Spielfeld des Spielers
	 */
	public void setPublicField(BattleField field) {
		this.publicField = field;
	}

	public void getAttack(EShipType ship, int[] coordinates, char orientation){
		this.publicField.setAttack(ship, coordinates, orientation, this);	
	}
	
	
	
	public void shoot(EShipType ship, int round){
		if(ship != null){
			switch(ship){
			case CORVETTE:
				boolean shootCorvette = false;
				for(int c = 0; c < this.corvette.length; c++){
					if(shootCorvette == false){
						this.corvette[c].shoot(round);
						shootCorvette = true;
					}

				}

				break;
			case DESTROYER:
				boolean shootDestroyer = false;
				for(int d = 0; d < this.destroyer.length; d++){
					if(shootDestroyer == false){
						this.destroyer[d].shoot(round);
						shootDestroyer = true;
					}
				}

				break;
			case FRIGATE:
				boolean shootFrigate = false;
				for(int f = 0; f < this.frigate.length; f++){
					if(shootFrigate == false){
						this.frigate[f].shoot(round);
						shootFrigate = true;
					}
				}
				break;
			case SUBMARINE:
				boolean shootSubmarine = false;
				for(int s = 0; s < this.submarine.length; s++){
					if(shootSubmarine == false){
						this.submarine[s].shoot(round);
						shootSubmarine = true;
					}
				}
				break;
			}

		}

	}


}
