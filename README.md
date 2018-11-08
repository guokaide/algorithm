# Algorithm

> **既然终要承受痛苦，那么尝试思考的痛总归比承受学习的苦更有意义。**

## Questions

#### 1. [[Solution](https://github.com/guokaide/algorithm/blob/master/summary/summary.md#%E6%95%B0%E7%BB%84)][数组]
请谈谈数组的特点，并且实现泛型动态数组（即Vector in C++ or ArrayList in Java）的插入、删除以及查找操作，比较原生数组与泛型动态数组的区别。查看[泛型动态数组API](https://github.com/guokaide/algorithm/blob/master/questions/questions.md#1%E6%B3%9B%E5%9E%8B%E5%8A%A8%E6%80%81%E6%95%B0%E7%BB%84api)。

#### 2. [[Solution](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/BinarySearch.java)][二分查找]
请实现正确的二分查找算法（递归与非递归），并分析其时间复杂度(<a href="http://www.codecogs.com/eqnedit.php?latex=O(nlogn)" target="_blank"><img src="http://latex.codecogs.com/gif.latex?O(nlogn)" title="O(nlogn)" /></a>)。

#### 3. [[Solution](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/BinarySearch.java)][二分查找变形问题]
给定一个有序数组，
* （1）查找第一个值等于给定值的元素
* （2）查找最后一个值等于给定值的元素
* （3）查找第一个大于等于给定值的元素
* （4）查找最后一个小于等于给定值的元素

#### 4. [Solution][链表]
请谈谈链表的特点，并实现单链表的插入、删除以及查找操作。查看[单链表API](https://github.com/guokaide/algorithm/blob/master/questions/questions.md#4%E5%8D%95%E9%93%BE%E8%A1%A8api)。

#### 5. [[Solution](https://github.com/guokaide/leetcode/tree/master/algorithms/src/reverselinkedlist_206)][链表]
[206.Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/description/)

#### 6. [Solution][链表]
[146.LRU Cache](https://leetcode.com/problems/lru-cache/description/)

#### 7. [[Solution](https://github.com/guokaide/algorithm/blob/master/summary/summary.md#%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE)][数据结构设计与算法]
假设我们有 1000 万个整数数据，每个数据占 8 个字节，如何设计数据结构和算法，快速判断某个整数是否出现在这 1000 万数据中？ 我们希望这个功能不要占用太多的内存空间，最多不要超过 100MB，你会怎么做呢？


## Algorithms

|#|Tag|Title|Solution|
|:---:|:---:|:---|:---|
|001|Array|[泛型动态数组](https://github.com/guokaide/algorithm/blob/master/questions/questions.md)|[Java](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/GenericArray.java)|
|002|Array|[二分查找](https://github.com/guokaide/algorithm/blob/master/README.md#2-solution%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE)|[Java](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/BinarySearch.java)|
|003|Array|[二分查找变形问题](https://github.com/guokaide/algorithm/blob/master/README.md#3-solution%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE%E5%8F%98%E5%BD%A2%E9%97%AE%E9%A2%98)|[Java](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/BinarySearch.java)|
|004|Array|二分查找相关问题测试|[Java](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/BinarySearchTest.java)|

## Appendix
#### 1. [代码测试示例](https://github.com/guokaide/algorithm/blob/master/algorithms/src/array/BinarySearchTest.java)
