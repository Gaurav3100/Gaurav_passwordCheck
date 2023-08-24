package highLow;

import java.util.Random;

public class HighLowController {
	
	public int checkNumber(int number , int actualNumber) {
		
		if(number > actualNumber) {
			return 1;
		}else if(number < actualNumber) {
			return 0;
		}
		return -1;
	}
	public int reset() {
		
		Random random = new Random();
		int newNum = random.nextInt(0,500)+1;
		return newNum;
	}

}
