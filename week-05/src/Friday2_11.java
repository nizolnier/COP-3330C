import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Friday2_11 {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner s = new Scanner(new File("data"));
		//ArrayList<String> list = new ArrayList<String>();

		String[] tokens;
		// print the file data to the screen
		String buffer;
		String name = "";

		int limit = 0;
		int max = 0; //to store the highest number shown in file
		int currentNumber;
		s.nextLine();
		while (s.hasNextLine()) {
			limit++;
			buffer = s.nextLine();

			//list.add(buffer);
			tokens = buffer.split("\t");
			// System.out.println(">>> ["+tokens[0]+"]["+tokens[1]+"]");
			// System.out.println(buffer);
			currentNumber = Integer.parseInt(tokens[1]);
			// System.out.println(currentNumber);

			if (max < currentNumber) {
				max = currentNumber;
				name = tokens[0];
			}

		}

		System.out.println("There are "+limit+" lines");
		System.out.println("Name that has the highest number: "+name +" "+max);

		//for (String line : list)
			//System.out.println(line);
		
		int seed;
		System.out.print("Enter the seed : ");
		seed = (new Scanner(System.in)).nextInt();
		
		Random myRand = new Random(seed); //Seed is 0

		int randomLine = myRand.nextInt(limit) + 1;

		System.out.println("Ramdom number generated: "+randomLine);

		s.close();
		s = new Scanner(new File("data"));

		int counter = 0;
		s.nextLine();
		while (s.hasNextLine()) {
			buffer = s.nextLine();
			counter++;

			if (counter == randomLine) {
				System.out.println("The random line is ["+buffer+"]");
				break;

			}
		}

	}

}
