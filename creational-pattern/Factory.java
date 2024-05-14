/**
 * @author Prerit Vishal
 */
class Main {
    public static void main(String[] args) {
        Burger spicyBurger = new SpicyBurgerResturant().orderBurger();
        System.out.println(spicyBurger);
        
        Burger jainBurger = new JainBurgerResturant().orderBurger();
        System.out.println(jainBurger);
        
        
    }
}

/**
 * An abstract class to delegate the action to actual implementation
 */

abstract class Resturant {

    public Burger orderBurger() {
        
        Burger burger = createBurger();
        burger.prepare();
        return burger;
    }

    /**
     * This method is actual factory method, and sub classes of this class will implement it
     */
    public abstract Burger createBurger();
}

/**
 * sub classes which contains the implementation of factory method
 * factory method pattern relies on inheritance, as it delegates all its work to implementations
 */

class SpicyBurgerResturant extends Resturant {
    
    @Override
    public Burger createBurger() {
        return new SpicyBurger();
    }
}

class JainBurgerResturant extends Resturant {
    
    @Override
    public Burger createBurger() {
        return new JainBurger();
    }
}

/**
 * An 'interface' whose soul job is to provide a genetic type to return various types of burger
 */

abstract class Burger {
    boolean onion = false;
    boolean spices = false;

    public abstract Burger prepare();
}

/**
 * Concrete classes wehere the actul processing logic of preparing burger is written
 */

class SpicyBurger extends Burger {
    String extra = "some extra spices";

    @Override
    public Burger prepare() {
        onion = true;
        spices = true;
        
        return new SpicyBurger();
    }
}

class JainBurger extends Burger {

    @Override
    public Burger prepare() {
        return new JainBurger();
    }
}