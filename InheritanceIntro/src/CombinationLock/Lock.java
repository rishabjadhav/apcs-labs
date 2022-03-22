package CombinationLock;

public class Lock {
	private boolean locked;
	
	public Lock () {
		locked = true;
	}
	
	
	public void open () {
		locked = false;
	}
	
	public void close () {
		locked = true;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public String toString() {
		if (locked) {
			return "The lock is closed";
		}
		else {
			return "The lock is open";
		}
	}

}
