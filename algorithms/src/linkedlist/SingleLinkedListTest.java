package linkedlist;

import org.junit.Test;

public class SingleLinkedListTest {

    @Test
    public void testSingleLinkedList() {
        SingleLinkedList list = new SingleLinkedList(); //[]
        list.insertToTail(2);
        list.insertToTail(3);
        list.insertToTail(4);  // [2,3,4]
        list.printAll();

        list.insertToHead(1);
        list.insertToHead(0); // [0,1，2,3,4]
        list.printAll();

        SingleLinkedList.Node node = list.findByIndex(2);
        list.insertBefore(node, 10);
        list.insertAfter(node, 10); // [0,1,10,2,10,3,4]
        list.printAll();

        list.deleteByValue(10);
        list.printAll(); // [0,1，2,3,4]

        SingleLinkedList.Node p = list.findByValue(2);
        System.out.println(node.getData() == p.getData()); // true
    }
}
