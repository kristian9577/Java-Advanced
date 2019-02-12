package FamilyTree;

import java.util.*;
import java.util.stream.Collectors;

public class FamilyTree {
    private Person descendent;
    private List<Person> predecessors;
    private Map<String, List<String>> relations;

    public FamilyTree() {
        this.predecessors = new ArrayList<>();
        this.relations = new LinkedHashMap<>();
    }

    public void addRelation(String parent, String child) {
        this.relations.putIfAbsent(parent, new ArrayList<>());
        this.relations.get(parent).add(child);
    }

    public void addFamilyMember(String givenName, String familyName, String birthDate) {
        Person member = new Person(givenName, familyName, birthDate);
        this.predecessors.add(member);
    }

    public void tieInformation() {
        for (String key : relations.keySet()) {
            Person parent = this.getPerson(key);

            if (parent == null) {
                continue;
            }

            List<String> children = this.relations.get(key);
            for (String childString : children) {
                Person child = this.getPerson(childString);
                if (child == null) {
                    continue;
                }
                parent.addChild(child);
            }
        }

        this.descendent = getDescendent(this.descendent);
    }

    private Person getPerson(String parameter) {
        return this.predecessors
                .stream()
                .filter(person -> person.getName().equals(parameter) || person.getBirthDate().equals(parameter))
                .findFirst()
                .orElse(null);
    }

    private Person getDescendent(Person descendent) {
        if (descendent.isName()) {
            return this.getPerson(descendent.getName());
        } else {
            return this.getPerson(descendent.getBirthDate());
        }
    }

    @Override
    public String toString() {
        Collection<Person> parents = this.descendent.getParents();
        Collection<Person> children = this.descendent.getChildren();
        String output = String.format("%s %s\nParents:\n", this.descendent.getName(), this.descendent.getBirthDate());
        if (!parents.isEmpty()) {
            output += getCollectionToString(parents);
            output += "\n";
        }
        output += "Children:\n";
        if (!children.isEmpty()) {
            output += getCollectionToString(children);
        }
        return output;
    }

    private String getCollectionToString(Collection<Person> parents) {
        return parents.stream().map(Person::toString).collect(Collectors.joining("\n"));
    }

    public void setDescendent(Person descendent) {
        this.descendent = descendent;
    }
}