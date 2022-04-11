public class Day2 {
    public static void main(String[] args) 
    {
        // Linked List
        Node list = null;

        list = new Node();
        list.data = 7;
        list.next = null;

        list.next = new Node();
        list.next.data = 6;
        list.next.next = null;

        list = insertLL(list, 5);
        list = insertLL(list, 234);
        list = insertLL(list, 23);
        list = insertLL(list, 12);
        list = insertLL(list, 464);

        printLLIterative(list);
        printLLRecursive(list);
        printLLRecursiveReverse(list);

        System.out.println("\n" + sizeRecursive(list));

        list = delete(list, 5);
        printLLIterative(list);

        list = sort(list);
        printLLIterative(list);
    }

    public static Node sort(Node list)
    {
        Node temp = list;
        boolean goAgain = true;

        if (list == null || list.next == null)
            return list;
        
        while (goAgain == true)
        {
            temp = list;
            goAgain = false;
            while (temp.next.next != null)
            {
                if (temp.data > temp.next.data)
                {
                    int buffer;
                    buffer = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = buffer;
                    goAgain = true;
                }

                temp = temp.next;
            }
        }

        return list;
    }

    public static Node delete(Node list, int data)
    {
        Node currNode = list;
        Node prevNode;
        Node nextNode;

        if (list == null)
            return null;
        
        if (list.data == data)
        {
            list = list.next;
            return list;
        }

        prevNode = currNode;

        while (currNode != null)
        {
            if (currNode.data == data)
            {
                nextNode = currNode.next;
                currNode = prevNode;
                prevNode.next = nextNode;
            }

            prevNode = currNode;
            currNode = currNode.next;
        }

        return list;
    }

    public static void printLLRecursive(Node list)
    {
        if (list == null)
        {
            System.out.println("NULL");
            return;
        }
        
        System.out.print(list.data + "->");
        printLLRecursive(list.next);
    }

    public static int sizeRecursive(Node list)
    {
        if (list == null)
            return 0;
        
        return 1 + sizeRecursive(list.next);
    }

    public static void printLLRecursiveReverse(Node list)
    {
        printLLRecursiveReverseHelper(list);
        System.out.print("NULL");
    }

    public static void printLLRecursiveReverseHelper(Node list)
    {
        if (list == null)
        {
            return;
        }
        
        printLLRecursiveReverseHelper(list.next);
        System.out.print(list.data + "->");
    }

    public static void printLLIterative(Node list)
    {
        Node temp = list;

        while (temp != null)
        {
            System.out.print(temp.data + "->");        
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static Node insertLL(Node list, int data)
    {
        Node temp;

        if (list == null)
        {
            list = new Node();
            list.data = data;
            list.next = null;

            return list;
        }

        temp = list;

        while (temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = new Node();
        temp.next.data = data;
        temp.next.next = null;

        return list;
    }
}

class Node {
    public int data;
    Node next;
}