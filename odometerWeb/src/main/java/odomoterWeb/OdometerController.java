package odomoterWeb;

public class OdometerController {
	
	public boolean isAscending(int num) {
		
        String numStr = Integer.toString(num);
        
        for (int i = 0; i < numStr.length() - 1; i++) {
            if (numStr.charAt(i) >= numStr.charAt(i + 1)) {
                return false;
            }
        }
        
        return true;
	}
	
	public int nextValue(int num) {
		
		while(true) {
			
			num++;
			
			if(isAscending(num))return num;
		}
	}
	
	public int prevValue(int num) {
		
		while(true) {
			
			num--;
			
			if(isAscending(num))return num;
		}
	}

}
