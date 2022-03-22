import java.util.List;
import java.util.ArrayList;

// The ElevensBoard class represents the board in a game of Elevens.
 public class ElevensBoard extends Board {

	private static final int BOARD_SIZE = 9;

	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	public ElevensBoard() {
		super();
	}

	public int[] getPointValues() {
		return POINT_VALUES;
	}
	
	public int getBoardSize() {
		return BOARD_SIZE;
	}
	
	public boolean isLegal(List<Integer> selectedCards) {
		if (selectedCards.size() == 2) {
			if (containsPairSum11(selectedCards)) {
				return true;
			}
		}
		else if (selectedCards.size() == 3) {
			if (containsJQK(selectedCards)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean anotherPlayIsPossible() {
		String JQK = "";
		for (int i = 0; i < cards.length; i++) {
			if (cardAt(i) != null) {
				JQK += cardAt(i).rank();
			}
		}
		
		if (JQK.contains("jack")) {
			if (JQK.contains("queen")) {
				if (JQK.contains("king")) {
					return true;
				}
			}
		}
		
		for (int x = 0; x < cards.length; x++) {
			for (int y = 0; y < cards.length; y++) {
				if (x == y) {
					continue;
				}
				if (cardAt(x) != null && cardAt(y) != null) {
					if (cardAt(x).pointValue() + cardAt(y).pointValue() == 11) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean containsPairSum11(List<Integer> selectedCards) {
		int sum = 0;
		for (int i = 0; i < selectedCards.size(); i++) {
			sum += cardAt(selectedCards.get(i)).pointValue();
		}
		
		if (sum == 11) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean containsJQK(List<Integer> selectedCards) {
		boolean hasJack = false;
		boolean hasQueen = false;
		boolean hasKing = false;
		
		for (int i = 0; i < selectedCards.size(); i++) {
			if (cardAt(selectedCards.get(i)).rank().contains("jack")) {
				hasJack = true;
			}
			
			if (cardAt(selectedCards.get(i)).rank().contains("queen")) {
				hasQueen = true;
			}
			
			if (cardAt(selectedCards.get(i)).rank().contains("king")) {
				hasKing = true;
			}
		}
		
		if (hasJack && hasQueen && hasKing) {
			return true;
		}
		return false;
	}
}
