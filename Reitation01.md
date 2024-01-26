# Notes from Recitation 1 : Jan 26 2024

Topic : Review of OOP - examples

### 1. Objects

```
public class Wizard {
    public String name;
    private int age;
    
    public Wizard(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
}
```
Calling : `Wizard harryPotter = new Wizard("Harry Potter", 18);`

Here Class = Wizard, Objects = name, age, Methods = getAge(), getName()

### 2. Inheritance

```
public class HogwartsStudent extends Wizard {
    private int year;
    private String house;

    public HogwartsStudent(String name, int age, int year, String house) {
        super(name, age);
        this.year = year;
        this.house = house;
    }

    public int getYear() {
        return year;
    }

    public String getHouse() {
        return house;
    }
}
```

Calling : 
```
HogwartsStudent harryPotter = new HogwartsStudent("Harry Potter", 18, 7, "Gryffindor");
System.out.println(harryPotter.getName()); // Output: Harry Potter
System.out.println(harryPotter.getYear()); // Output: 7
System.out.println(harryPotter.getHouse()); // Output: Gryffindor
```

Here, HogwartsStudent HAS to be a wizard, and thus `extends` the class Wizard

### 4. Public, Private, Protected
if HogwartsStudent had the following method : 

```
public void setName(String newName) {
        this.name = newName;
    }
```
This would work ^. Because Public.

```
public void setAge(int age) {
        this.age = age;
    }
```
This would NOT work ^. Because Private.

### Overloading/Overriding

Say you have Wizard as :

```
public class Wizard {
    private String name;
    private int age;

    public Wizard(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void castSpell() {
        System.out.println("Wizard " + name + " is casting a spell!");
    }

    public void castSpell(String spellName) {
        System.out.println("Wizard " + name + " is casting " + spellName + "!");
    }
}
```

A hogwarts student is bad at spells, so we can override as: 
```
public class HogwartsStudent extends Wizard {
    private int year;
    private String house;

    public HogwartsStudent(String name, int age, int year, String house) {
        super(name, age);
        this.year = year;
        this.house = house;
    }

    @Override
    public void castSpell() {
        System.out.println("Wingaaard Leviosa.....");
    }

    @Override
    public void castSpell(String spellName) {
        System.out.println("Hogwarts student " + getName() + " is casting " + spellName + "!");
    }
}
```

### 5. Overloading

Keeping away from Harry Pottere examples:


