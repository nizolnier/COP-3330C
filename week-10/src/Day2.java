import java.util.HashMap;

public class Day2 {
    public static void main(String[] args) {
        HashMap <Integer, String> map = new HashMap<>();

        map.put(111, "John Smith");
        map.put(555, "Johnny Dean");
        map.put(222, "Emma Jones");

        for(Integer c: map.keySet()) {
            // display only the ints
            System.out.print(c + " ");
        }

        System.out.println("");
        for(String c: map.values()) {
            // display the names
            System.out.print(c + " ");
        }

        System.out.println("");
        for(Integer c: map.keySet()) {
            if(c > 200)
                System.out.print(map.get(c) + " ");
        }

        // System.out.println(map);
    }
}

