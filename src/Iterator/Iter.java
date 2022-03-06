package Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iter {

    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        li.add(1);
        li.add(2);
        li.add(3);
        li.add(4);
        li.add(5); li.add(6);

       Iterator<Integer> i = li.iterator();

       while(i.hasNext()){
           System.out.println(i.next());
       }

    }
}
