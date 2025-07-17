package co.example.com;



public class DBConnection {

	private static volatile DBConnection obj;

	private DBConnection(){
		if(obj!=null){
			throw new IllegalStateException("Cannot create instance, use getInstance() method");
		}
	}

	public static DBConnection getInstance(){

		if(obj==null){
			synchronized(DBConnection.class){
				if(obj==null){
					obj= new DBConnection();
				}
			}
		}
		return obj;
	}

	public void connect() {
		System.out.println("Database connection established.");
	}


	protected Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException("Clone not supported for singleton class");
	}


	protected Object readResolve(){
		return getInstance();
	}

}