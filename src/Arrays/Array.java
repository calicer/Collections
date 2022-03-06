package Arrays;

import java.util.Arrays;

public class Array {

    public static void main(String[] args) {
        Person[] p = new Person[10];

        Person person1 = new Person("Vishal", "Bhalla");

        p[0] = person1;

        Person person2 = new Person("Aman", "Kohli");

        person1.setLastname("");
        p[0] = null;
        p[1] = person2;

        System.out.println(Arrays.toString(p));
        System.out.println(person1);

        System.out.println(Arrays.binarySearch(p,person1));

        //position based access
        //Needs sorting methods--by indexing
        //ordered vs un-ordered -- we needs sorting by default
        //Uniqueness
        //Affects addition behavior
        //No need for position based access
        //Retrieval -- key based
        //presence only retrieval
        //Mutability
        //concurrency

        //-------------Collection types------------------
        //what the collection can offer -- so grouping in lists, ques, maps
        //list does index based retrieval, but arraylist and linked list tells us how they are impl
        //Contract is interface and impl is classes

        //Arraylist--
        //Replacement for arrays
        //Collections->list->ArrayList

        //O-notation
        //Tradeoff
         //Feature req
         //Efficiency - time and space  space is usually propotional to size.

        //How do u measure time eff
        //bigger the size bigger the time  --- factor of N(Size)---O(N)
        //O(N) --> Time complexity
        //Rough interpretation

        //Linear Time -- Time is directly prop to size....bigger the arraylist longer the search op...
        //O(N) --> Linear time
        //What if element is found at first--it doesn't take the best scenario,,,take worst scenario too

        //add




    }
}
