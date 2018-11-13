# Questions

## 1.泛型动态数组API：

   ```Java
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

## 4.单链表API:

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

   
