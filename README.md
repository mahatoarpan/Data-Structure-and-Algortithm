# Data Structures and Algorithms

## Techniques
1. Array
   * Sliding Window: In a sliding window, the two pointers usually move in the same direction will never overtake each other. This ensures that each value is only visited at most twice and the time complexity is still O(n).
   * Two Pointer: Two pointers is a more general version of sliding window where the pointers can cross each other and can be on different arrays.
   * Traversing from the right: Sometimes you can traverse the array starting from the right instead of the conventional approach of from the left.
   * Sorting the array: Is the array sorted or partially sorted? If it is, some form of binary search should be possible. This also usually means that the interviewer is looking for a solution that is faster than O(n). Can you sort the array? Sometimes sorting the array first may significantly simplify the problem. Obviously this would not work if the order of array elements need to be preserved.
   * Precomputation: For questions where summation or multiplication of a subarray is involved, pre-computation using hashing or a prefix/suffix sum/product might be useful.
   * Index as hashing: If you are given a sequence and the interviewer asks for O(1) space, it might be possible to use the array itself as a hash table. For example, if the array only has values from 1 to N, where N is the length of the array, negate the value at that index (minus one) to indicate presence of that number.

2. Strings
   * Counting Characters: Often you will need to count the frequency of characters in a string. The most common way of doing that is by using a hash table/map in your language of choice. If you need to keep a counter of characters, a common mistake is to say that the space complexity required for the counter is O(n). The space required for a counter of a string of latin characters is O(1) not O(n). This is because the upper bound is the range of characters, which is usually a fixed constant of 26.
   * 


## Questions

* [Array](./questions/array.md)
* [Binary Search](./questions/binary_search.md)
* [Dynamic Programming](./questions/dynamic_programming.md)
* [Linked List](./questions/linked_list.md)
* [Queue](./questions/queue.md)
* [Stack](./questions/stack.md)
* [String](./questions/string.md)
* [Two Pointer](./questions/two_pointer.md)
