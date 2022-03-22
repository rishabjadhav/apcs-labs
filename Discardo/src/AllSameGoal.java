public class AllSameGoal implements Goal
{
	
	protected int predetVal; //predetermined value
	
	public AllSameGoal() {
		this.predetVal = 0;
	}
	
	public AllSameGoal(int n) {
		this.predetVal = n;
	}
	
	public int getPredetVal() {
		return predetVal;
	}

	@Override
	public boolean hasWon(int[] hand) {
		int[] temp = hand.clone();
		
		if (predetVal != 0) {
			for (int j = 1; j < temp.length; j++) {
				if (temp[j] != predetVal) {return false;}
			}
		}
		
		else {
			int dupe = temp[0];
			
			for (int j = 1; j < temp.length; j++) {
				if (temp[j] != dupe) {return false;}
			}
		}
		return true;
	}
	
	public String toString() {
		return "AllSameGoal";
	}
	
	
}