package hashset;

import java.util.*;

public class HashSetMain {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("London");
        set.add("Beijing");
        set.add("Shanghai");
        set.add("Taiwai");
        set.add("New York");
        set.add("Paris");

        System.out.println(set);
        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next().toUpperCase() + " ");
        }
    }
}
