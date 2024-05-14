/**
 * @author Prerit Vishal
 */
class Main {
    public static void main(String[] args) {

        System.out.println(Singleton.getInstance("Abc"));
        System.out.println(Singleton.getInstance("def"));
        System.out.println(Singleton.getInstance("ghi"));

    }
}

/**
 * Singleton class which will return a single instance
 * irrespective of the fact how many times we create its instance
 */
class Singleton {

    /**
     * The instance is marked volatile so that it won't be accessble
     * from other threads while it is use in any other operation
     */
    private static volatile Singleton instance;

    private String data;

    /**
     * Private constructor to ensure it can be instantitated from any other place
     * 
     * @param data is used to init the data for the first time while creating the
     *             actual instance
     */
    private Singleton(String data) {
        this.data = data;
    }

    /**
     * 
     * @return a new instance for the first tine it is called.
     *         Then the already created instance if called next time beofer end of
     *         the program life cycle
     * 
     */
    public static Singleton getInstance(String data) {
        Singleton localInstance = instance;
        /**
         * Using local vars since reading and writing to volatile member is expensive
         * Using local vars can increase efficiency upto 40%
         */
        if (localInstance == null) {
            synchronized (Singleton.class) {
                localInstance = instance;
                if (localInstance == null) {
                    localInstance = instance = new Singleton(data);

                }
            }
        }

        return localInstance;
    }

    @Override
    public String toString() {
        return String.format("Singleton{data: %s, hashcode: %d}", data, hashCode());
    }

}