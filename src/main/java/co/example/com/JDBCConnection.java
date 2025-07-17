package co.example.com;

public enum JDBCConnection {

    INSTANCE;


    public void connect() {
        // Logic to establish a JDBC connection
        System.out.println("Establishing JDBC connection...");
        // Add actual connection logic here
    }
}
