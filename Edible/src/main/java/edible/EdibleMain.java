package edible;

public class EdibleMain {

    public static void main(String[] args) {
        Object[] objects = { new Tiger(), new Chicken(), new Apple(), new Orange() };
        for (int i = 0; i < objects.length; i++) 
            if (objects[i] instanceof Edible)
                System.out.println(((Edible)objects[i]).hwoToEat());
    }
}

class Animal {
}

class Chicken extends Animal implements Edible {
    public String hwoToEat() {
        return "Chicken: Fry it";
    }
}

class Tiger extends Animal {
}

abstract class Fruit implements Edible {
}

class Apple extends Fruit {
    public String hwoToEat() {
        return "Appple: Make apple cider";
    }
}

class Orange extends Fruit {
    public String hwoToEat() {
        return "Orange: Make orange juice";
    }
}
