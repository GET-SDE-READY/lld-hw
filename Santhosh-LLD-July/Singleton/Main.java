 class Main{
    public static void main(String[] args){

        MySingleton obj1 = MySingleton.getInstance();
        MySingleton obj2 = MySingleton.getInstance();

        System.out.println(obj1 == obj2);
    }
}

class MySingleton {
    private static MySingleton INSTANCE = null;
    private MySingleton(){}

    // public static MySingleton getInstance(){

    //     if(INSTANCE == null){
    //         INSTANCE = new MySingleton();
    //     }
    //     return INSTANCE;
    // }

    public static MySingleton getInstance(){

        if(INSTANCE == null){
            synchronized(MySingleton.class){
                if(INSTANCE == null){
                    INSTANCE = new MySingleton();
                }
            }
        }
        return INSTANCE;
    }

}

//Bill Pugh Singleton

/* 
public class MySingleton {
    // Private constructor prevents instantiation from other classes
    private MySingleton() { }

    // Static inner class - loaded only when referenced
    private static class Holder {
        private static final MySingleton INSTANCE = new MySingleton();
    }

    // Global access point
    public static MySingleton getInstance() {
        return Holder.INSTANCE;
    }
}
*/