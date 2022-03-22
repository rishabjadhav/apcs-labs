import java.util.ArrayList;
import java.util.Arrays;

public class Bot implements Player
{
	private int[] hand;
	private Goal goal;
	private boolean multigoal;
	

	public void init(int[] h, Goal g)
    {
        hand = h;
        goal = g;
    }

	 public void maybeReplaceCard(int cardDrawn) {
	        System.out.println("Card Drawn:  " + cardDrawn);
	        System.out.print("Which card to discard?  ");
	        
	        if (goal.toString().contains("MultiGoal")) {
	        	multigoal = true;
	        }
	        
	        else if (goal.toString().contains("AllSameGoal")) {
	        	int need = 0;
	        	
	        	for (int i = 0; i < hand.length; i++) {
	        		for (int j = 0; j < hand.length; j++) {
	        			if ((hand[i] == hand[j]) && (i != j)) {
	        				need = hand[i];
	        				break;
	        			}
	        		}
	        	}
	        	
	        	if (need == 0) {
	        		need = hand[0];
	        	}
	        	
	        	while (true) {
		            try {
		                if (cardDrawn != need) {
		                	System.out.println(cardDrawn);
		                    System.out.println("--------------------------------------------------");
		                    return;
		                }
		                int discarded = 0;
		                if (cardDrawn == need) {
		                    for (int j = 0; j < hand.length; j++) {
		                    	if (hand[j] != need) {
		                    		discarded = hand[j];
		                    		hand[j] = cardDrawn;
		                    	}
		                    }
		                }
		                    	System.out.println(discarded);
		                        System.out.println("--------------------------------------------------");
		                        return;
		                    }
		                
		            
		            catch (NumberFormatException e) {}
	        	}
	       }
		    
	        
	    
	        /*
	        else if (goal.toString().contains("RunGoal")) {
	        	int[] temp = hand.clone();
	        	int[] need = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	        	Arrays.sort(temp);	//determines order to find the lowest index, goal becomes to find lowest number up
	        	int low = temp[0];
	        	
	        	for (int n = 0; n < need.length; n++) {
	        		if (need[n] < low || need[n] > low + hand.length - 1) {
	        			need[n] = 0;
	        		}
	        	}
	        	
	        	while (true) {
		            try {
		            	int discarded = 0;
		            	for (int i = 0; i < need.length; i++) {
		            		if (need[i] == cardDrawn) {
		            			
		            			for (int a = 0; a < hand.length; a++) {
		            				for (int b = 0; b < need.length; b++) {
		            					if (hand[a] == need[b]) {
		            						continue;
		            					}
		            					else {
		            						discarded = hand[a];
		            						hand[a] = cardDrawn;
		            						need[i] = 0;
		            						System.out.println(discarded);
		    		            			System.out.println("--------------------------------------------------");
		    		            			return;
		            					}
		            				}
		            			}
		            		}
		            		
		            		else {
		            			System.out.println(cardDrawn);
		            			System.out.println("--------------------------------------------------");
		                        return;
		            		}
		            	}
		            }
		            catch(NumberFormatException e) {}   
	        	}
	        }
	        */
	 	}
}


/*	        
	        	        
	        while (true)
	        {
	            try
	            {
	               int value = Integer.parseInt(line);
	                if (value == cardDrawn)
	                {
	                    System.out.println("--------------------------------------------------");
	                    return;
	                }
	                for (int i = 0; i < hand.length; i++)
	                {
	                    if (hand[i] == value)
	                    {
	                        hand[i] = cardDrawn;
	                        System.out.println("--------------------------------------------------");
	                        return;
	                    }
	                }
	            }
	            catch(NumberFormatException e)
	            {
	            }
	        }
	    }
	
}


Algorithm Basics
	If half or more of the deck is in the makes of a run or contain the same number, find a STRATEGY to pursue
	
	Also create specialized strategies for the goal if only one is specified
	
	AllSameGoal
		determine how many of the same number comprise of the hand, compare this to the number determined by RunGoal later
		
		if this strategy is chosen
			simply reject the card drawn unless it matches the number that much of the hand comprises of, if this is
			drawn then replace a non-matching number with a matching one
		
	RunGoal
		determine how many numbers that begin a run comprise of the hand, compare with AllSameGoal number
		
		if this strategy is chosen
			reject every card drawn unless it matches a possible run candidate, such as the number 1 more than the largest
			number in the run, or the number 1 less than the smallest number 
		
	
*/