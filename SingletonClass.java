public class SingletonClass {

    private SingletonClass() {

    }

    private static SingletonClass singletonClass = null;

    public static SingletonClass getSingletonClassObject() {

        if (singletonClass == null) {
            synchronized (SingletonClass.class) {
                if (singletonClass == null) {
                    singletonClass = new SingletonClass();
                }
            }
        }
        return singletonClass;
    }
}
