package challenge;

import java.util.Scanner;

interface AdvancedArithmetic{
   int divisorSum(int n);
}
class Calculator implements AdvancedArithmetic {
    public int divisorSum(int n) {
    	int total = 0;
    	int counter = n;
    	while(counter > 0) {
    		if(n % counter == 0) {
    			total += counter;
    		}
    		counter--;
    	}
        return total;
    }
}

class AdvancedAritmetic {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        
      	AdvancedArithmetic myCalculator = new Calculator(); 
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}