/**
 * @author Prerit Vishal
 */
class Main {
    public static void main(String[] args) {
        System.out.println(Resturant.orderBurger("spicy"));
        System.out.println(Resturant.orderBurger("jain"));
    }
}

/**
 * A basic 'client' requesting burger
 */

class Resturant {
    public static Burger orderBurger(String request) {
        
        SimpleBurgerFactory factory = new SimpleBurgerFactory();
        Burger burger = factory.createBurger(request);
        burger.prepare();
        return burger;
    }
}

/**
 * a factory class, where the logic for giving out different burger is written
 */

class SimpleBurgerFactory {
    public Burger createBurger(String type) {
        
        Burger burger = null;
        
        if ("spicy".equals(type)) {
            return new SpicyBurger();
        } else if ("jain".equals(type)) {
            return new JainBurger();
        }
        
        return burger;
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