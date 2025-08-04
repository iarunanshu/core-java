package com.arunanshu.acessmodifier.collectionframework;

public class JavaCollection {
    /*
    What is the Java Collections Framework?
The Java Collections Framework (JCF) is a unified architecture for representing and manipulating groups of objects, also known as collections. Introduced in Java 1.2, it provides a set of standard interfaces (like List, Set, Queue) and concrete implementations (like ArrayList, HashSet) to make working with groups of data easier and more consistent.

## Why Do We Need the Java Collections Framework?
Before the JCF, Java had data structures like Array, Vector, and Hashtable. The problem was that they all had different and inconsistent APIs.

To add an element to a Vector, you might use .add().

To read an element from an Array, you'd use array[index].

A Hashtable would have its own set of methods.

This lack of a common interface made it difficult for developers to learn and switch between different data structures. The JCF solved this by providing a standard set of interfaces and methods, so if you learn how to use add(), remove(), and size() for an ArrayList, you already know how to use them for a HashSet or a PriorityQueue.

## The Core Interfaces
Iterable
This is the root interface for the entire framework. Its single purpose is to provide a standard way to traverse the elements in a collection. Any class that implements Iterable can be used in an enhanced for-each loop.

There are three primary ways to iterate over a collection:

Using an Iterator: Call collection.iterator() to get an Iterator object, then use its hasNext() and next() methods inside a while loop. This is the only method that safely allows for removing elements during iteration using iterator.remove().

Using the Enhanced for-each Loop: The simplest and most common way: for (String item : myList) { ... }.

Using the forEach() method (Java 8+): A modern approach using a lambda expression: myList.forEach(item -> System.out.println(item));.

Collection
This interface is the foundation for most data structures like lists, sets, and queues. It defines a core set of methods for working with groups of objects:

size(): Returns the number of elements.

isEmpty(): Checks if the collection has no elements.

add(element): Adds an element to the collection.

remove(element): Removes a specific element.

contains(element): Checks if an element exists in the collection.

clear(): Removes all elements from the collection.

addAll(otherCollection): Adds all elements from another collection into the current one.

## Collection vs. Collections
This is a common point of confusion for new developers.

Collection (no 's'): This is an interface. It's the root of the collection hierarchy (List, Set, and Queue are its sub-interfaces).

Collections (with an 's'): This is a utility class. It contains exclusively static helper methods that operate on or return collections, such as Collections.sort(), Collections.reverse(), and Collections.max().
     */
}
