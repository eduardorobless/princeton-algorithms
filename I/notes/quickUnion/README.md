# Quick Union algorithm 
Implementation of the quick union algorithm in order to solve the dynamic connectivity problem.
It seem to improve the time that we can accomplish using quick find but we can get big non-flat trees which impacts in the overall performance of the algorithm.


## This algorithm enables to do the following commands: 


* union; command to create an union between two nodes. 
* find;  command to find if two nodes are in the same connected  component (if both share the same root node).



## Worst Case Time
MN

M Union-find operations on a set of N objects.


Performing M union-find operations can takes M N time if we have a non-flat tree. If M is proportional to N, this results in ${N^2}$ time. 




### Space Complexity Analysis:
N