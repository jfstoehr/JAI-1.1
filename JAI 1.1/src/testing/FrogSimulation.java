package testing;

public class FrogSimulation {
	
	private int goalDistance;
	private int maxHops;
	
	public FrogSimulation(int dist, int numHops) {
		
		goalDistance = dist;
		maxHops = numHops;
		
	}
	
	private int hopDistance() {
		
		/* not shown */
		return -1;
		
	}
	
	public boolean simulate() {
		
		int hops = 0;
		int distance = 0;
		
		while (hops <= maxHops && distance >= 0) {
			
			distance += hopDistance();
			hops++;
			
		}
		
		if (distance >= goalDistance) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public double runSimulations(int num) {
		
		int numerator = 0;
		
		for (int i = 0; i < num; i++) {
			
			if (simulate()) {
				
				numerator++;
				
			}
			
		}
		
		return (double) numerator / num;
		
	}

}