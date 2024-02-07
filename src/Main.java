import java.sql.*;

public class Main {
    public static void main(String[] args) {

        UseCase usecase = new UseCase();

        Studerende stdn1 = usecase.soegStuderende(1);

        //Søg alle oplysninger om studerende
        System.out.println(stdn1);









    }
}