public class Gameboard {
	private char[][] gameboard;
	private int turnNumber;
	
	public Gameboard(int rows, int columns) {
		gameboard = new char[rows][columns];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				gameboard[i][j] = '_';
			}
		}
		turnNumber = 0;
	}
	
	public void setCharacter(char player, int row, int column) {
		gameboard[row][column] = player;
		turnNumber++;
	}
	
	public char getCharacter(int row, int column) {
		return gameboard[row][column];
	}
	
	public void clearBoard(int rows, int columns) {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				gameboard[i][j] = '_';
			}
		}
	}
	
	public int getTurnNumber() {
		return this.turnNumber;
	}
	
	public void printBoard() {
		System.out.println(gameboard[0][0] + "|" + gameboard[0][1] + "|" + gameboard[0][2]);
		System.out.println(gameboard[1][0] + "|" + gameboard[1][1] + "|" + gameboard[1][2]);
		System.out.println(gameboard[2][0] + "|" + gameboard[2][1] + "|" + gameboard[2][2]);
	}
}
