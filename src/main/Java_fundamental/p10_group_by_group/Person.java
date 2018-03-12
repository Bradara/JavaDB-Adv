package p10_group_by_group;

public class Person {
    private final String name;
    private final int group;

    public Person(String name, int group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
