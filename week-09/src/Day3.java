public class Day3 {
    public static void main(String[] args) {
        int id = 125;

        try {            
            if (id > 100) throw new MyException(id);
        } catch(MyException e) {
            System.out.println(e);
        }

        System.out.println("done");
    }

}

class MyException extends Exception {
    int id;
    public MyException (int id) {
        this.id = id;
    }

    public String toString() {
        return "Invalid id: " + id;
    }
}