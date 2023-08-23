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
	
	public int nextValue(int num , int numDigits) {
		
		while(true) {
			
			num++;
			if(num == largestDigitNumber(numDigits))num = lowestDigitNumber(numDigits);
			
			if(isAscending(num))return num;
		}
	}
	
	public int prevValue(int num , int numDigits) {
		
		while(true) {
			
			num--;
			
			if(num == lowestDigitNumber(numDigits))num = largestDigitNumber(numDigits);
			
			if(isAscending(num))return num;
		}
	}
	
	public int lowestDigitNumber(int numDigits) {
		
        int lowestNumber = 0;
        for (int i = 1; i <= numDigits; i++) {
            lowestNumber = lowestNumber * 10 + i;
        }
        return lowestNumber;
		
	}
	
	public int largestDigitNumber(int numDigits) {
		
        int largestNumber = 0;
        for (int i = numDigits; i > 0; i--) {
        	largestNumber = largestNumber * 10 + (10-i);
        }
        return largestNumber;
		
	}

}
