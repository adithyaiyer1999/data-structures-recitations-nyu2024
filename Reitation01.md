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

Keeping away from Harry Potter examples:

```
public class Sum { 
    // Overloaded sum(). This sum takes two int parameters 
    public int sum(int x, int y) { return (x + y); } 
  
    // Overloaded sum(). This sum takes three int parameters 
    public int sum(int x, int y, int z) 
    { 
        return (x + y + z); 
    } 
  
    // Overloaded sum(). This sum takes two double 
    // parameters 
    public double sum(double x, double y) 
    { 
        return (x + y); 
    } 
  
    // Driver code 
    public static void main(String args[]) 
    { 
        Sum s = new Sum(); 
        System.out.println(s.sum(10, 20)); 
        System.out.println(s.sum(10, 20, 30)); 
        System.out.println(s.sum(10.5, 20.5)); 
    } 
}
```

All 3 will work - depending on what you provide.

### 6. Polymorphism

```
public class Main {
    public static void main(String[] args) {
        Wizard ron = new HogwartsStudent("Ron Weasley", "Gryffindor");
        ron.castSpell(); // Output: Hogwarts student Ron Weasley from Gryffindor is casting a spell!
    }
}
```

Ron can just be defined as a wizard, and still be called.

### 7. Casting

Upcasting example : `Wizard ron = new HogwartsStudent("Ron Weasley", "Gryffindor");` 

here : a hogwarts student is BEING considered a wizard

Downcasting example: 
```
Wizard harry = new Wizard("Harry Potter", 18); // You're a wizard harry
HogwartsStudent harryPotter = (HogwartsStudent) harry;
```

here : a wizard is just being thought as a hogwarts student


### 8. Interface

```
public interface SpellCaster {
    void castSpell();
}

public class Wizard implements SpellCaster {
    private String name;

    public Wizard(String name) {
        this.name = name;
    }

    @Override
    public void castSpell() {
        System.out.println("Wizard " + name + " is casting a spell!");
    }
}
```

here, `castSpell()` HAS to be defined by the class wizard since it implements the class SpellCaster


