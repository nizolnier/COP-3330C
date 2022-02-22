/* 
Nicole Zolnier - COP 3330
Homework 3 - 02/22/2022

Dear T.A,
Sometimes, like 1 in 30 runs, there will be an error with the object generator, but I do not know what is causing it to happen. 
I am sorry. But I am proud of my code, hope you like it!
*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SentenceTester {
	public static void main(String[] args) throws FileNotFoundException {
		SentenceGenerator mySentence = new SentenceGenerator();
		SentenceGenerator.decomposeSentence(mySentence.getSentence());
		SentenceGenerator.decomposeSentence("Kiara and John will eat 2 suit."); // kiara, eat and 2 suit are not on the lists
		SentenceGenerator.decomposeSentence("Adam or John will beg 1 Cap.");

		String sentence = "Zane oR Riley deserved suit.";
		System.out.println(SentenceGenerator.check(sentence)); // this prints false
		sentence = "Zane   oR Riley    deserved 1	 suit.";
		System.out.println(SentenceGenerator.check(sentence)); // this prints true

		// adding a couple more test cases
		System.out.println(SentenceGenerator.check("Riley    and Jilali deserve 	rug.")); // false
		System.out.println(SentenceGenerator.check("Riley and Zane	 crash   Trumpet")); // false
		System.out.println(SentenceGenerator.check("Riley	and Zane crash   Trumpet.")); // true
		System.out.println(SentenceGenerator.check("zane     crashed Trumpet.")); // false
		System.out.println(SentenceGenerator.check("Max and	max afford iphone.")); // false

	}

}

// ___________________________________________________________
class SentenceGenerator {
	private String sentence;

	// getters and setters
	public String getSentence() {
		return this.sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	// this method calls other 4 methods and sets the sentence using 5 variables
	// each file + connector has it's own generator + get (which populates the
	// arraylist)
	public SentenceGenerator() throws FileNotFoundException {
		String name1 = this.generateName();
		String name2 = this.generateName();
		String verb = this.generateVerb();
		String object = this.generateObject();
		String connector = this.generateConnector();

		// if the names are the same, it will generate a new second name until they are
		// not the same anymore
		while (name1.toLowerCase() == name2.toLowerCase()) {
			name2 = this.generateName();
		}

		// nice little sentence with the . at the end :)
		this.sentence = name1 + " " + connector + " " + name2 + " " + verb + " " + object + ".";
	}

	public String generateName() throws FileNotFoundException {
		// here i get the names from the file and add them to an arraylist
		ArrayList<String> names = new ArrayList<String>();
		names = getNames();

		Random myRand = new Random();
		// generating the random number and the limit is the length of the arraylist+ 1
		// to equal the entire file
		int randomLine = myRand.nextInt(names.size() + 1);

		// get the name that matches the random number
		return names.get(randomLine);
	}

	public String generateObject() throws FileNotFoundException {
		// here i get the objects from the file and add them to an arraylist
		ArrayList<String> objects = new ArrayList<String>();
		objects = getObjects();

		Random myRand = new Random();
		// generating the random number and the limit is the length of the arraylist+ 1
		// to equal the entire file
		int randomLine = myRand.nextInt(objects.size() + 1);

		// get the object that matches the random number
		return objects.get(randomLine);
	}

	public String generateConnector() {
		// here i get the connectors and add them to an array
		// simple basic array since there's only two connectors
		String[] connectors = getConnectors();

		Random myRand = new Random();
		// generating the random number and the limit is the length of the array
		int randomLine = myRand.nextInt(2);

		// get the connector that matches the random number
		return connectors[randomLine];
	}

	public String generateVerb() throws FileNotFoundException {
		// here i get the verbss from the file and add them to an arraylist
		ArrayList<String> verbs = new ArrayList<String>();
		verbs = getVerbs();

		Random myRand = new Random();
		// generating the random number and the limit is the length of the arraylist+ 1
		// to equal the entire file
		int randomLine = myRand.nextInt(verbs.size() + 1);

		// get the verb that matches the random number
		return verbs.get(randomLine);
	}

	public static void decomposeSentence(String sentence) throws FileNotFoundException {
		// this method will print a sentence like [Riley][and][Zane][crashed][Trumpet],
		// separating the variables

		if (!check(sentence)) {
			System.out.println("Sorry, this sentence cannot be decomposed");
		} else {
			// printing the base sentence
			System.out.println(sentence);
			// now here we go to the fun part

			// first we trim the extra spaces with a regex to leave only 1 space between each word
			// then break the sentence by cutting the empty spaces
			String[] sentenceArray = sentence.replaceAll("\\s+", " ").split(" ");
			// declaring the variables that will hold the pieces + currentSentence that i'll
			// explain later
			String name1, name2, connector, verb, object, currentSentence;

			// the minimum for the sentence to be in the format 'name connector name verb object' is to have 5 elements
			// so if it doesn't it cannot be decomposed
			if(sentenceArray.length < 5) {
				System.out.println("Sorry, this sentence cannot be decomposed");
			}

			// so we know that the sentence will start with a name, followed by a connector
			// and another name
			// therefore, since the sentence is now an array:
			// element 0 is the first name
			name1 = sentenceArray[0];
			// element 1 is the connector
			connector = sentenceArray[1];
			// element 2 is the second name
			name2 = sentenceArray[2];

			// now the verb will either be only the 3rd element of the array or the 3rd and
			// 4th if it is the future tense
			// so i did a little ternary and compared using the equals function (doing it
			// with == was not working properly)
			verb = sentenceArray[3].equals("will") ? sentenceArray[3] + " " + sentenceArray[4] : sentenceArray[3];

			// now for the object, it will be the rest of the sentence
			// so we getter what was found so far
			currentSentence = name1 + " " + connector + " " + name2 + " " + verb + " ";

			// get the original sentence and cut with the current sentece, remove the . and
			// turn it into string again
			object = String.join("", sentence.replaceAll("\\s+", " ").split(currentSentence)).replace(".", "");

			// then i print everything :)
			System.out.println("[" + name1 + "]" + "[" + connector + "]" + "[" + name2 + "]" + "[" + verb + "]" + "["
					+ object + "]");
		}
	}

	public static boolean check(String sentence) throws FileNotFoundException {
		// this method checks if the sentence follows the pattern of 'name connector
		// name verb object.'
		// it combines the get's from the sentence generator and the logic from the
		// decompose so i will not repead myself

		// getting and setting the arrays
		ArrayList<String> names = new ArrayList<String>();
		names = getNames();
		ArrayList<String> objects = new ArrayList<String>();
		objects = getObjects();
		String[] connectors = getConnectors();
		ArrayList<String> verbs = new ArrayList<String>();
		verbs = getVerbs();

		// turning the sentence into an array and getting each piece
		String[] sentenceArray = sentence.replaceAll("\\s+", " ").split(" ");
		String name1, name2, connector, verb, object, currentSentence;

		// the minimum for the sentence to be in the format 'name connector name verb object' is to have 5 elements
		// so if it doesn't it cannot be decomposed
		if(sentenceArray.length < 5) {
			return false;
		}

		name1 = sentenceArray[0];
		connector = sentenceArray[1];
		name2 = sentenceArray[2];
		verb = sentenceArray[3].equals("will") ? sentenceArray[3] + " " + sentenceArray[4] : sentenceArray[3];
		currentSentence = name1 + " " + connector + " " + name2 + " " + verb + " ";
		object = String.join("", sentence.replaceAll("\\s+", " ").split(currentSentence)).replace(".", "");

		// declaring booleans for each variable + the dot boolean
		boolean n1B = false;
		boolean n2B = false;
		boolean cB = false;
		boolean vB = false;
		boolean oB = false;
		boolean dB = false;

		// then i do a loop, and if the connector from the sentence is equal to the
		// connector from the array, then the boolean it's true
		// same goes for names, verbs and objects
		for (String c : connectors) {
			if (c.toLowerCase().equals(connector.toLowerCase())) {
				cB = true;
			}
		}

		for (String n : names) {
			if (n.toLowerCase().equals(name1.toLowerCase())) {
				n1B = true;
			}
		}

		// here's an exception, if the connector is "or" then the second name doesn't have to be in the file so it is true anyways
		if (cB && connector.toLowerCase() == "or") {
			n2B = true;
		} else {
			// but if the connector isn't or... i do the loop
			for (String n : names) {
				if (n.toLowerCase().equals(name2.toLowerCase())) {
					n2B = true;
				}
			}
		}

		if(name1.toLowerCase().equals(name2.toLowerCase())) {
			n2B = false;
		}

		for (String v : verbs) {
			if (v.toLowerCase().equals(verb.toLowerCase())) {
				vB = true;
			}
		}

		for (String o : objects) {
			if (o.toLowerCase().equals(object.toLowerCase())) {
				oB = true;
			}
		}

		// to check for the dot, i take the original sentence and see if it contains the dot
		if (sentence.contains(".")) {
			dB = true;
		}

		// then i return the boolean by checking all the variable booleans
		return n1B && n2B && cB && vB && oB && dB;
	}

	// populate arrays
	public static ArrayList<String> getNames() throws FileNotFoundException {
		// declaring the buffer and the array list
		String buffer;
		ArrayList<String> names = new ArrayList<String>();

		// scanning the file
		Scanner s = new Scanner(new File("names.txt"));

		// while the file has a next line, i:
		while (s.hasNextLine()) {
			// set the buffer as the line
			buffer = s.nextLine();

			// then add the buffer to the arraylist
			names.add(buffer);
		}

		// then i return the array list
		return names;
	}

	public static ArrayList<String> getObjects() throws FileNotFoundException {
		// declaring the buffer. the num and the array list
		String buffer;
		int num;
		ArrayList<String> objects = new ArrayList<String>();

		// scanning the file
		Scanner s = new Scanner(new File("things.txt"));

		// while the file has a next line, i:
		while (s.hasNextLine()) {
			// some of the objects start with integers so to get those i use the hasNextInt() function
			// if it doesn't, i just set the num as zero
			num = s.hasNextInt() ? s.nextInt() : 0;

			// set the buffer as the line
			buffer = s.nextLine();

			// then add it to the arraylist, if the num is not zero then i adde the num+buffer
			objects.add(num != 0 ? num + buffer : buffer);
		}

		// then i return the array list
		return objects;
	}

	public static String[] getConnectors() {
		// so here i just created a basic array with 'and' and 'or', and then returned it
		String[] connectors = { "and", "or" };
		return connectors;
	}

	public static ArrayList<String> getVerbs() throws FileNotFoundException {
		// declaring the buffer, the tokens and the array list
		String buffer;
		String[] token;
		ArrayList<String> verbs = new ArrayList<String>();

		// scanning the file
		Scanner sc = new Scanner(new File("verbs.txt"));

		// while the file has a next line, i:
		while (sc.hasNextLine()) {
			// set the buffer as the line
			buffer = sc.nextLine();
			// then turn the buffer into an array by splitting the spaces
			token = buffer.split(" ");

			// add the first token (verb in present tense)
			verbs.add(token[0]);
			// add the second token (verb in past tense)
			verbs.add(token[1]);
			// add the third and forth token to create the future tense with will
			verbs.add(token[2] + " " + token[3]);

		}

		// then i return the array list
		return verbs;
	}
}
