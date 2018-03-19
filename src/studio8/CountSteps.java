package studio8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// TODO: Develop an algorithm to count steps in accelerometer data
//    Major steeps:
//       1. Create a class and main method.
//       2. Using a Scanner and File object, read data from your .csv file.
//       3. Develop and test algorithms to count the "peaks" in the data.

public class CountSteps {
	
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("CSE132-studio8/data/Steps.csv");
		Scanner s = new Scanner(f);
		String [] l = s.nextLine().split(",");
		for(String x : l) {
			System.out.println(x);
		}
	}

	
	
}