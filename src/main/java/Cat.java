import java.util.HashSet;
import java.util.Set;

public class Cat {
    private final int id;
    private final String name;
    private final String color;
    private final int age;

    public Cat(int id, String name, String color, int age) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{кличка: " + name + ", цвет: " + color + ", возраст: " + age + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cat cat = (Cat) o;
        return id == cat.id && age == cat.age && name.equals(cat.name) && color.equals(cat.color);
    }

    @Override
    public int hashCode() {
        return id;
    }

    public static void main(String[] args) {
        Set<Cat> cats = new HashSet<>();
        cats.add(new Cat(1, "Барсик", "Рыжий", 3));
        cats.add(new Cat(1, "Барсик", "Рыжий", 3));
        cats.add(new Cat(1, "Барсик", "Рыжий", 3));
        cats.add(new Cat(2, "Васька", "Серый", 1));
        System.out.println(cats);
    }
}
