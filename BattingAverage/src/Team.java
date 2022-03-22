public class Team {
	Player[] players;
	
	public Team () {
		players = new Player[12];
	}
	
	public Team(int numPlayers) {
		players = new Player[numPlayers];
	}
	
	public void printTeamStats()
    {
        for (int i = 0;i < players.length; i++)
        {
            //System.out.println("" + players[i].getName() + "        #" + players[i].getNumber() + "     average >>>  " + players[i].getBattingAverageString() +"");
        }
    }
}
