package methodincollection;

public class MethodInCollectionMain {
    public static void main(String[] args) {
        java.util.Set<String> set1 = new java.util.HashSet<String>();
        set1.add("London");
        set1.add("Paris");
        set1.add("New York");
        set1.add("San Francisco");
        set1.add("Beijing");

        System.out.println("set1 is " + set1);
        System.out.println(set1.size() + " elements in set1");

        set1.remove("London");
        System.out.println("\nset1 is " + set1);
        System.out.println(set1.size() + " elements in set1");

        java.util.Set<String> set2 = new java.util.HashSet<String>();

        set2.add("London");
        set2.add("Shanghai");
        set2.add("Paris");
        System.out.println("\nset2 is " + set1);
        System.out.println(set1.size() + " elements in set2");

        System.out.println("\nIs Taipei is set2? " + set2.contains("Taipei"));
        set1.addAll(set2);
        System.out.println("\nAfter addding set2 to set1, set1 is " + set1);
        set1.removeAll(set2);
        System.out.println("After removeing set2 from set1, set1 is " + set1);

        set1.retainAll(set2);
        System.out.println("After removeing commn elements in set2 from set1, set1 is " + set1);
    }
}



