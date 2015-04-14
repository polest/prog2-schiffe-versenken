
public class BattleField {

	private String[][] field;
	private int size;
	private boolean isBlocked;
	private boolean isFree;
	private MatrixTools matrixTools = new MatrixTools();
	
	/**
	 * Konstruktor eins Spielfeldes
	 * @param size Seitengröße des Spielfeldes (quadratisch)
	 */
	public BattleField(int size) {
		this.size = size;
		this.field = new String[this.size][this.size];
		
		initField();
	}

	/**
	 * Initialisiert Matrix in ausgewälter größe und platziert 
	 * Tilden als Startwerte (Leeres Spielfeld)
	 */
	private void initField(){
		field = matrixTools.initMatrix(field);
	}
	
	/**
	 * @return gibt das Spielfeld zurück
	 */
	public String[][] getField() {
		return this.field;
	}

	/**
	 * @return gibt die Größe des Spielfeldes zurück
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * @return gibt zurück, ob das Spielfeld 
	 */
	public boolean isBlocked() {
		return this.isBlocked;
	}

	/**
	 * @return
	 */
	public boolean isFree() {
		return this.isFree;
	} 
	
	/**
	 * Druckt das Spielfeld auf der Konsole aus
	 */
	public void printField(){
		matrixTools.print(this.field);
	}
	
	/**
	 * Setzen der Schiffe auf dem Spielfeld, sofern möglich
	 * @param ship - Schifftyp (ENUM - EShipType)
	 * @param iPos - X-Koordinaten des Startfeldes
	 * @param jPos - Y-Koordinate des Startfeldes
	 * @param orientation - Ausrichtung v oder h
	 * @return gibt zurück ob das Schiff platziert werden konnte
	 */
	public boolean setShips(EShipType ship, int iPos, int jPos, char orientation){
		boolean isFree = true;
		if( (isFree = matrixTools.checkFields(iPos, jPos, orientation, field, ship)) == true){
				field = matrixTools.addMatrix(iPos, jPos, orientation, field, ship);
		}
		return isFree;
		
	}
	
}
