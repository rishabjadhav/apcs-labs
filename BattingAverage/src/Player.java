public class Player {
	String name;
	int number;
	int atBats;
	int hits;
	
	public Player(String pName, int Pnum) {
		name = pName;
		number = Pnum;
		atBats = 0;
		hits = 0;
	}
	
	public Player(String pName, int PNum, int atB, int PHit) {
		name = pName;
		number = PNum;
		atBats = atB;
		hits = PHit;
	}
	
	public double getBattingAverage () {
		double avg = 0;
		if (atBats != 0) {
			avg = ((double) hits / (double) atBats);
		}
		return avg;
	}
	
	public String getBattingAverageString() {
		double avg = 0;
		String s = Double.toString(avg);
		if (atBats != 0) {
			avg = (double) hits / (double) atBats;
			s = "" + Math.round(avg * 1000);
		}
		return s;
	}
	
}

//2 : Plants

