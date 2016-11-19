package testarraylist;

public class TestArrayListMain {
    public static void main(String[] args) {
        java.util.ArrayList cityList = new java.util.ArrayList();
        cityList.add("London");
        cityList.add("Denver");
        cityList.add("Paris");
        cityList.add("Miami");
        cityList.add("Beijing");

        System.out.println("List size? " + cityList.size());
        System.out.println("Is Miami in the list? " + cityList.contains("Miami"));
        System.out.println("The location of Beijing in the list? " + cityList.indexOf("Beijing"));
        System.out.println("Is the list empty? " + cityList.isEmpty());

        cityList.add(2, "Xian");
        cityList.remove("Paris");
        cityList.remove(1);
        System.out.println(cityList.toString());

        for (int i = cityList.size() - 1; i >= 0; i--)
            System.out.println(cityList.get(i) + " ");
        System.out.println();
    }
}
