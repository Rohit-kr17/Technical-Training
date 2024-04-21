class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class BCS6649_Exp_Four {
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        
        // If the list is empty, the new node becomes the head
        if (llist == null) {
            llist = newNode;
        } else {
            // If the list is not empty, insert the new node before the head
            newNode.next = llist;
            llist = newNode;
        }
        
        return llist;
    }
    
    // Sample input and function call
    public static void main(String[] args) {
        int n = 5;
        int[] elements = {383, 484, 392, 975, 321};
        
        SinglyLinkedListNode head = null;
        for (int i = 0; i < n; i++) {
            head = insertNodeAtHead(head, elements[i]);
        }
        
        // Print the updated linked list
        printLinkedList(head);
    }
    
    // Helper function to print the linked list
    static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
