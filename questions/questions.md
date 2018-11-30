# Questions

## 数组

### 1. 数组与泛型动态数组
[[Solution1](https://github.com/guokaide/algorithm/blob/master/summary/algorithm.md)][[Solution2](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/GenericArray.java)]请谈谈数组的特点，并且实现泛型动态数组（即Vector in C++ or ArrayList in Java）的插入、删除以及查找操作，比较原生数组与泛型动态数组的区别。查看泛型动态数组API:

```java
package array;
   
   /**
    * 泛型动态数组
    *
    * @param <T>
    */
   
   public class GenericArray<T> {
       private T[] data;
       private int size;
   
       // 根据传入容量，构造Array
       public GenericArray(int capacity) {
           data = (T[]) new Object[capacity];
           size = 0;
       }
   
       // 无参构造方法，默认数组容量为10
       public GenericArray() {
           this(10);
       }
   
       // 获取数组容量
       public int getCapacity() {
   
       }
   
       // 获取当前元素个数
       public int count() {
   
       }
   
       // 判断数组是否为空
       public boolean isEmpty() {
   
       }
   
       // 修改 index 位置的元素
       public void set(int index, T e) {
   
       }
   
       // 获取对应 index 位置的元素
       public T get(int index) {
   
       }
   
       // 查看数组是否包含元素e
       public boolean contains(T e) {
   
       }
   
       // 获取对应元素的下标, 未找到，返回 -1
       public int find(T e) {
   
       }
   
   
       // 在 index 位置，插入元素e, 时间复杂度 O(m+n)
       public void add(int index, T e) {
   
       }
   
       // 向数组头插入元素
       public void addFirst(T e) {
   
       }
   
       // 向数组尾插入元素
       public void addLast(T e) {
   
       }
   
       // 删除 index 位置的元素，并返回
       public T remove(int index) {
   
       }
   
       // 删除第一个元素
       public T removeFirst() {
   
       }
   
       // 删除末尾元素
       public T removeLast() {
   
       }
   
       // 从数组中删除指定元素
       public void removeElement(T e) {
   
       }
   
       @Override
       public String toString() {
           StringBuilder builder = new StringBuilder();
           builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
           builder.append('[');
           for (int i = 0; i < size; i++) {
               builder.append(data[i]);
               if (i != size - 1) {
                   builder.append(", ");
               }
           }
           builder.append(']');
           return builder.toString();
       }
   
   
       // 扩容方法，时间复杂度 O(n)
       private void resize(int capacity) {
   
       }
   
       private void checkIndex(int index) {
           if (index < 0 || index > size) {
               throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
           }
       }
       
       private void checkIndexForRemove(int index) {
           if (index < 0 || index >= size) {
               throw new IllegalArgumentException("Remove failed! Require index >= 0 and index < size.");
           }
       }
   }
   
```

### 2. 1000万整数中查找某个数
[[Solution](https://github.com/guokaide/algorithm/blob/master/summary/algorithm.md#%E9%97%AE%E9%A2%98)]假设我们有 1000 万个整数数据，每个数据占 8 个字节，如何设计数据结构和算法，快速判断某个整数是否出现在这 1000 万数据中？ 我们希望这个功能不要占用太多的内存空间，最多不要超过 100MB，你会怎么做呢？

### 3. 约瑟夫问题
 [[Solution](https://github.com/guokaide/algorithm/blob/master/algorithms/src/joseph/Joseph.java)]0,1,...,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求这个圆圈里剩下的最后一个数字。




## 链表

### 1. 链表与数组
[[Solution1](https://github.com/guokaide/algorithm/blob/master/summary/algorithm.md)][[Solution2](https://github.com/guokaide/algorithm/blob/master/algorithms/src/linkedlist/SingleLinkedList.java)]请谈谈链表的特点，比较数组与链表的不同，并实现单链表的基本操作：插入、删除以及查找操作。查看单链表API：

   ```java
   package linkedlist;
   
   /**
    * 1）单链表的插入、删除、查找操作；
    * 2）链表中存储的是int类型的数据；
    *
    */
   public class SingleLinkedList {
   
     private Node head = null;
   
     public Node findByValue(int value) {
   
     }
   
     public Node findByIndex(int index) {
   
     }
   
     public void insertToHead(int value) {
   
     }
   
     public void insertToHead(Node newNode) {
   
     }
       
     public void insertToTail(int value) {
           
     }
       
     public void insertToTail(Node newNode) {
           
     }
   
     public void insertAfter(Node p, int value) {
   
     }
   
     public void insertAfter(Node p, Node newNode) {
   
     }
   
     public void insertBefore(Node p, int value) {
   
     }
   
     public void insertBefore(Node p, Node newNode) {
       
     }
   
     public void deleteByNode(Node p) {
       
     }
   
     public void deleteByValue(int value) {
       
     }
   
     public void printAll() {
       
     }
   
     public static Node createNode(int value) {
       return new Node(value, null);
     }
   
     public static class Node {
       private int data;
       private Node next;
   
       public Node(int data, Node next) {
         this.data = data;
         this.next = next;
       }
   
       public int getData() {
         return data;
       }
     }
   
   }
   ```

### 2. Reverse Linked List

[[Solution](https://github.com/guokaide/leetcode/tree/master/algorithms/src/reverselinkedlist_206)][206.Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/description/)



### 3. Middle of the Linked List

[[Solution](https://github.com/guokaide/algorithm/blob/master/algorithms/src/linkedlist/FindMidNode.java)]给定一个单链表，请找到其中间节点。例如：1->2->3, 中间节点为2; 1->2->3->4, 中间节点为3。

或者 leetcode版本：[876.Middle of the Linked List ](https://leetcode.com/problems/middle-of-the-linked-list/ )


### 4. LRU Cache

[[Solution](https://github.com/guokaide/algorithm/blob/master/algorithms/src/lru/LRU.java)][146.LRU Cache](https://leetcode.com/problems/lru-cache/description/)


### 5. Palindrome Linked List

[[Solution](https://github.com/guokaide/algorithm/blob/master/leetcode/src/palindromelinkedlist_234/PalindromeLinkedList.java)]如果一个字符串是通过单链表来存储的，该如何来判断是一个回文串呢？其时间复杂度和空间复杂度是多少？或者leetcode版本：[234.Palindrome Linked List ](https://leetcode.com/problems/palindrome-linked-list/ )

### 6. Linked List Cycle

[[Solution](https://github.com/guokaide/algorithm/blob/master/leetcode/src/linkedlistcycle_141/LinkedListCycle.java)][141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/ )



### 7. Merge Two Sorted Lists

[[Solution](https://github.com/guokaide/algorithm/blob/master/leetcode/src/mergetwosortedlist_21/Merge2SortedLists.java)][21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/ )



### 8. Remove Nth Node From End of List

[[Solution](https://github.com/guokaide/algorithm/blob/master/leetcode/src/removenthnodefromendoflist_19/RemoveNthNodeFromEndOfList.java)][19. Remove Nth Node From End of List ](https://leetcode.com/problems/remove-nth-node-from-end-of-list/ )



## 栈

### 1. Implement Stack using Array

[Solution] 实现顺序栈。**顺序栈**：用数组实现的栈。栈的API如下：

```java
public class ArrayStack {
    public boolean push(int item) {
        
    }
    
    public int pop() {
        
    }
}
```



### 2. Implement Stack using Linked List

[Solution] 实现链式栈。**链式栈**：用链表实现的栈。栈的API如下：

```java
public class ListStack {
    public boolean push(int item) {
        
    }
    
    public int pop() {
        
    }
}
```



### 3. Implement Stack using Queues

[Solution][225. Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)



### 4. Implement Queue using Stacks

[Solution][232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)



### 5. Valid Parentheses

[Solution][20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)



### 6. Min Stack

[Solution][155. Min Stack](https://leetcode.com/problems/min-stack/)

 

### 7. Implement the Forward and Backward Functions of the Browser

[Solution] 浏览器的前进和后退功能：当你依次访问完一串页面 a-b-c 之后，点击浏览器的后退按钮，就可以查看之前浏览过的页面 b 和 a。当你后退到页面a，点击前进按钮，就可以重新查看页面 b 和 c。但是，如果你后退到页面 b 后，点击了新的页面 d，那就无法再通过前进、后退功能查看页面 c 了。请实现这个功能。



## 队列

### 1. Implement Queue using Array

[Solution] 实现顺序队列。**顺序队列**：用数组实现的队列。API如下：

```java
public class ArrayQueue {
    public boolean enqueue(int Item) {
        
    }
    
    public int dequeue() {
        
    }
}
```



### 2. Implement Queue using Linked List

[Solution] 实现链式队列。**链式队列**：用链表实现的队列。API如下：

```java
public class ListQueue {
    public boolean enqueue(int Item) {
        
    }
    
    public int dequeue() {
        
    }
}
```



### 3. Design Circular Queue

[Solution][622. Design Circular Queue](https://leetcode.com/problems/design-circular-queue/)



### 4. Design Circular Deque

[Solution][641. Design Circular Deque](https://leetcode.com/problems/design-circular-deque/)



## 二分查找算法

### 1. 二分查找算法

[[Solution](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/BinarySearch.java)]请实现正确的二分查找算法（递归与非递归），并分析其时间复杂度（O(nlogn)）。

### 2. 二分查找算法变形问题

[[Solution](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/BinarySearch.java)]给定一个有序数组，

- 查找第一个值等于给定值的元素
- 查找最后一个值等于给定值的元素
- 查找第一个大于等于给定值的元素
- 查找最后一个小于等于给定值的元素

### 3. 旋转数组中的最小值

[[Solution](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/MinNumberInRotatedArray.java)]数组的旋转：将一个数组最开始的若干个元素搬到数组的末尾，即为数组的旋转。输入一个递增排序的数组的一个旋转，数组旋转数组的最小值。例如，数组{3,4,5,1,2}是数组{1,2,3,4,5}的一个旋转，该数组的最小值为1。要求时间复杂度为O(logn)。