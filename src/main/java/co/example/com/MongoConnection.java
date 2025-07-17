package co.example.com;


import java.io.Serializable;

public class MongoConnection  implements Serializable {

    private static final long serialVersionUID= 1L;


    private MongoConnection(){

        if(Helper.INSTANCE!= null){
            throw new IllegalStateException("MongoConnection instance already created");
        }

    }

    private static class Helper{
        private static final MongoConnection INSTANCE = new MongoConnection();
    }

    public static MongoConnection getInstance(){
        return Helper.INSTANCE;
    }


    protected Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException("MongoConnection cannot be cloned");
    }

    protected Object readResolve(){
        return getInstance();
    }




}