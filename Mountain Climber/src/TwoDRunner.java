
public class TwoDRunner {

	public static void main(String[] args) {
		TwoDArrayProbs twoDArray = new TwoDArrayProbs(new int[][] {{1, 2}, {4, 4}, { 7, 9}});
		
		
		System.out.println("Sum: " + twoDArray.sum());
		System.out.println("Is square? " + twoDArray.isSquare());
		twoDArray.addMatrix(new int [][] {{4, 3}, {1, 1}, {-1, -3}});
		
		TwoDArrayProbs twoDArray1 = new TwoDArrayProbs(new int[][] {{3, 3, 5}, {2, 5, 3}, {3}});
		//TwoDArrayProbs twoDArray1 = new TwoDArrayProbs(new int[][] {{3, 3}, {2, 5}, {3}});
		System.out.println("Column sum : " + twoDArray1.columnSum(2));
		System.out.println("Column magic? " + twoDArray1.isColumnMagic());
		TwoDArrayProbs twoDArray2 = new TwoDArrayProbs(new int[][] {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}});
		System.out.println("Diag difference " + twoDArray2.diagDifference());
	}
}
