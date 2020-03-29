import java.util.Arrays;
/*
 * Monte Carlo Simulation
 * Simulate the derangements problem to get e
 */
public class CoatExperimentSimulator {
	//instance variable
	int numberOfPeople;
	
	
	//constructor
	CoatExperimentSimulator(int numPpl) {
		numberOfPeople = numPpl;
	}
	
	//methods
	/*
	 * method that determines the number of people who get their coats back
	 * argument is an array;
	 */
	public int numPplWhoGotTheirCoat(int[] permutation) {
		int coatBackNumber = 0; 
		for (int i = 0; i < permutation.length; i++) {
			if (permutation[i] == i + 1) {
				coatBackNumber = coatBackNumber + 1;
			}
		}
		return coatBackNumber;
	}
	
	/*
	 * method that simulates coat problems and use the method above to get the number of 
	 * people who get their coat back
	 */
	public int[] simulateCoatExperiment(int iterations) {
		int[] arrayOfPplGetCoat = new int[iterations];
		for (int i = 0; i < iterations; i++) {
			arrayOfPplGetCoat[i] = numPplWhoGotTheirCoat(RandomOrderGenerator.getRandomOrder(numberOfPeople));
		}
		return arrayOfPplGetCoat;
	}
	
	/*
	 * method that calculates the probability of 0 people getting their coats back
	 * argument will be using the results from method simulateCoatExperiment()
	 */
	public double answerToQuestionA(int[] results) {
		double NumberOfZero = 0;
		for (int i = 0; i <results.length; i++) {
			if (results[i] == 0) {
				NumberOfZero ++;
			}
		}
		double probability = NumberOfZero / results.length;
		return probability;
	}
	
	/*
	 * 
	 */
	public double answertoQuestionB(int[] results) {
		double total = 0.0;
		double average = 0.0;
		for (int i = 0; i < results.length; i++) {
			total = total + results[i];
		}
		average = total / results.length;
		return average;
	}
	
	public static void main(String[] args) {

		
		//test
		
		/*
		//create an object using constructor
		CoatExperimentSimulator mySimulator = new CoatExperimentSimulator(5);
		// test the first method
		int[] values = {2,4,1,3,5};
		System.out.println(mySimulator.numPplWhoGotTheirCoat(values));
		
		
		//test the second method
		int iterations = 20;
		System.out.println(Arrays.toString(mySimulator.simulateCoatExperiment(iterations)));
		
		//test the third method
		int[] check = new int[iterations];
		check = mySimulator.simulateCoatExperiment(iterations);
		System.out.println(Arrays.toString(check));
		System.out.println(mySimulator.answerToQuestionA(check));
		
		//test the forth method
		System.out.println(mySimulator.answertoQuestionB(check));
		
		*/
		
		//submit
		
		//create a CoatExperimentSimulator with 25 people. 
		//This is where you will be using the constructor.
		CoatExperimentSimulator mySimulator = new CoatExperimentSimulator(25);
		
		//run the simulation 100000 times
		int iterations = 100000;
		int[] NumberOfPplGetCoat = new int[iterations];
		NumberOfPplGetCoat = mySimulator.simulateCoatExperiment(iterations);
		//System.out.println(NumberOfPplGetCoat.length);
		
		//print the probability of 0 people getting their coats back. 
		//Simply print the value of the variable. If the variable is called probability, 
		//please just say System.println(probability) as shown below.
		double probability = 0.0;
		probability = mySimulator.answerToQuestionA(NumberOfPplGetCoat);
		System.out.println(probability);
		
		//print the average number of people who get their coats back.
		double average = 0.0;
		average = mySimulator.answertoQuestionB(NumberOfPplGetCoat);
		System.out.println(average);
		
		//print the estimate of the value of e that you got from this procedure. 
		//Remember that the probability for 0 people getting their coats back is 1/e 
		//as the number of people gets sufficiently large 
		//(100000 is a reasonable threshold for large).
		double estimate = 1.0 / probability;
		System.out.println(estimate);
	}
}
