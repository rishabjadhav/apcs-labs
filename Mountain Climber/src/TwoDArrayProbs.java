import java.util.Arrays;

public class TwoDArrayProbs {
	private int[][] nums = null;
	
	public TwoDArrayProbs () {
		this.nums = null;
	}
	
	public TwoDArrayProbs (int[][] a) {
		nums = a;
		print();
	}
	
	public int sum() {
		int sum = 0;
		for (int r = 0; r < nums.length; r++) {
			for (int c = 0; c < nums[r].length; c++) {
				sum += nums[r][c];
			}
		}
		return sum;
	}
	
	public boolean isSquare () {
		if (nums.length == nums[0].length) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void addMatrix(int[][] other) {
		for (int r = 0; r < nums.length; r++) {
			for (int c = 0; c < nums[r].length; c++) {
				nums[r][c] += other[r][c];
			}
		}
		this.print();
	}
	
	private void print() {
		for(int[] var : nums) {
			System.out.println(Arrays.toString(var));
		}
	}
	
	public int columnSum (int col) {
		int sum = 0;
		for (int r = 0; r < nums.length; r++) {
			if (col < nums[r].length) {
				sum += nums[r][col];
			}
		}
		return sum;
	}
	
	public boolean isColumnMagic() {
		int sum1 = 0;
		int sum2 = 0;
		boolean columnMagic = true;
		int r = 0;
		for (int c = 0; c < nums[r].length; c++) {
			
			if (c > 1) {
				if (sum1 != sum2) {
					return false;
				}
			}
			
			if (c > 0) {
				sum2 = sum1;
				sum1 = 0;
			}
			
			for (r = 0; r < nums.length; r++) {
				if (c < nums[r].length) {
					sum1 += nums[r][c];
				}
			}
			r = 0;
		}
		if (sum1 != sum2) return false;
		
		return columnMagic;
	}
	
	public boolean isColumnMagic1() {
		int sum = 0, temp = 0;

		for (int c = 0; c < nums[0].length; c++) {
			temp = sum;
			if (c > 1) {
				if (sum != temp) { return false; }
			}
			sum = 0;

			for (int r = 0; r < nums.length; r++) {
				if (c < nums[r].length) {
					sum += nums[r][c];
				}
			}
		}
		
		if (sum != temp) {return false;}
		
		return true;
	}
	
	public int diagDifference() {
		int sum1 = 0;
		int sum2 = 0;
		int r1 = 0, c1 = 0;
		int r2 = nums.length - 1, c2 = 0;
		
		while (r1 < nums.length && c1 < nums[r1].length) {
			sum1 += nums[r1][c1];
			r1++;
			c1++;
		}
		
		
		while (r2 >= 0 && c2 < nums[r2].length) {
			sum2 += nums[r2][c2];
			r2--;
			c2++;
			
		}
		return Math.abs(sum1 - sum2);
	}
	
}
