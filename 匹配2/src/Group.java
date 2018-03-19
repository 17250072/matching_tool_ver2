import java.util.ArrayList;

public class Group {
	private int numberofpeople;
	int[][] rawdata;
	private ArrayList<Resultarray> resultarraylist = new ArrayList<Resultarray>();
	Resultarray resultarray;

	public Group(int n, int[][] rawdatainput) {
		numberofpeople = n;
		rawdata = rawdatainput;
		resultarray = new Resultarray(n);
	}

	private void group(int rownumber) {
		if (rownumber >= numberofpeople) {
			if (resultarray.isEnd() == 1) {
				resultarraylist.add(this.copyResultarray(resultarray));
			}else {
				//do nothing
			}
		} else {
			for (int collon = 0; collon < numberofpeople; collon++) {
				if (this.judgeOverlap(resultarray, rownumber, collon) == false&&rawdata[rownumber][collon]==1) {
					resultarray.setCollonToTrue(rownumber, collon);
					group(rownumber + 1);
				}
			}
		}
	}

	public boolean judgeOverlap(Resultarray resultarray, int row, int collon) {
		boolean result = false;
		for (int i = 0; i < row; i++) {
			if (i == row) {
				continue;
			} else {
				if (resultarray.getArray(i, collon) == 1) {
					result = true;
				}
			}
		}

		return result;
	}

	public ArrayList<Resultarray> getResultarraylist() {
		return resultarraylist;
	}

	public void printResultarraylist() {
		for (int i = 0; i < resultarraylist.size(); i++) {
			System.out.println("The " + i + " th result is:");
			for (int row = 0; row < numberofpeople; row++) {
				for (int collon = 0; collon < numberofpeople; collon++) {
					System.out.print(resultarraylist.get(i).getArray(row, collon) + " ");
				}
				System.out.println("\r\n");
			}
		}
	}

	public Resultarray copyResultarray(Resultarray resultarray) {
		Resultarray newresultarray = new Resultarray(numberofpeople);
		for (int i = 0; i < numberofpeople; i++) {
			for (int j = 0; j < numberofpeople; j++) {
				newresultarray.setResultlist(i, j, resultarray.getArray(i, j));
			}
		}
		return newresultarray;
	}
	
	public void grouping() {
		group(0);
		int position=0;
		while(position<resultarraylist.size()) {
			if(isProper(resultarraylist.get(position).getResultArray())==false) {
				resultarraylist.remove(position);
			}else {
				position++;
			}
		}
	}
	
	public boolean isProper(int[][] arrayspace) {
		int length=arrayspace.length;
		boolean result=true;
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				if(arrayspace[i][j]!=arrayspace[j][i]) {
					result=false;
				}
			}
		}
		return result;
	}
}
