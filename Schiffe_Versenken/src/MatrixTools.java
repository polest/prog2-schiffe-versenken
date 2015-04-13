
/**
 * Write a description of class MatrixTools here.
 * 
 * @author ML 
 * @version 09.12.14
 */
public class MatrixTools
{
	public void print(String[][] matrix){

		String[][] printMatrix = new String[matrix.length+1][matrix.length+1];

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

	public String[][] initMatrix(String[][] matrix){	

		for(int i = 0; i < matrix[0].length; i++){
			for(int j = 0; j < matrix.length; j++){
				//Füllt Matrix mit Tilde Symbol 
				matrix[j][i] = " \u223C ";
			}
		}
		return matrix;
	}

	public String[][] addMatrix(int ival, int jval, char orientation, String[][]matrix, EShipType ship ){	
		String shipSymbol = "X";
		int length = 0;

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

		if(orientation == 'v'){
			for(int j = jval-1; j < (jval-1)+length; j++){
				//Füllt Matrix mit ShiffZahl Symbol 
				matrix[ival-1][j] = " "+ shipSymbol+" ";
			}
		}
		else{

			for(int i = ival-1; i < (ival-1)+length; i++){
				//Füllt Matrix mit ShiffZahl Symbol 
				matrix[i][jval-1] = " "+ shipSymbol+" ";
			}
		}
		return matrix;
	}



}
