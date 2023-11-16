package _09_Databaza_1;
import java.sql.*;
import java.util.Scanner;

public class Starter {
    private static final String URL = "jdbc:mysql://localhost";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String databaza = "Tabulka_01";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            Scanner scanner = new Scanner(System.in);
            int volba;

            do {
                System.out.println("1. Výpis obsahu ");
                System.out.println("2. Nový záznam");
                System.out.println("3. Vymazanie záznamu");
                System.out.println("4. Zmena záznamu");
                System.out.println("0. Ukončiť");
                volba = scanner.nextInt();
                scanner.nextLine(); 

                switch (volba) {
                    case 1:
                        zobraz(connection);
                        break;
                    case 2:
                        vloz(connection, scanner);
                        break;
                    case 3:
                        vymaz(connection, scanner);
                        break;
                    case 4:
                        update(connection, scanner);
                        break;
                    case 0:
                        System.out.println("Koniec");
                        break;
                    default:
                        System.out.println("Zlý vstup");
                }
            } while (volba != 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void zobraz(Connection connection) throws SQLException {
        String selectSQL = "SELECT * FROM Tabulka_01";
        try (Statement statement = connection.createStatement();
             ResultSet vysledok = statement.executeQuery(selectSQL)) {

            System.out.println("ID\tMeno\tPriezvisko\tPopis priestupku\tDatum\tSuma");
            while (vysledok.next()) {
                System.out.println(vysledok.getInt("id") + "\t" +
                        vysledok.getString("meno") + "\t" +
                        vysledok.getString("priezvisko") + "\t" +
                        vysledok.getString("popis_priestupku") + "\t" +
                        vysledok.getDate("datum") + "\t" +
                        vysledok.getDouble("suma"));
            }
        }
    }

    private static void vloz(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Meno: ");
        String meno = scanner.nextLine();

        System.out.print("Priezvisko: ");
        String priezvisko = scanner.nextLine();

        System.out.print("Popis priestupku: ");
        String popisPriestupku = scanner.nextLine();

        System.out.print("Datum (YYYY-MM-DD): ");
        String datumStr = scanner.nextLine();
        Date datum = Date.valueOf(datumStr);

        System.out.print("Suma: ");
        double suma = scanner.nextDouble();

        String insertSQL = "INSERT INTO priestupky (meno, priezvisko, popis_priestupku, datum, suma) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, meno);
            preparedStatement.setString(2, priezvisko);
            preparedStatement.setString(3, popisPriestupku);
            preparedStatement.setDate(4, datum);
            preparedStatement.setDouble(5, suma);

            preparedStatement.executeUpdate();
            System.out.println("Záznam bol úspešne vložený.");
        }
    }

    private static void vymaz(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Zadajte ID záznamu na vymazanie: ");
        int odstranId = scanner.nextInt();

        String deleteSQL = "DELETE FROM priestupky WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, odstranId);
            int stlpce = preparedStatement.executeUpdate();

            if (stlpce > 0) {
                System.out.println("Záznam bol úspešne vymazaný.");
            } else {
                System.out.println("Záznam s ID " + odstranId + " neexistuje.");
            }
        }
    }

    private static void update(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Zadajte ID záznamu na zmenu: ");
        int stareId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Nové meno: ");
        String noveMeno = scanner.nextLine();

        System.out.print("Nové priezvisko: ");
        String novePriezvisko = scanner.nextLine();
        System.out.print("Nový popis priestupku: ");
        String novyPopis = scanner.nextLine();

        System.out.print("Nový datum (YYYY-MM-DD): ");
        String novyDatumStr = scanner.nextLine();
        Date novyDatum = Date.valueOf(novyDatumStr);

        System.out.print("Nová suma: ");
        double novaSuma = scanner.nextDouble();

        String updateSQL = "UPDATE priestupky SET meno = ?, priezvisko = ?, popis_priestupku = ?, datum = ?, suma = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, noveMeno);
            preparedStatement.setString(2, novePriezvisko);
            preparedStatement.setString(3, novyPopis);
            preparedStatement.setDate(4, novyDatum);
            preparedStatement.setDouble(5, novaSuma);
            preparedStatement.setInt(6, stareId);

            int stlpce = preparedStatement.executeUpdate();

            if (stlpce > 0) {
                System.out.println("Záznam bol úspešne zmenený.");
            } else {
                System.out.println("Záznam s ID " + stareId + " neexistuje.");
            }
        }
    }

}
