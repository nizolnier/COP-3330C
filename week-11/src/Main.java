public class Main {
    public static void main(String[] args) throws Exception {
        Node list = null;
        /*
        list.data = 7;
        list.next = new Node();
        list.next.data = 3;
        list.next.next = null;
        */
        list = add(list, 56);

        print(list);
        printR(list);
    }

    public static Node add(Node list, int data) {
        if(list == null) {
            list = new Node();
            list.data = data;
            list.next = null;
        }

        return list;
    }

    public static void print (Node list) {
        Node temp = list;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void printR (Node list) {
        if(list != null) {
            printR(list.next);
            System.out.print(list.data + "->");   
        }
    }
}

class Node {
    public int data;
    Node next;
}