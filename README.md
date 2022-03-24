
## Arrays - The basic collections

Pre-collections in java 
- Arrays
- Vector
- Hashtable

They did the job for concurrency in mind. But the extra cost 
was the performance.

## The Java Array 

int[] numbers;
numbers = new int[];

Arrays work for both primitves and object references
You can put object reference to an Array

Date[] dates = new Date[20];

Java creates an reference Array. The Date object stays in heap,
and the array contains contigous locations which are references.
The point to each location in the heap.

## Problems with Arrays:
- Limited data structure
- Doesn't have methods on it.(We have extra class Arrays)
  sorting, searching, toList, binarySearch overloaded method which
  takes byte array, char array, float array.....so on. These are the methods
  on different class, and they are all static methods.

## What we need collections to do 
- Position based access.
- Needs for sorting methods.
- Ordered vs Unordered.
- Uniqueness : are duplicates allowed, affects adding behavior(accept if not there and returns false and collecion is same if present)
- No need for position based access.
- Index based retreivals.
- Key based retreivals.
- Presence only retreivals.
- Mutability : no modifiable
- Concurrency requirements.

## Collection Types 
 - List 
 - Set 
 - Map 
 - Queue 
 They define the contract of the collection but they are not responsibe for doing the work (sorting, accessing).
 Implementations does the work behind the scenes.

 List - defines th contract/behavior
 ArrayList - An implementation of the List contract
 LinkedList - Another implementation of the List contract

Tradeoffs - They all have their own + and - , so we use different types.

## ArrayList - Replacement of Arrays

Collections(I) ---> List(I) ----> ArrayList(Impl)

ArrayList<String> arrayList = new ArrayList<>();

ArrayList will manage the size of its own.
It's a pure Object oriented programming in arrayList, as anything you do is the thing that you do on that
particular object instance unlike static methods in Arrays.

Methods:
- add()
- get()
- indexOf()
- lastIndexOf()
- contains()
- addAll()

Tradeoffs
- Feature requirements
- Efficiency - Time and space.
Space efficiency is uually propotional to your size.(so no concern)
Time efficiency is how much time does it take for an operation to complete.
Retreive, Sort...so on.

Retreive.(single item and search) 
Storage.

Bigger collections more is the time.

The way you measure time efficiency is by a factor of 'N'
O(N)

How good/bad is dependence on N?

Big O Notation:
- Rough imprecise measurement / classification
- How much time depends on collection size.
- Broad buckets. (Algorithms used)
------
- Linear Time
- Constant Time
- Lograthmic Time binarySearch(middle then middle)
- Quadratic Time (n^2) finding duplicate elements

How does O(N) matters?? - choosing your collection, whcih one to use what type of operation you are doing,
example: Choosing between LinkedList and ArrayList.

Implementations performance characteristics
Inherantace performance characteristics

## Iterators
How the iteration works..Iterator pattern.
- have a for loop use .get()...
- iterator pattern removes the coupling

Traditional approach- find out the API underlyig the collection(ArrayList in our case) and then use .get()

Collection follows the iterator pattern
It returns an object called Iterator.

Hey I am incharge of iteration, dont worry about get(), peek()
I will handle.

.next(), .hasNext(), .previous()

There are different iterators in Collections, All of the collection APIs impl iterator pattern.

The contract of working is same for all.

public Iterator<E>{

    boolean hasNext(); //Are there more elements
    E next();  // Get the next element in this Iteration
    void remove(); //Remove the last element returned by the Iterator
    default void forEachRemaining(Consumer<? super E> action);
}

Iterators dont like remove opertation while iterating.
Some speacial Collections can do(ConcurrentHashMap)

Someone removed an object from collecion Iterator detects while getting the next element that collection is modified 
and it throws exception.

Reason : Iterators have their own contract for what it needs to return.
Example :
we have an ArrayList of three elements 1,2,3
one
two 
second

added zero b/w one and two now it is pointing to zero not two
Now what should iterator return 0 or 2

## Iterators vs for each loop

for each loop is a sugary syntax for iterator.

for(Type element :Iterable){

}

 What is Iterable?

Its an interace and implementing this interface allows an object to be the target
of the enchanced for each loop

benefit is we can use multiple iterator

Iterator has benefit for fine control over for each

Iterator<String> i = list.iterator();

While(i.hasNext()){
    sout(i.next());
}

== is address comparison

hashing is reducing the object into one value

by hash function

- Given a times hashcode should be same for that object no matter how many times you call hash function
- This is a one way thing, u can not get an object from hashCode.

Hash Collision:

More than two objects having the same hashCode.


If two objects are equal by .equals() method then their hashcode must be equal.
but vice versa is not true

Comparable is an object where it says that I can be compared please compare me.

Comparator is an interface where you can create objects which do comparisons.
compare(o1,o2);  Third party Comparator

We can create n number of them.
Pass an instance of Comparator to sort() method.

##Collection Interface..Top level interface

- Root interface in collection hirearchy
- No direct implementation in JDK
- Sub interfaces for collection types - lie Set,List
- Generic methods for adding and removing from the collection
- Underlying implementation decides what happens when the methods are called


All other are children. Map is an exception.. map doesnot implement Collection.

Collections is diffrent. Generic interface.

It extends Iterable interface.
Any collecion is iterable.

Certain methods are specified to be optional.

If a collection implementation doesnot implementation a particular operation, it should define the corresponding method to throw UnsupportedOpertationException.

Immutable Collections in java????


## Methods in Collections
- add()
- addAll()
- remove()
- removeAll()
- clear()
- retainAll()
- isEmpty()
- size()
- iterator()
- stream()
- toArray()
----

# List - An ordered collection of elements

Storing items in order with index based access

