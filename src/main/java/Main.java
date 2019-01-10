

public class Main {



    public static void main(String[] args) {


        User u1 = new User("Marek", "marekfrancja@wp.pl");
        GeneralOperations gen = new GeneralOperations();

        gen.addUser(u1);

        System.out.println(gen.getListOfUsers());



    }
}
