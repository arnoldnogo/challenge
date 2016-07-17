# DeliveryChallenge

## Program Description
This is a java program that implements an algorithm problem to schedule delivery from specified pick-up locations and drop points. 
I have made the following assumption:

'''1. The weight between points have been provided i.e the time or distace between the nodes
'''2. The upper limit to be twice the weight AD

## Approach & Usage

In order to determine the magnitude of the detour, the program compares the value of the shortest path(weight) to twice the weight of AD,
which is twice the cost of making the first delivery. If an individual makes the second delivery, it means he/she will have to visit all the nodes.
I have used the Nearest Neighbour algorithm used in the Travelling salesman problem to get minimum permutation of all the nodes. 
I then compare that value to twice the distace of AD which I have assumed to be the upper limit; meaning the delivery can be made by one person if
the shortest path falls within the radius AD. If the shortest path falls outside this radius then the delivery is made by a different person.

Since we assume we have the values between the points for example:

'''AB-50 BD-20 DC-35 AC-15 BC-30 AD-17

We use these weight values to construct an adjacent matrix. Using the example above we construct the matrix below:

  A   B   C   D
A 00  50  15  17
B 50  00  30  20
C 15  30  00  35
D 17  20  35  00

The program will prompt you to input the number of nodes; in this instance 4.

The program will then prompt you to input the matrix as the one above

It will then get the path with minimum cost; path and total value. You'll then be prompted to input the enter the value AD (50 in this case) and
compare the value of the path of minimum cost to twice the value of AD. If the computed path is more than twice the value AD, then the two deliveries
are made by two different people.


 




## Installation

Run the program with an IDE that supports Java.
