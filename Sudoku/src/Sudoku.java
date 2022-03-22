import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku {

	private int[][] sudoku = new int[9][9];
	
	public Sudoku() {
		
	}
	
	public Sudoku(int[][] sudoku) {
		this.sudoku = sudoku;
	}
	
	public String toString() {
		String puzzle = "";
		for(int i = 0; i < 9; i++) {
			puzzle += Arrays.toString(sudoku[i]);
			puzzle += "\n";
		}
		return puzzle;
	}
	
	public ArrayList<Integer> inBox (int r, int c) {
		int rowS = 0, colS = 0;
		ArrayList<Integer> box = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		
		if ((r < 3) && (c < 3)) {
			//box 1
			rowS = 0; colS = 0;
		}
		else if ((r < 3) && (c < 6)) {
			//box 2
			rowS = 0; colS = 3;
		}
		else if (r < 3) {
			//box 3
			rowS = 0; colS = 6;
		}
		
		if ((r > 2) && (r < 6) && (c < 3)) {
			//box 4
			rowS = 3; colS = 0;
		}
		else if ((r > 2) && (r < 6) && (c < 6)) {
			//box 5
			rowS = 3; colS = 3;
		}
		else if ((r > 2) && (r < 6)) {
			//box 6
			rowS = 3; colS = 6;
		}
		
		if ((r > 5) && (c < 3)) {
			//box 4
			rowS = 6; colS = 0;
		}
		else if ((r > 5) && (c < 6)) {
			//box 8
			rowS = 6; colS = 3;
		}
		else if (r > 5){
			//box 9
			rowS = 6; colS = 6;
		}

		for (int row = rowS; row < rowS + 3; row++) {
			for (int col = colS; col < colS + 3; col++) {
				
				if (sudoku[row][col] == 0) {continue;}
				
				for (int j = 0; j < box.size(); j++) {
					if (box.get(j) == sudoku[row][col]) {
						box.remove(j);
						j--;
					}
				}
			}
		}
		return box;
		
	}
	
	public ArrayList<Integer> inCol (int c) {
		ArrayList<Integer> col = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < col.size(); j++) {
				if (col.get(j) == sudoku[i][c]) {
					col.remove(j);
					j--;
				}
			}
		}
		return col;
		
	}
	
	public ArrayList<Integer> inRow (int r) {
		ArrayList<Integer> row = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		for (int i = 0; i < 9; i++) {
				for (int j = 0; j < row.size(); j++) {
					if (row.get(j) == sudoku[r][i]) {
						row.remove(j);
						j--;
					}
				}
		}
		return row;
	}
	
	public int narrow (ArrayList<Integer> row, ArrayList<Integer> col, ArrayList<Integer> box) {
		ArrayList<Integer> rowcol = new ArrayList<Integer>();
		ArrayList<Integer> colbox = new ArrayList<Integer>();
		ArrayList<Integer> fin = new ArrayList<Integer>();
		
		for (int i = 0; i < row.size(); i++) {
			for (int j = 0; j < col.size(); j++) {
				if (row.get(i) == col.get(j)) {
					rowcol.add(row.get(i));
				}
				
			}
		}
		
		for (int i = 0; i < col.size(); i++) {
			for (int j = 0; j < box.size(); j++) {
				if (col.get(i) == box.get(j)) {
					colbox.add(col.get(i));
				}
				
			}
		}
		
		for (int i = 0; i < rowcol.size(); i++) {
			for (int j = 0; j < colbox.size(); j++) {
				if (rowcol.get(i) == colbox.get(j)) {
					fin.add(rowcol.get(i));
				}
				
			}
		}
		if (fin.size() == 1) {
			return fin.get(0);
		}
		else {
			return 0;
		}
	}
	
	public void solve () {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (sudoku[r][c] != 0) {continue;}
				
				sudoku[r][c] = narrow(inRow(r), inCol(c), inBox(r, c));
			}
		}
	}
	
	public boolean isSolved () {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (sudoku[r][c] == 0) {return false;}
				
			}
		}
		return true;
	}

	
}
	
	

