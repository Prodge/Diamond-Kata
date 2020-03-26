## Clojure Diamond Kata

An implementation of the Diamond Kata in Clojure.

This was my third attempt at the kata in Clojure.

The implementation builds each row of characters in the first quadrant of the diamond, then reflects it to build complete lines (forming the top traingle), then reflects it to form the complete diamond.

Reflections are simple, so the problem is reduced to creating the first quadrant.

```
First Quadrant
____________a|____________
___________b_|b___________
__________c__|_c__________
_________d___|__d_________
________e____|___e________
_______f_____|____f_______
______g______|_____g______  < First quadrant is reflected to create the top
_____h_______|______h_____
____i________|_______i____
___j_________|________j___
__k__________|_________k__
_l___________|__________l_
m____________|___________m
-  -  -  -  -  -  -  -  -
_l_____________________l_
__k___________________k__
___j_________________j___
____i_______________i____
_____h_____________h_____  < Top is reflected to cerate the bottom
______g___________g______
_______f_________f_______
________e_______e________
_________d_____d_________
__________c___c__________
___________b_b___________
____________a____________
```

### Usage

```
lein run b
```
Where b is the deepest letter the diamond should react

### Run Tests

```
lien test
```

