class SingletonPattern {
    private static SingletonPattern instance;
   // creating singleton pattern for single thread
    // public static SingletonPattern getInstance() {
    //     if(instance == null){
    //         return new SingletonPattern();
    //     }
    //     return instance;
    // }

    // creating singleton pattern for multi thread
    public static SingletonPattern getInstance() {
        if(instance == null){
            synchronized(SingletonPattern.class){
                if(instance == null){
                    return new SingletonPattern();
                }
            }
        }
        return instance;
    }
}