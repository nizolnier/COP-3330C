import java.util.Random;

public class GenerateRandom {
    public static void main(String[] args) {
        int limit = 100;
        Random myRand = new Random();
        int randomLine = myRand.nextInt(limit)+1;

        System.out.println(randomLine);
    }
}

