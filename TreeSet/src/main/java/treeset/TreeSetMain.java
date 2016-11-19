package treeset;

import java.util.*;

public class TreeSetMain {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<String>();
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("Beijing");
        set.add("San Francisco");
        set.add("New York");

        System.out.println(set);

       for (Object element : set) 
           System.out.print(element.toString().toLowerCase() + " ");
    }
}