Insertion order is natural(default).

- remove(int index) 
- set(int index, E element)
- replaceAll(UnaryOperator<E> operator)
- contains()
- containsAll()
- indexOf(Object o)
- lastIndexOf(Object o)

- E get(int index)
- List<E> subList(int fromIndex, int toIndex)

- Iterator<E> iterator();
- ListIterator<E> listIterator();
- ListIterator<E> listIterator(int index);
- default Spliterator();
- void sort(Comparator<? super E> c);


performance of ArrayList
- get - O(1)
- set - O(1)
- contains - O(n)
- remove(0) - O(n)
- add(0) - O(n)
- add - is it O(n) at the end ?? but what if it overflows it creates a new arrayList of bigger size copies the elements
   Best case - O(1), Worst case O(n) - Most cases - O(1)
   so we take most of the case as Big O notation a overflowing happens not often


Amortized time - whats the net time it takes (in our arrayList overflow example just split the O(n) worst case to n and we will get lesser Big O notation so O(1))

## LinkedList - Node based access(value and address)

LinkedList performance
---
- get - O(n)
- set - O(n)
- contains - O(n)

- remove(0) - O(1)
- add(0) - O(1)
- add(n) - O(1)     //faster than arrayList --in likedList we can directly change the address values of preceeding and next element of n but first we need to go to that elment in linkedList that is also O(n)
- remove(n) - O(1)  //faster than arrayList Also consider O(n) of get

But if you are doing a lot of changes at a particular place then you dont need to get that element again so its O(1)

Performance difference b/w ArrayList and LinkedList
----
- Getting to n in linkedList is O(1) but after then adding element then on is O(1)
- ArrayList getting there is O(1) but adding is O(n)
- Position based access (get operations) - used ArrayList
- Constant and random insertions and removals - LinkedList

## When to use List?
- Position based access
- Duplicates doesn't matter

## Sets - No duplicate elements
Contains no pair of elements e1 and e2 such that e1.equals(e2) returns true

For using set you need to have a proper implementation of equals method otherwise it will use == by default

What about null?
-----
At most can have one null
-----


## HashSet - no order

Set does not have get() but have contains()

HashSet -- implemented by Hashtable
---

The way the hashSet is by holding on to the elements mapping it based on hashCode

First it generates the hashCode and based on the hashCode it puts the element in one bucket

There is a potential of hash Collision...So every hashCode has a list and it puts the element in the list that is mapped to the hashcode

Hash Bucket structure

- contigous
- LinkedList --- is the one for adding elements in bucket mapped to hashcode (facilitate retrieval and additon) adding at the end, removal rmeove any where in between --- read (scanning so same for both arrayList and linkedList)


HashSet efficiency  
- adding O(1) figure out the hashCode find the bucket and add at the end
- removing O(1) depends on hashCollisions too
- contains O(1)


Initial capacity of hashSet
- A array of size 16 and maps all of the possible integer values of hashCode that the hashCode() could provide to one of the 16 buckets


Adjusts over time by load factor 
---
number of elements / number of buckets

when Load factor reaches a limit it doubles the capacity.
16X2=32

0.75 is default Load factor
------

Use same property for hashCode and equals. If you use two properties of an object in equals and three in hashCode imagine if third property only changed and so hashCode value wil change and equals will be same then.
So breach of contract.


## LinkedHashSet - Ordered HashSet


Mantains a pointer to next elements as in LinkedList.
- insertion order
- Ordered iteration O(1)


 Rest same 

## TreeSet -- have its own way of contains by binary search TreeSet

adding, removal, checking is all O(logn)  becasue of binary tree

- TreeSet - Every element (Class) must be Comparable
calls compareTo() method. 
- compareTo() and equals() should be consistent

Issue - Imbalanced tree --- 

When to use set?
- Position is not important
- Fast Lookup
- Fast contains checking

HashSet vs TreeSet
- Use Hash set when Order is not important, sorting is not important, good hashing strategy, predicatable load factor


## Map - Key/Value pair

- doesn't have Collection interface
- cannot have duplicate keys
- put()
- get()
- replace(Key k, Value v)

## Iterating over Map
- KeySet 


 for(KeyType key : map.keySet()){
     sout(Key)
 }

 - Values

  for(ValueType value : map.values()){
     sout(value)
 }

 - EntrySet (Map.Entry<K,V>)


 for(Map.entry<K,V> entry : map.entrySet()){
    sout(entry.getKey().....entry.getValue())
 }


 -------
 getOrDefault(Key, default) --- returns if value is not there then "default" value is returned

 ------
 putIfAbsent(Key, element)  

 -----

 map.forEach((k,v) -> sout(value))

 ----
 computeIfAbsent(key, lambda function for making a default vaue i key is absent)

 ------

 ## HashMap
 It figures out the hashCode of the key then it uses that as bucket. 
 A single key can contain single value
 It maps hashCode to key/value pairs. Here linkedList is not just the elements but the Key/Value pairs

 ## Performance
 - get O(1)
 - containsKey O(1)
 - put O(1)


 ## Collections Class - utility class

 - This class contains static methods that operate on or return collections.

 ----
 - Collections.emptySet() ---> returns an empty set (Immutable)
 - Collections.emptyMap() ---> returns an empty map (Immutable)
 - Collections.emptyList() ---> returns an empty List (Immutable)

Usage of immutatble collections: Suppose we are calling an API which expects set as an argument but you dont have any values there instead of creating a new set and passing that in you pass Collections.emptySet() and say I intentionally dont want any elements to this argument.


---
- addAll(Collection<? super T> c, T...elements) --> varargs as new elements.
- max(Collection)
- min(Collection)
- reverseOrder()
- reverseOrder(Comparator)

