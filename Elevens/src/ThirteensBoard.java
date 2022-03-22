import java.util.List;

public class ThirteensBoard extends Board {
	
	private static final int BOARD_SIZE = 10;
	
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	
	public ThirteensBoard() {
		super();
	}

	public int[] getPointValues() {
		return POINT_VALUES;
	}
	
	public int getBoardSize() {
		return BOARD_SIZE;
	}
	
	private boolean containsPairSum13(List<Integer> selectedCards) {
		int sum = 0;
		for (int i = 0; i < selectedCards.size(); i++) {
			sum += cardAt(selectedCards.get(i)).pointValue();
		}
		
		if (sum == 13) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean containsKing(List<Integer> selectedCards) {
		boolean hasKing = false;
		
		for (int i = 0; i < selectedCards.size(); i++) {
			if (cardAt(selectedCards.get(i)).rank().contains("king")) {
				hasKing = true;
			}
		}
		
		if (hasKing) {
			return true;
		}
		return false;
	}
	
	public boolean anotherPlayIsPossible() {
		for (int x = 0; x < cards.length; x++) {
			for (int y = 0; y < cards.length; y++) {
				if (x == y) {
					continue;
				}
				if (cardAt(x) != null && cardAt(y) != null) {
					if (cardAt(x).pointValue() + cardAt(y).pointValue() == 13) {
						return true;
					}
				}
			}
		}
		
		String K = "";
		for (int i = 0; i < cards.length; i++) {
			if (cardAt(i) != null) {
				K += cardAt(i).rank();
			}
		}
		
		if (K.contains("king")) {
			return true;
		}
			
		return false;
	}
	
	public boolean isLegal(List<Integer> selectedCards) {
		if (selectedCards.size() == 2) {
			if (containsPairSum13(selectedCards)) {
				return true;
			}
		}
		
		if ((selectedCards.size() == 1)) {
			if (containsKing(selectedCards)) {
				return true;
			}
		}
		return false;
	}
}
