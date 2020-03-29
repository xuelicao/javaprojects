/**
 * This class create gameboad which is 2D array of Card objects;
 * It can display, update, and calculate the scoare of the gameboard
 * @author Xueli Cao
 *
 */
public class Board {
	//instance variable (gameBoard is 2D arrays of object Card)
	Card[][] gameBoard;
	
	//constructor
	public Board() {
		gameBoard = new Card[4][5];
		
		int counter = 1;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				gameBoard[i][j] = new Card(String.valueOf(counter), 1);
				//gameBoard[i][j].rankSuit = String.valueOf(counter);
				counter ++;
			}
		}
		gameBoard[2][0].rankSuit = " ";
		gameBoard[3][0].rankSuit = " ";
		gameBoard[2][4].rankSuit = " ";
		gameBoard[3][4].rankSuit = " ";
		
		gameBoard[2][0].value = 0;
		gameBoard[3][0].value = 0;
		gameBoard[2][4].value = 0;
		gameBoard[3][4].value = 0;
	}
	
	/**
	 * Display board
	 */
	public void display() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <5; j++) {
				System.out.format("%5s", gameBoard[i][j].rankSuit);
			}
			System.out.println();
		
		}
	}
	
	/**
	 * update board according to the position entered by player
	 * @param card
	 * @param position
	 * @return the updated gamarBoard
	 */
	public Card[][] update(Card card, int position) {
		
		if (position / 5 == 0) {
			gameBoard[0][(position % 5) - 1] = card;
		}
		else if (position / 5 != 0 & position % 5 ==0) {
			gameBoard[position / 5 - 1][4] = card;
		}
		else {
			gameBoard[position / 5][position % 5 - 1] = card;
		}
		
		gameBoard[2][0].rankSuit = " ";
		gameBoard[3][0].rankSuit = " ";
		gameBoard[2][4].rankSuit = " ";
		gameBoard[3][4].rankSuit = " ";
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <5; j++) {
				System.out.format("%5s", gameBoard[i][j].rankSuit);
			}
			System.out.println();
		
		}
		
		return gameBoard;
	}
	
	/**
	 * Calculate the score of the gameboard
	 * road map: the default value of card is 1; then assign value to the card other then Ace.
	 * calculate the Row score, column score, 1st column & 5th column separately then sum up.
	 * @return the total score of the current gameBoard.
	 */

	public int score() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				if (gameBoard[i][j].rankSuit.substring(0, 1).equals("J")||gameBoard[i][j].rankSuit.substring(0, 1).equals("Q") || gameBoard[i][j].rankSuit.substring(0, 1).equals("K")) {
					gameBoard[i][j].value = 10;
				}
				else if (gameBoard[i][j].rankSuit.substring(0, 1).equals("2")){
					gameBoard[i][j].value = 2;
				}
				else if (gameBoard[i][j].rankSuit.substring(0, 1).equals("3")){
					gameBoard[i][j].value = 3;
				}
				else if (gameBoard[i][j].rankSuit.substring(0, 1).equals("4")){
					gameBoard[i][j].value = 4;
				}
				else if (gameBoard[i][j].rankSuit.substring(0, 1).equals("5")){
					gameBoard[i][j].value = 5;
				}
				else if (gameBoard[i][j].rankSuit.substring(0, 1).equals("6")){
					gameBoard[i][j].value = 6;
				}
				else if (gameBoard[i][j].rankSuit.substring(0, 1).equals("7")){
					gameBoard[i][j].value = 7;
				}
				else if (gameBoard[i][j].rankSuit.substring(0, 1).equals("8")){
					gameBoard[i][j].value = 8;
				}
				else if (gameBoard[i][j].rankSuit.substring(0, 1).equals("9")){
					gameBoard[i][j].value = 9;
				}
				else if (gameBoard[i][j].rankSuit.length() == 3) {
					gameBoard[i][j].value = 10;
				}
			}
		}
		
		gameBoard[2][0].value = 0;
		gameBoard[3][0].value = 0;
		gameBoard[2][4].value = 0;
		gameBoard[3][4].value = 0;
		
		//calculate row score
		int[] rowScore = new int[4];
		int totalRow = 0;
		int aceNum = 0;
		int rowScoreTotal = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				totalRow += gameBoard[i][j].value;	
				if (gameBoard[i][j].rankSuit.substring(0, 1).equals("A")) {
					aceNum ++;
				}
				}
			
			if (aceNum != 0) {
				if (totalRow + 10 <= 21) {
					totalRow = totalRow + 10;
				}
			}
			
			if (totalRow == 21) {
				rowScore[i] = 7;
			}
			else if (totalRow == 20) {
				rowScore[i] = 5;
			}
			else if (totalRow == 19) {
				rowScore[i] = 4;
			}
			else if (totalRow == 18) {
				rowScore[i] = 3;
			}
			else if (totalRow == 17) {
				rowScore[i] = 2;
			}
			else if (totalRow > 21) {
				rowScore[i] = 0;
			}
			else {
				rowScore[i] = 1;
			}	
			
			totalRow = 0;
		}
		
		for (int i = 0; i < rowScore.length; i++) {
			rowScoreTotal += rowScore[i];
		}
		
		//calculate column score
		int[] columnScore = new int[3];
		int totalColumn = 0;
		int aceNum2 = 0;
		int columnScoreTotal = 0;
		for (int j = 1; j < 4; j++) {
			for (int i = 0; i < 4; i++) {
				totalColumn += gameBoard[i][j].value;	
				if (gameBoard[i][j].rankSuit.substring(0, 1).equals("A")) {
					aceNum2 ++;
				}
				}
			
			if (aceNum2 != 0) {
				if (totalColumn + 10 <= 21) {
					totalColumn = totalColumn + 10;
				}
			}
			
			if (totalColumn == 21) {
				columnScore[j-1] = 7;
			}
			else if (totalColumn == 20) {
				columnScore[j-1] = 5;
			}
			else if (totalColumn == 19) {
				columnScore[j-1] = 4;
			}
			else if (totalColumn == 18) {
				columnScore[j-1] = 3;
			}
			else if (totalColumn == 17) {
				columnScore[j-1] = 2;
			}
			else if (totalColumn > 21) {
				columnScore[j-1] = 0;
			}
			else {
				columnScore[j-1] = 1;
			}
			
			totalColumn = 0;
		}
		
		for (int i = 0; i < columnScore.length; i++) {
			columnScoreTotal += columnScore[i];
		}
		
		//calculate the score for the 1st column
		int column1stScore = 0;
		int totalColumn1st = 0;
		totalColumn1st = gameBoard[0][0].value + gameBoard[1][0].value;
		if (gameBoard[0][0].rankSuit.substring(0, 1).equals("A") ||gameBoard[1][0].rankSuit.substring(0, 1).equals("A")) {
			if (totalColumn1st + 10 <= 21) {
				totalColumn1st = totalColumn1st + 10;
			}
		}
		
		if (totalColumn1st == 21) {
			column1stScore = 10;
		}
		else if (totalColumn1st == 20) {
			column1stScore = 5;
		}
		else if (totalColumn1st == 19) {
			column1stScore = 4;
		}
		else if (totalColumn1st == 18) {
			column1stScore = 3;
		}
		else if (totalColumn1st == 17) {
			column1stScore = 2;
		}
		else if (totalColumn1st > 21) {
			column1stScore = 0;
		}
		else {
			column1stScore = 1;
		}
		

		//calculate the score for the 5th column
		int column5thScore = 0;
		int totalColumn5th = 0;
		totalColumn5th = gameBoard[0][4].value + gameBoard[1][4].value;
		if (gameBoard[0][4].rankSuit.substring(0, 1).equals("A") ||gameBoard[1][4].rankSuit.substring(0, 1).equals("A")) {
		  if (totalColumn5th + 10 <= 21) {
		    totalColumn5th = totalColumn5th + 10;
		  }
		}

		if (totalColumn5th == 21) {
		  column5thScore = 10;
		}
		else if (totalColumn5th == 20) {
		  column5thScore = 5;
		}
		else if (totalColumn5th == 19) {
		  column5thScore = 4;
		}
		else if (totalColumn5th == 18) {
		  column5thScore = 3;
		}
		else if (totalColumn5th == 17) {
		  column5thScore = 2;
		}
		else if (totalColumn5th > 21) {
		  column5thScore = 0;
		}
		else {
		  column5thScore = 1;
		}
		
		int totalScore = rowScoreTotal + columnScoreTotal + column1stScore + column5thScore;
		/*
		System.out.println("rowScore is: " + rowScoreTotal);
		System.out.println("columnScore is: " + columnScoreTotal);
		System.out.println("1st column score is: " + column1stScore);
		System.out.println("5th column score is: " + column5thScore);
		*/
		return totalScore;
	}


}
