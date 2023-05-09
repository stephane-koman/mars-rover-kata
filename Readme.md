Mars Rover Kata with TDD
===============

Description
-----------

Develop an api that moves a rover around on a grid.

* You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
* The rover receives a character array of commands.
* Implement commands that move the rover forward/backward (f,b).
* Implement commands that turn the rover left/right (l,r).
* Implement wrapping at edges. But be careful, planets are spheres.
* Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point, aborts the sequence and reports the obstacle.

Source: [kata-log.rocks](https://kata-log.rocks/mars-rover-kata).

Implementation - Rules
--------------

* Hardcore TDD. No Excuses!
* No red phases while refactoring.
* Be careful about edge cases and exceptions. We can not afford to lose a mars rover, just because the developers overlooked a null pointer.

JAVA Version
-------
* Minimum Java version : **Java 14** [ Because we are using **Record class** ]
* Java version use to develop this app: **Java 17**

Running
-------

To run all tests:

```bash
gradle test
```