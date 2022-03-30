import java.util.Scanner;

public class TicTacToe {
	private char player1;
	private char player2;
	private Gameboard gb;
	private char currentPlayer;
	private boolean keepPlaying;
	
	
	public TicTacToe() {
		gb = new Gameboard(3,3);
		player1 = 'X';
		player2 = 'O';
		currentPlayer = player1;
		keepPlaying = true;
	}
	
	public boolean checkGameWin() {
		if ((gb.getCharacter(0,0) == gb.getCharacter(0,1) && gb.getCharacter(0,1) == gb.getCharacter(0,2)) ||
			(gb.getCharacter(1,0) == gb.getCharacter(1,1) && gb.getCharacter(1,1) == gb.getCharacter(1,2)) ||
			(gb.getCharacter(2,0) == gb.getCharacter(2,1) && gb.getCharacter(2,1) == gb.getCharacter(2,2)) ||
			(gb.getCharacter(0,0) == gb.getCharacter(1,0) && gb.getCharacter(1,0) == gb.getCharacter(2,0)) ||
			(gb.getCharacter(0,1) == gb.getCharacter(1,1) && gb.getCharacter(1,1) == gb.getCharacter(2,1)) ||
			(gb.getCharacter(0,2) == gb.getCharacter(2,1) && gb.getCharacter(2,1) == gb.getCharacter(2,2)) ||
			(gb.getCharacter(0,0) == gb.getCharacter(1,1) && gb.getCharacter(1,1) == gb.getCharacter(2,2)) ||
			(gb.getCharacter(0,2) == gb.getCharacter(1,1) && gb.getCharacter(1,1) == gb.getCharacter(2,0))) {
				return true;
		}
		return false;
	}
	
	public void playGame(Scanner kbd, char player) {
		System.out.println("\nPlayer " + player + ", it is your turn." + "\nEnter row:");
		int row = kbd.nextInt();
		System.out.println("Enter a column:");
		int column = kbd.nextInt();
		if(checkPossibleMove(row, column))
			gb.setCharacter(player, row, column);
		else
			System.out.println("Invalid move. Space already occupied.");
		if(gb.getTurnNumber() >= 5) {
			if(checkGameWin()) {
				System.out.println("Congratluations player " + player + "!. You won. It took " + gb.getTurnNumber() + 
						" turns to win the game. Play again?");
				char response = kbd.next().charAt(0);
				if(response == 'Y' || response == 'y') {
					setPlayStatus(true);
					gb.clearBoard(3, 3);
				}	
				else
					setPlayStatus(false);
			}
		}
		if(player == player1)
			setCurrentPlayer(player2);
		else
			setCurrentPlayer(player1);
		gb.printBoard();
		
	}
	
	public boolean checkPossibleMove(int row, int column) {
		if(gb.getCharacter(row, column) == '_')
			return true;
		return false;
	}
	
	public void setCurrentPlayer(char player) {
		this.currentPlayer = player;
	}
	
	public char getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void setPlayStatus(boolean keepPlaying) {
		this.keepPlaying = keepPlaying;
	}
	
	public boolean getPlayStatus() {
		return this.keepPlaying;
	}
	
}
