JArrays
==============

Java array utilities! Most functions include offset and length arguments to apply the operation to a sub-array:
* Equality: equals(), indexOf(), lastIndexOf(), contains()
* Add & Remove: add(), addRange(), remove(), concat()
* Conversion: asArray(...), reverse(), expandArray(), toString()
* Stats: avg(), max(), min(), sum()
* Primitive-wrapper arrays to primitive arrays and vice-versa, (i.e. Integer[] -> int[]).
* Also `ArrayManager` static class provides methods for using arrays like lists: `add()`, `addAll()`, `clearAndAddAll()`, `expand()`, `removeIndex()`, `removeRange()`, `removeUnordered()`, and `removeValue()`

Take a look at the twg2.arrays.test package for examples of how the APIs can be used.
