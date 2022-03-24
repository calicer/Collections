
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

