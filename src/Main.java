import java.sql.*;
import java.util.Scanner;

public class Main {

    private static final String DB_USERNAME = "postgres";

    private static final String DB_PASSWORD = "gjhfqr102";

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/newtest";

    public static void main(String[] args) throws Exception{
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select * from testaccounts");

        while (result.next()) {
            System.out.println(result.getInt("id") + " " + result.getString("name"));
        }

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String email = scanner.nextLine();
        int age = scanner.nextInt();

        String sqlInsert = "insert into testaccounts(name, email, age)" +
                "values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);
        preparedStatement.setInt(3, age);
        preparedStatement.executeUpdate();
        System.out.println("Успешно");
    }
}