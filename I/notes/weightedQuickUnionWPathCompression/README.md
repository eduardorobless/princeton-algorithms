# Weighted Quick Union With Path Compression
Implementation of the weighted quick union with path compression algorithm in order to solve the dynamic connectivity problem.
Using weighted trees allow us to flat even more our trees wich is something we seek in order to increase the time performance of our algorithm. And even more using path compression we 
can achieve impresionant performance times; our favourite log* function.

## This algorithm enables to do the following commands: 


* union; command to create an union between two nodes. 
* find;  command to find if two nodes are in the same connected  component (if both share the same root node).



## Worst Case Time
N + M log* N

M Union-find operations on a set of N objects.


## Space Complexity Analysis:
N


## Extras: python3 siteGenerator.py node_number connection_number

Something that was added to the algorithm is an extra helper; a python script generator of a node file containing the following structure:

* 1st line : Number of nodes passed as parameter; from 0 upto N-1 (first positional argument)
* Subsequent lines : The connections depending on the number of connections passed as parameter (second positional argument).