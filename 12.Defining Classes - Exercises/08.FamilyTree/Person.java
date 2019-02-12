package FamilyTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private String birthDate;
    private List<Person> parents;
    private List<Person> children;

    public Person() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String birthDate) {
        this();
        this.birthDate = birthDate;
    }

    public Person(String givenName, String familyName) {
        this();
        this.setName(givenName, familyName);
    }

    public Person(String givenName, String familyName, String birthDate) {
        this();
        this.setName(givenName, familyName);
        this.birthDate = birthDate;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String givenName, String familyName) {
        this.name = givenName + " " + familyName;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public Collection<Person> getParents() {
        return Collections.unmodifiableCollection(this.parents);
    }

    public Collection<Person> getChildren() {
        return Collections.unmodifiableCollection(this.children);
    }

    public void addChild(Person child) {
        this.children.add(child);
        child.addParent(this);
    }

    private void addParent(Person parent) {
        this.parents.add(parent);
    }

    public boolean isName() {
        return this.name != null;
    }

    public boolean isBirthDate() {
        return this.birthDate != null;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthDate);
    }
}
