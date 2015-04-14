package Ships;

/**
 * @author ML
 * 13.04.2015 version 1.0.0 
 */
public class Ship {
	
	protected int shipSize;
	protected int shootArea;
	protected int reloadTime;
	private int reloadLeft;
	protected boolean isReady;
	protected boolean isSunk;
	
	public Ship(int shipSize, int reloadTime, int shootArea) {
		this.shipSize = shipSize;
		this.isReady = true;
		this.reloadTime = reloadTime;
		this.shootArea = shootArea;
		this.reloadLeft = this.reloadTime;
		this.isSunk = false;
	}



	/**
	 * @return int Gibt die größe des Schiffes zurück
	 * 
	 */
	public int getShipSize() {
		return shipSize;
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
	public void shoot() {
		this.isReady = false;
	}
	
	/**
	 * Wenn das Schiff geschossen hat, wird jede Runde die Wartezeit um 1 
	 * dekrementiert, bis es wieder 0 ist
	 * Die vorgesehene Nachladezeit wird beim nächsten Schuss
	 * erneut gezählt
	 * 
	 */
	protected void nextRound(){
		if(this.isReady == false){
			this.reloadLeft--;
		 
			if(this.reloadLeft == 0){
				this.reloadLeft = this.reloadTime;
				this.isReady = true;
			}
		
		}
	}
	
	/**
	 * @return boolean Gibt zurück, ob das Schiff bereit  zum Schiessen ist,
	 * oder sich noch in der Ladezeit befindet
	 */
	public boolean isLoaded(){
		return this.isReady;
	}
	
	

}