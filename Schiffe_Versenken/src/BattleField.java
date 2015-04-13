
public class BattleField {

	private String[][] field;
	private int size;
	private boolean isChoosen;
	private boolean isBlocked;
	private boolean isFree;
	private MatrixTools matrixTools = new MatrixTools();
	
	public BattleField(int size, boolean isChoosen) {
		this.size = size;
		this.isChoosen = isChoosen;
		this.field = new String[this.size][this.size];
		
		initField();
	}

	private void initField(){
		field = matrixTools.initMatrix(field);
	}
	
	public String[][] getField() {
		return this.field;
	}

	public int getSize() {
		return this.size;
	}

	public boolean isChoosen() {
		return this.isChoosen;
	}

	public boolean isBlocked() {
		return this.isBlocked;
	}

	public boolean isFree() {
		return this.isFree;
	} 
	
	public void printField(){
		matrixTools.print(this.field);
	}
	
	public void setShips(EShipType ship, int iPos, int jPos, char orientation){
		field = matrixTools.addMatrix(iPos, jPos, orientation, field, ship);
	}
	
}
