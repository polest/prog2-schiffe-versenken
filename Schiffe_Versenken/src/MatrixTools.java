
/**
 * Write a description of class MatrixTools here.
 * 
 * @author ML 
 * @version 09.12.14
 */
public class MatrixTools
{
	/**
	 * @param matrix 
	 * Druckt die Matrix als Spielfeld 
	 * mit Grafischen Extras auf der Konsole aus
	 * Die Matrix mit verschönerungen wird nur ausgedruckt und 
	 * nicht gespeichert oder zurückgegeben!
	 */
	public void print(String[][] matrix){

		//Um 1 größere Matrix als das Spielfeld 
		String[][] printMatrix = new String[matrix.length+1][matrix.length+1];

		/*In die neue Matrix wird um die eigentliche Matrix oben und links 
		 * Koordinaten zur besseren Auswahl des Feldes eingefügt
		 * 
		 */

		for(int i = 0; i < printMatrix.length; i++){

			for(int j = 0; j < printMatrix.length; j++){

				if(i == 0){
					if(j == 0){
						printMatrix[i][j] = " x ";
					}
					else{
						printMatrix[i][j] = " " + j + " ";
					}
				}
				else{
					if(j == 0){
						printMatrix[i][j] = " " + i + " ";
					}
					else{
						int index = i-1;
						int jIndex = j-1;

						printMatrix[i][j] = matrix[index][jIndex];
					}
				}
			}

		}

		/*
		 * Nun die eigentlichen Werte des Spielfeldes mit Strichen und Eck-Symbolen
		 * um optisch ein Rastergitter zu erhalten
		 * \u250C - obere linke Ecke
		 * \u2500 - horizontale Striche
		 * \u2510 - obere rechte Ecke
		 * \u2502 - senkrechte Striche
		 * \u2514 - untere linke Ecke
		 * \u2518 - untere rechte Ecke
		 */
		for(int i = 0; i < printMatrix[0].length; i++){
			IO.print("\u250C");
			for(int k = 0; k < printMatrix[0].length; k++){
				if(k == 0){
					IO.print("\u2500\u2500\u2500");
				}
				else{
					IO.print("\u2500\u2500\u2500\u2500");
				}
			}
			IO.print("\u2510");
			IO.println("");
			for(int j = 0; j < printMatrix.length; j++){
				IO.print("\u2502" + printMatrix[j][i]);
				//IO.print("\t");
			}

			IO.print("\u2502");
			IO.println("");
		}
		IO.print("\u2514");

		for(int l = 0; l < printMatrix[0].length; l++){
			if(l == 0){
				IO.print("\u2500\u2500\u2500");
			}
			else{
				IO.print("\u2500\u2500\u2500\u2500");
			}
		}
		IO.print("\u2518");
		IO.println("");

	}


	/**
	 * @param matrix - Spielfeld Matrix
	 * @return gibt die grafische Ausgangs Matrix (Spielfeld) zurück
	 * Das Spielfeld wird standardmäßig mit Tilden für nicht belegte Felder gefüllt
	 * 
	 */
	public String[][] initMatrix(String[][] matrix){	

		for(int i = 0; i < matrix[0].length; i++){
			for(int j = 0; j < matrix.length; j++){
				//Füllt Matrix mit Tilde Symbol 
				matrix[j][i] = " \u223C ";

			}
		}
		return matrix;
	}

