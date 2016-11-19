package linkedhashset;

import java.util.*;

public class LinkedHashSetMain {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>();
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
