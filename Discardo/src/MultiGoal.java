import java.util.*;

public class MultiGoal implements Goal
{
    private List<Goal> goals;
    
    public MultiGoal() {
    	goals = new ArrayList<Goal>();
	}

    
    public MultiGoal(List<Goal> goals) {
    	this.goals = goals;
    }
    
	public void addGoal(Goal g) {
    	goals.add(g);
    }

	public boolean hasWon(int[] hand) {
		if (goals.size() == 0) {
			Goal test1 = new AllSameGoal();
			Goal test2 = new RunGoal();
			addGoal(test1);
			addGoal(test2);
		}
		
		for (Goal g : goals) {
			if (g.hasWon(hand) == true) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return "MultiGoal";
	}
}