	/**
	 * @param ival - Benutzereingabe X-Koordinate
	 * @param jval - Benutzereingabe Y-Koordinate
	 * @param orientation - Benutzereingabe Richtung der Schiffspositionierung
	 * @param matrix - Spielfeld des jeweiligen Spielers
	 * @param ship - ausgewählte Schiff
	 * @return Gibt das mit dem ausgewähltem Schiff positionierte Spielfeld zurück 
	 */
	public String[][] addMatrix(int ival, int jval, char orientation, String[][]matrix, EShipType ship ){	
		//Koordinaten beginnen ab 1, Array aber ab 0 daher um 1 inkrementieren für equivalenten Wert
		ival--;
		jval--;

		String shipSymbol = "X";
		int length = 0;

		/*Je nach ausgewähltem Schiffstyp 
		 *ein Kennzeichnungssymbol sowie die Schiffslänge setze
		 */
		switch(ship){
		case DESTROYER:
			shipSymbol = "D";
			length = 5;
			break;

		case FRIGATE:
			shipSymbol = "F";
			length = 4;
			break;

		case CORVETTE:
			shipSymbol = "C";
			length = 3;
			break;

		case SUBMARINE:
			shipSymbol = "S";
			length = 2;
			break;
		}

		//Bei vertikaler Ausrichtung des Schiffes
		if(orientation == 'v'){
			for(int j = jval; j < jval + length; j++){
				//Füllt Matrix mit dem Symbol des jeweiligen Schiffes
				matrix[ival][j] = " "+ shipSymbol+" ";
			}
		}
		//Bei horizontaler Ausrichtung des Schiffes
		else{

			for(int i = ival; i < ival+length; i++){
				//Füllt Matrix mit dem Symbol des jeweiligen Schiffes
				matrix[i][jval] = " "+ shipSymbol+" ";
			}
		}
		return matrix;
	}

	
	/**
	 * @param ival - Benutzereingabe X-Koordinate
	 * @param jval - Benutzereingabe Y-Koordinate
	 * @param orientation - Benutzereingabe Richtung der Schiffspositionierung
	 * @param matrix - Spielfeld des jeweiligen Spielers
	 * @param ship - ausgewählte Schiff
	 * @return Ein boolschen Wert, ob das Schiff an der ausgewählten Position und Ausrichtung
	 * basierend auf den Spielregeln positioniert werden kann oder nicht
	 */
	public boolean checkFields(int ival, int jval, char orientation, String[][]matrix, EShipType ship){
		//Koordinaten beginnen ab 1, Array aber ab 0 daher um 1 inkrementieren für equivalenten Wert
		ival--;
		jval--;

		int length = 0;

		//Schifflänge anhand des Ausgewählten Schiffes
		switch(ship){
		case DESTROYER:
			length = 5;
			break;

		case FRIGATE:
			length = 4;
			break;

		case CORVETTE:
			length = 3;
			break;

		case SUBMARINE:
			length = 2;
			break;
		}

		int jIndex = jval;
		int iIndex = ival;
		int jDifTop = 1;
		int iDifLeft = 1;
		int jDifBottom = 1;
		int iDifRight = 1;

		//Bei vertikaler Ausrichtung
		if(orientation == 'v'){
			
			/*
			 * Da die Umgebenen Positionen des Schiffes geprüft werden,
			 * muss der Abstand nach links, rechts, oben oder unten
			 * auf 0 gesetzt werden, sofern es in einer der Ecken beginnt oder
			 * die Länge einer dieser Ecken erreicht
			 * 
			 * Ansonsten wird der Abstand als 1 Feld links/oben, das eigene Feld sowie 1 Feld rechts/unten
			 * mitüberprüft
			 * -> sonst ArrayOutOfBounds
			 */
			
			//obere Ecke
			if(jIndex == 0){
				jDifTop = 0;
			}
			//linke Ecke
			if(iIndex == 0){
				iDifLeft = 0;
			}
			//untere Ecke
			if( (jIndex + length) == matrix.length){
				jDifBottom = 0;
			}
			//rechte Ecke
			if(iIndex == (matrix.length - 1) ){
				iDifRight = 0;
			}

			//Koordinaten Länge des Schiffes ab der gewählten Position
			int shipLength = jIndex + length;

			/*Wenn die Schiffslänge ab den gewählten Startkoordinaten 
			 * länger ist als die Feldlänge, ist eine positionierung nicht möglich
			 */
			if(shipLength > matrix.length){
				return false;
			}

			/*
			 * Ansonsten, prüfe nun ob das Schiff in Vertikaler ausrichtung 
			 * an ein anderes Schiff anrenzt
			 */
			for(int j = (jIndex - jDifTop); j < (shipLength + jDifBottom); j++ ){
				for( int i = (iIndex - iDifLeft); i <= (iIndex + iDifRight); i++){
					IO.println("j: " + j + " i: " + i);
					if(matrix[i][j] != " \u223C "){
						return false;
					}
				}
			}
		}
		else{

			//obere Ecke
			if(jIndex == 0){
				jDifTop = 0;
			}
			//linke Ecke
			if(iIndex == 0){
				iDifLeft = 0;
			}
			//untere Ecke
			if( jIndex == (matrix.length - 1) ){
				jDifBottom = 0;
			}
			//rechte Ecke
			if( (iIndex + length ) == matrix.length ){
				iDifRight = 0;
			}
			int shipLength = iIndex + length;

			/*Wenn die Schiffslänge ab der gewählten Startkoordinaten 
			 * länger ist als die Feldlänge, ist eine positionierung nicht möglich
			 */
			if( (shipLength) > matrix.length){
				return false;
			}

			/*
			 * Ansonsten, prüfe nun ob das Schiff in Vertikaler ausrichtung 
			 * an ein anderes Schiff anrenzt
			 */
			for(int j = (jIndex - jDifTop); j <= (jIndex + jDifBottom); j++ ){
				for( int i = (iIndex - iDifLeft); i < (shipLength + iDifRight); i++){
					IO.println("j: " + j + " i: " + i);
					if(matrix[i][j] != " \u223C "){
						return false;
					}
				}
			}
		}
		return true;

	}

}
