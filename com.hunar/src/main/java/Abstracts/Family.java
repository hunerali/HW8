package Abstracts;

import java.util.*;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pet;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.pet = getPet();
        this.children = new ArrayList<>();
        father.setFamily(this);
        mother.setFamily(this);
    }

    public void addChild(Human child) {
        children.add(child);
        setChildren(children);
    }

    public void deleteChild(int index) {
        if (index < children.size()) {
            for (int i = 0; i < children.size(); i++) {
                if (i == index) getChildren().remove(i);
            }
        }
    }


    public int countFamily() {
        return 2 + getChildren().size();
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Set<Pet> getPet() {
        return pet;
    }

    public void setPet(Set<Pet> pet ) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        if (getPet() == null && getChildren().size() == 0) {
            return "com.company.Abstracts.Family{" +
                    "mother=" + mother.getName() + " " + mother.getSurname() +
                    ", father=" + father.getName() + " " + father.getSurname() +
                    '}';
        } else if (getPet() != null && getChildren().size() == 0) {
            return "com.company.Abstracts.Family{" +
                    "mother=" + mother.getName() + " " + mother.getSurname() +
                    ", father=" + father.getName() + " " + father.getSurname() +
                    ",\n pet=" + pet +
                    '}';
        } else if (getPet() == null && getChildren().size() != 0) {
            return "com.company.Abstracts.Family{" +
                    "mother=" + mother.getName() + " " + mother.getSurname() +
                    ", father=" + father.getName() + " " + father.getSurname() +
                    ",\n children=" + children +
                    '}';
        }
        return "com.company.Abstracts.Family{" +
                "mother=" + mother.getName() + " " + mother.getSurname() +
                ", father=" + father.getName() + " " + father.getSurname() +
                ",\n children=" + children +
                ",\n pet=" + pet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return mother.equals(family.mother) && father.equals(family.father) && Objects.equals(children, family.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this + " object collected by Garbage Collector");
    }


}

