package linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class FindMidNodeTest {

    @Test
    public void testFindMidNode() {
        FindMidNode.Node head = FindMidNode.createNode(0);
        head.next = FindMidNode.createNode(1);
        head.next.next = FindMidNode.createNode(2);
        head.next.next.next = FindMidNode.createNode(3);
        head.next.next.next.next = FindMidNode.createNode(4); //[0,1,2,3,4]
        FindMidNode.Node node1 = FindMidNode.findMidNode(head);
        head.next.next.next.next.next = FindMidNode.createNode(5); //[0,1,2,3,4,5]
        FindMidNode.Node node2 = FindMidNode.findMidNode(head);

        int expected1 = 2;
        int expected2 = 3;
        Assert.assertEquals(expected1, node1.data);
        Assert.assertEquals(expected2, node2.data);
    }

    @Test
    public void testFindMidNodeFast() {
        FindMidNode.Node head = FindMidNode.createNode(0);
        head.next = FindMidNode.createNode(1);
        head.next.next = FindMidNode.createNode(2);
        head.next.next.next = FindMidNode.createNode(3);
        head.next.next.next.next = FindMidNode.createNode(4); //[0,1,2,3,4]
        FindMidNode.Node node1 = FindMidNode.findMidNodeFast(head);
        head.next.next.next.next.next = FindMidNode.createNode(5); //[0,1,2,3,4,5]
        FindMidNode.Node node2 = FindMidNode.findMidNodeFast(head);

        int expected1 = 2;
        int expected2 = 3;
        Assert.assertEquals(expected1, node1.data);
        Assert.assertEquals(expected2, node2.data);
    }
}
