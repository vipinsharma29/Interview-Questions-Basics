package designPatterns.structural;

interface Menus {
    void showMenu();
}

interface Hotel {
    Menus getMenus();
}

// HotelKeeperFacade is the Facade class that help ypu communicate with the Hotel classes
interface HotelKeeperFacade {
    VegMenu getVegMenu();

    NonVegMenu getNonVegMenu();

    Both getVegNonMenu();
}

// Define the VegMenu class
class VegMenu implements Menus {
    @Override
    public void showMenu() {
        System.out.println("Veg Menu");
    }
}

// Define the NonVegMenu class
class NonVegMenu implements Menus {
    @Override
    public void showMenu() {
        System.out.println("Non-Veg Menu");
    }
}

// Define the Both class
class Both implements Menus {
    @Override
    public void showMenu() {
        System.out.println("Both Veg and Non-Veg Menu");
    }
}

class VegRestaurant implements Hotel {

    public Menus getMenus() {
        return new VegMenu();
    }
}

class NonVegRestaurant implements Hotel {

    public Menus getMenus() {
        return new NonVegMenu();
    }
}

class VegNonBothRestaurant implements Hotel {

    public Menus getMenus() {
        return new Both();
    }
}

// Implement the HotelKeeperFacade
class HotelKeeperFacadeImplementation implements HotelKeeperFacade {

    public VegMenu getVegMenu() {
        VegRestaurant v = new VegRestaurant();
        return (VegMenu) v.getMenus();
    }

    public NonVegMenu getNonVegMenu() {
        NonVegRestaurant v = new NonVegRestaurant();
        return (NonVegMenu) v.getMenus();
    }

    public Both getVegNonMenu() {
        VegNonBothRestaurant v = new VegNonBothRestaurant();
        return (Both) v.getMenus();
    }
}

public class FacadeDesignPattern {

    public static void main(String[] args) {
        HotelKeeperFacade keeper = new HotelKeeperFacadeImplementation();

        VegMenu v = keeper.getVegMenu();
        v.showMenu();
        NonVegMenu nv = keeper.getNonVegMenu();
        nv.showMenu();
        Both bo = keeper.getVegNonMenu();
        bo.showMenu();
    }
}
