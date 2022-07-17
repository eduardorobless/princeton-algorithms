# Quick Union With Path Compression algorithm 
Implementation of the quick union with path compression algorithm in order to solve the dynamic connectivity problem.
Using path compression we can get flatter trees and improve the performance considerably.

## This algorithm enables to do the following commands: 


* union; command to create an union between two nodes. 
* find;  command to find if two nodes are in the same connected  component (if both share the same root node).


## Worst Case Time
N + M log N 

M Union-find operations on a set of N objects.


### Space Complexity Analysis:
N

## References

https://www.cs.princeton.edu/courses/archive/spring19/cos226/lectures/study/15UnionFind.html