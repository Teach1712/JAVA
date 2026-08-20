// 1. Create a parent class named SevenWonders
class SevenWonders {
    // 2. Method to be overridden by subclasses
    void displayInfo() {
        System.out.println("This is one of the 7 Wonders of the World");
    }
}

// 3. Create 7 sub-classes that inherit SevenWonders class
class TajMahal extends SevenWonders {
    // 4. Inside each sub-class declare the output information
    @Override
    void displayInfo() {
        System.out.println("1. Taj Mahal - Agra, India");
        System.out.println("   Built by: Shah Jahan | Material: White Marble | Built in: 1643");
    }
}

class GreatWallOfChina extends SevenWonders {
    @Override
    void displayInfo() {
        System.out.println("2. Great Wall of China - China");
        System.out.println("   Length: 21,196 km | Built to: Protect Chinese states");
    }
}

class Petra extends SevenWonders {
    @Override
    void displayInfo() {
        System.out.println("3. Petra - Jordan");
        System.out.println("   Known as: Rose City | Carved in: Red Sandstone cliffs");
    }
}

class ChristTheRedeemer extends SevenWonders {
    @Override
    void displayInfo() {
        System.out.println("4. Christ the Redeemer - Rio de Janeiro, Brazil");
        System.out.println("   Height: 30 meters | Located on: Corcovado Mountain");
    }
}

class MachuPicchu extends SevenWonders {
    @Override
    void displayInfo() {
        System.out.println("5. Machu Picchu - Peru");
        System.out.println("   Built by: Incas | Location: Andes Mountains at 2430m");
    }
}

class ChichenItza extends SevenWonders {
    @Override
    void displayInfo() {
        System.out.println("6. Chichen Itza - Mexico");
        System.out.println("   Famous for: Temple of Kukulkan | Mayan Civilization");
    }
}

class Colosseum extends SevenWonders {
    @Override
    void displayInfo() {
        System.out.println("7. Colosseum - Rome, Italy");
        System.out.println("   Built in: 80 AD | Used for: Gladiator fights");
    }
}

public class SevenWondersDemo {
    public static void main(String[] args) {
        System.out.println("=== 7 Wonders of the World ===\n");
        
        // 5. In the main class call all methods using polymorphism
        // Parent class reference, Child class object
        SevenWonders w1 = new TajMahal();
        SevenWonders w2 = new GreatWallOfChina();
        SevenWonders w3 = new Petra();
        SevenWonders w4 = new ChristTheRedeemer();
        SevenWonders w5 = new MachuPicchu();
        SevenWonders w6 = new ChichenItza();
        SevenWonders w7 = new Colosseum();
        
        // Calling overridden methods
        w1.displayInfo();
        System.out.println();
        w2.displayInfo();
        System.out.println();
        w3.displayInfo();
        System.out.println();
        w4.displayInfo();
        System.out.println();
        w5.displayInfo();
        System.out.println();
        w6.displayInfo();
        System.out.println();
        w7.displayInfo();
    }
}