import java.util.Arrays;

public class Main {
    static class Node {
        Node next;
        Node(Node next) {
            this.next = next;
        }
        Node(){}
    }
    public static void main(String[] args) {
        Node node = new Node();
        Node second = new Node();

        node.next = second;
        Node temp = node.next;
        node.next = null;
        Node tempNode = node;
        node = second;
        System.out.println("temp = " + temp);
        System.out.println("first = " + node);
        System.out.println("temp2 = " + tempNode);
        System.out.println("second = " + second);
    }
}
