# [算法练级计划](https://mp.weixin.qq.com/s/6vuaECCmrxrchr5Hc11S5w)

> **既然终要承受痛苦，那么尝试思考的痛总归比承受学习的苦更有意义。**

## Questions

#### 1. [[Solution1](https://github.com/guokaide/algorithm/blob/master/summary/summary.md#%E6%95%B0%E7%BB%84)][[Souluiton2](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/GenericArray.java)][数组]
请谈谈数组的特点，并且实现泛型动态数组（即Vector in C++ or ArrayList in Java）的插入、删除以及查找操作，比较原生数组与泛型动态数组的区别。查看[泛型动态数组API](https://github.com/guokaide/algorithm/blob/master/questions/questions.md#1%E6%B3%9B%E5%9E%8B%E5%8A%A8%E6%80%81%E6%95%B0%E7%BB%84api)。

#### 2. [[Solution](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/BinarySearch.java)][二分查找]
请实现正确的二分查找算法（递归与非递归），并分析其时间复杂度(<a href="http://www.codecogs.com/eqnedit.php?latex=O(nlogn)" target="_blank"><img src="http://latex.codecogs.com/gif.latex?O(nlogn)" title="O(nlogn)" /></a>)。

#### 3. [[Solution](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/BinarySearch.java)][二分查找变形问题]
给定一个有序数组，
* （1）查找第一个值等于给定值的元素
* （2）查找最后一个值等于给定值的元素
* （3）查找第一个大于等于给定值的元素
* （4）查找最后一个小于等于给定值的元素

#### 4. [[Solution1](https://github.com/guokaide/algorithm/blob/master/summary/summary.md#%E9%93%BE%E8%A1%A8)][[Solution2](https://github.com/guokaide/algorithm/blob/master/algorithms/src/linkedlist/SingleLinkedList.java)][链表]
请谈谈链表的特点，比较数组与链表的不同，并实现单链表的基本操作：插入、删除以及查找操作。查看[单链表API](https://github.com/guokaide/algorithm/blob/master/questions/questions.md#4%E5%8D%95%E9%93%BE%E8%A1%A8api)。

#### 5. [[Solution1](https://github.com/guokaide/leetcode/tree/master/algorithms/src/reverselinkedlist_206)][[Solution2](https://github.com/guokaide/algorithm/blob/master/algorithms/src/linkedlist/FindMidNode.java)][链表]
* (1) [206.Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/description/)
* (2) 单链表中间节点问题：给定一个单链表，请找到其中间节点。例如：1->2->3, 中间节点为2; 1->2->3->4, 中间节点为2。

#### 6. [Solution][链表]
[146.LRU Cache](https://leetcode.com/problems/lru-cache/description/)

#### 7. [[Solution](https://github.com/guokaide/algorithm/blob/master/summary/summary.md#%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE)][数据结构设计与算法]
假设我们有 1000 万个整数数据，每个数据占 8 个字节，如何设计数据结构和算法，快速判断某个整数是否出现在这 1000 万数据中？ 我们希望这个功能不要占用太多的内存空间，最多不要超过 100MB，你会怎么做呢？

#### 8. [[Solution](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/MinNumberInRotatedArray.java)][数组]
数组的旋转：将一个数组最开始的若干个元素搬到数组的末尾，即为数组的旋转。输入一个递增排序的数组的一个旋转，数组旋转数组的最小值。例如，数组{3,4,5,1,2}是数组{1,2,3,4,5}的一个旋转，该数组的最小值为1。要求时间复杂度为O(logn)。

#### 9. [Solution1][Solution2][链表]
* (1) [约瑟夫问题](https://zh.wikipedia.org/wiki/%E7%BA%A6%E7%91%9F%E5%A4%AB%E6%96%AF%E9%97%AE%E9%A2%98)
* (2) 如果一个字符串是通过单链表来存储的，该如何来判断是一个回文串呢？其时间复杂度和空间复杂度是多少？




## Algorithms

|#|Tag|Title|Solution|
|:---:|:---:|:---|:---|
|001|Array|[泛型动态数组](https://github.com/guokaide/algorithm/blob/master/questions/questions.md)|[Java](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/GenericArray.java)|
|002|Array|[二分查找](https://github.com/guokaide/algorithm/blob/master/README.md#2-solution%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE)|[Java](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/BinarySearch.java)|
|003|Array|[二分查找变形问题](https://github.com/guokaide/algorithm/blob/master/README.md#3-solution%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE%E5%8F%98%E5%BD%A2%E9%97%AE%E9%A2%98)|[Java](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/BinarySearch.java)|
|004|Array|二分查找相关问题测试|[Java](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/BinarySearchTest.java)|
|005|Linked List|[单链表的基本操作](https://github.com/guokaide/algorithm#4-solution1solution2%E9%93%BE%E8%A1%A8)|[Java](https://github.com/guokaide/algorithm/blob/master/algorithms/src/linkedlist/SingleLinkedList.java)|
|006|Linked List|[Reversed Linked List](https://leetcode.com/problems/reverse-linked-list/description/)|[Java](https://leetcode.com/problems/reverse-linked-list/description/)|
|007|Linked List|[单链表中间节点问题](https://github.com/guokaide/algorithm#5-solution1solution2%E9%93%BE%E8%A1%A8)|[Java](https://github.com/guokaide/algorithm/blob/master/algorithms/src/linkedlist/FindMidNode.java)|


## Appendix
#### 1. 如何进行代码测试？[示例](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/BinarySearchTest.java)

## 欢迎大家关注我的公众号： 【算法修炼笔记】

主要分享校招笔试面试经验、数据结构与算法、计算机网络、操作系统、数据库以及法律知识等，完成从码农到工程师的进阶之路~

![algo](https://github.com/guokaide/algorithm/blob/master/summary/algo.jpg)

