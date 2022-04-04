public class App {
    public static void main(String[] args) throws Exception {
        MyString name = new MyString();
        name.string = "kyle";
        change(name);

        System.out.println(name);
    }

    public static void change(MyString name) {
        name.string = "john";
    }
}

class MyString {
    public String string;

    public String toString() {
        return string;
    }
}