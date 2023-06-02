import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class Calculator{
    public static void main(String[] args) {
        String username = "postgres";

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "admin";



        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            String createTableQuery = "CREATE TABLE IF NOT EXISTS history (operation VARCHAR)";
            statement.executeUpdate(createTableQuery);

            String insertQuery = "INSERT INTO history (operation,num1,num2,result) VALUES (?,?,?,?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите первое число: ");
            double num1 = scanner.nextDouble();
            System.out.print("Введите второе число: ");
            double num2 = scanner.nextDouble();




            double additionResult = num1 + num2;
            System.out.println("Результат сложения: " + additionResult);
            insertStatement.setString(1, "Сложение: " + additionResult);
            insertStatement.executeUpdate();





            double subtractionResult = num1 - num2;
            System.out.println("Результат вычитания: " + subtractionResult);
            insertStatement.setString(1, "Вычитание: " + subtractionResult);
            insertStatement.executeUpdate();

            insertStatement.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



