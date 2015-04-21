package GameShips;

/**
 * @author ML
 * 13.04.2015 version 1.0.0 
 */
public class Ship {

	protected int shipSize;
	protected int shootArea;
	protected int reloadTime;
	protected int reloadLeft;
	protected boolean isReady;
	protected boolean isSunk;
	protected int shotAtRound;
	protected int[][] coordinates;
	protected char orientation;
	protected int hitCount;

	public Ship(int shipSize, int reloadTime, int shootArea) {
		this.shipSize = shipSize;
		this.isReady = true;
		this.reloadTime = reloadTime;
		this.shootArea = shootArea;
		this.reloadLeft = this.reloadTime;
		this.isSunk = false;
		this.shotAtRound = 0;
		this.coordinates = new int[shipSize][2];
		this.orientation = 'h';
		this.hitCount = 0;
	}



	/**
	 * @return int Gibt die größe des Schiffes zurück
	 * 
	 */
	public int getShipSize() {
		return this.shipSize;
	}

	/**
	 * @return int[] Gibt die Koordinaten des Schiffes zurück
	 * 
	 */
	public int[][] getCoordinates() {
		return this.coordinates;
	}
	/**
	 * @return char Gibt die Ausrichtung des Schiffes zurück
	 * 
	 */
	public char getOrientation() {
		return this.orientation;
	}


	/**
	 * @return int Gibt die dauer der Nachladezeit zurück
	 */
	public int getReloadTime() {
		return reloadTime;
	}


	/**
	 * @return int Gibt die Schussfläche des Schiffes zurück
	 */
	public int getShootArea() {
		return shootArea;
	}


	/**
	 * startet nach jedem Schuss die nachladezeit
	 */
	public void shoot(int round) {
		this.isReady = false;
		this.shotAtRound = round;
	}

	/**
	 *  int[] Setzt die Koordinaten des Schiffes zurück
	 * 
	 */
	public void setStartPosition(int[] coordinates) {
		//X-Koordinate
		this.coordinates[0][0] = coordinates[0]-1;
		//Y-Koordinate
		this.coordinates[0][1] = coordinates[1]-1;
	}
	/**
	 * char Setzt die Ausrichtung des Schiffes zurück
	 * 
	 */
	public void setOrientation(char orientation) {
		this.orientation = orientation;
		this.setShipsCoordinates();
	}

	public boolean isSunk(){
		return this.isSunk;
	}

	/**
	 * @return boolean Gibt zurück, ob das Schiff bereit  zum Schiessen ist,
	 * oder sich noch in der Ladezeit befindet
	 */
	public boolean isLoaded(int askedRound){
		int roundsPast = askedRound - ( this.shotAtRound+1 );

		if(this.isReady == false){
			if((roundsPast % reloadTime) == 0){
				this.isReady = true;
			}
			else{
				this.isReady = false;
			}
		}
		return this.isReady;
	}

	private void setShipsCoordinates(){

		int x = this.coordinates[0][0];
		int y = this.coordinates[0][1];

		for(int i = 1; i < shipSize; i++){
			if(this.orientation == 'h'){

				x++;
			}
			else{

				y++;
			}

			this.coordinates[i][0] = x; 
			this.coordinates[i][1] = y;



		}
	}

	private void checkShipIsSunk(){

		if(this.hitCount < this.shipSize){
			this.isSunk = false;
		}
		else{
			this.isSunk = true;
			System.out.println("TREFFER! Der Zerstörer ist gesunken....");
		}
	}

	public boolean isHit(int x, int y){

		for(int i = 0; i < this.coordinates.length; i++){
			if(this.coordinates[i][0] == x && this.coordinates[i][1] == y){
				this.hitCount++;
				this.checkShipIsSunk();
				return true;

			}
		}

		return false;
	}



}
