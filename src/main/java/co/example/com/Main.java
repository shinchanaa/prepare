package co.example.com;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        Main obj = new Main();
       obj.printTest();


        DBConnection dbConnection = DBConnection.getInstance();
        dbConnection.connect();

        JDBCConnection jdbcConnection = JDBCConnection.INSTANCE;
        jdbcConnection.connect();


    }

    private void printTest(){
        System.out.println("Test");
    }

    private static void displayMessage() {
        System.out.println("This is a message from the displayMessage method.");
    }

    private void displayMessage2() {
        System.out.println("This is a message from the displayMessage method.");
        displayMessage();
    }
}