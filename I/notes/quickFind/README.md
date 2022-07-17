# Quick Find algorithm 
Implementation of the quick find algorithm in order to solve the dynamic connectivity problem.


## This algorithm enables to do the following commands: 


* union; command to create an union between two nodes. 
* find;  command to find if two nodes are in the same connected  component (if both share the same root node).




## Worst Case Time
MN

M Union-find operations on a set of N objects.


Performing M union-find operations takes M N time. If M is proportional to N, this results in ${N^2}$ time. 


### Space Complexity Analysis:
N

## References

https://www.cs.princeton.edu/courses/archive/spring19/cos226/lectures/study/15UnionFind.html