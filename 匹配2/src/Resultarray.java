public class Resultarray {
	private int numberofpeople;
	private int[][] resultlist;

	public Resultarray(int n) {
		numberofpeople = n;
		resultlist = new int[n][n];
	}

	public void setCollonToTrue(int row, int collon) {
		if (collon >= numberofpeople || collon < 0) {
			System.out.println("The input of the row of the function setArrayToTrue is not correct!");
		} else {
			for (int collonnumber = 0; collonnumber < numberofpeople; collonnumber++) {
				if (collonnumber == collon) {
					resultlist[row][collonnumber] = 1;
				} else {
					resultlist[row][collonnumber] = 0;
				}
			}
		}
	}

	public void clearArray() {
		for (int i = 0; i < numberofpeople; i++) {
			for (int j = 0; j < numberofpeople; j++) {
				resultlist[i][j] = 0;
			}
		}
	}

	public int getArray(int row, int collon) {
		return resultlist[row][collon];
	}

	public int getNumberOfPeople() {
		return numberofpeople;
	}

	public void setResultlist(int row, int collon, int value) {
		if (collon >= numberofpeople || collon < 0 || row < 0 || row >= numberofpeople) {
			System.out.println("The input of the row or collon of the function setResultlist is not correct!");
		} else {
			resultlist[row][collon] = value;
		}
	}

	public int isEnd() {
		int result = 0;
		for (int i = 0; i < numberofpeople; i++) {
			if (resultlist[numberofpeople - 1][i] == 1) {
				result = 1;
			}
		}
		return result;
	}
	
	public int[][] getResultArray(){
		return resultlist;
	}
}
