package _09_Databaza_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Result;


public class Starter_01 {

	private static final String c1 = "Id";
	private static final String c2="Meno";
	private static final String c3="Priezvisko";
	private static final String c4="Popis_priestupku";
	private static final String c5="Datum";
	private static final String c6="Suma";
	
	private static final String databaza = "Java_01";
	private static final String tabulka = "Tabulka_01";

	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost/";
		String username = "root";
		String password = "";
		
		try {
			Connection con = DriverManager.getConnection(URL+databaza, username, password);
			
			Statement stmt = con.createStatement();
			menu(stmt);
			
			stmt.close();
			con.close();
			}
		catch (Exception e) {
			System.out.println("Ovladac nenadeny: " + e.toString());
		}
		}
	
	public static void menu(Statement stmt) {
		Scanner vstup = new Scanner(System.in);
		
		while(true) {
			System.out.println("Menu");
			System.out.println(" 1. Insert\n 2. Update\n 3. Remove\n 4. Print\n 5. Exit" );
			
			int volba = vstup.nextInt();
			switch(volba) {
			case 1: insert(stmt); break;
			case 2: update(stmt); break;
			case 3: remove(stmt); break;
			case 4: select(stmt); break;
			case 5: System.exit(volba);
			default: System.out.println("Chyba, iba medzi 1 a 5.");
			}
		}
	}
	
		public static void select(Statement stmt) {
		try {
			String dotaz = "SELECT * FROM "+tabulka;
			ResultSet rs = stmt.executeQuery(dotaz);
			System.out.println(c1+"\t"+c2+"\t"+c3+"\t"+c4+"\t"+c5+"\t"+c6);
			while(rs.next()) {
				System.out.println(rs.getString(c1) + " \t: " + rs.getString(c2)  + " \t: " + rs.getString(c3) 
				 + " \t: " + rs.getString(c4)  + " \t: " + rs.getString(c5) + " \t: " + rs.getString(c6));
			}
		}
		catch (Exception e) {
			System.out.println("Ovladac nenajdeny: " + e.toString());
		}
	}
		
		public static void insert(Statement stmt) {
			try {
				Scanner vstup = new Scanner(System.in);
				/*System.out.println("Zadaj id:");
				String id = vstup.next();*/
				System.out.println("Zadaj Meno:");
				String Meno = vstup.next();
				System.out.println("Zadaj Priezvisko:");
				String Priezvisko = vstup.next();
				System.out.println("Zadaj Popis_priestupku:");
				String Popis_priestupku = vstup.next();
				System.out.println("Zadaj Datum Vo formate RRRR-MM-DD");
				String Datum = vstup.next();
				System.out.println("Zadaj Sumu:");
				String Suma = vstup.next();
				
				 String vloz = "INSERT INTO Tabulka_01 (" + c2 + ", " + c3 + ", " + c4 + ", " + c5 + ", " + c6 + ") VALUES " +
			                "('" + Meno + "','" + Priezvisko + "','" + Popis_priestupku + "','" + Datum + "','" + Suma + "')";
				 stmt.execute(vloz);
			}
			catch (Exception e) {
				System.out.println("Ovladac nenajdeny: "+ e.toString());
			}
		}
	
		public static void remove(Statement stmt) {
			try {
			Scanner vstup = new Scanner(System.in);
			System.out.println("Vloz ID, podla ktoreho sa zaznam odstrani:");
			int Totok = vstup.nextInt();
			
			String odstran = "DELETE FROM "+tabulka+" WHERE "+c1+" = "+Totok;
				stmt.execute(odstran);
			} catch (SQLException e) {
				System.out.println("Ovladac nenajdeny: "+ e.toString());
			}
		}
		
		public static void update(Statement stmt) {
		    try {
		        Scanner vstup = new Scanner(System.in);
		        System.out.println("Vloz ID, podla ktoreho sa zaznam upravi:");
		        int Totok = vstup.nextInt();

		        String dotaz = "SELECT * FROM " + tabulka + " WHERE " + c1 + " = " + Totok;
		        ResultSet rs = stmt.executeQuery(dotaz);

		        String upravenia = "";

		        if (rs.next()) {
		            System.out.println("CHces prepisat " + c2 + " \"" + rs.getString(c2) + "\" ? N/y");
		            String r1 = vstup.next();
		            if (r1.equalsIgnoreCase("y")) {
		                System.out.println("Ako?");
		                vstup.nextLine(); // Consume the newline character
		                String meno_ = vstup.nextLine();
		                upravenia += c2 + " = '" + meno_ + "',";
		            }

		            System.out.println("CHces prepisat " + c3 + " \"" + rs.getString(c3) + "\" ? N/y");
		            String r2 = vstup.next();
		            if (r2.equalsIgnoreCase("y")) {
		                System.out.println("Ako?");
		                vstup.nextLine();
		                String priezvisko_ = vstup.nextLine();
		                upravenia += c3 + " = '" + priezvisko_ + "',";
		            }

		            System.out.println("CHces prepisat " + c4 + " \"" + rs.getString(c4) + "\" ? N/y");
		            String r3 = vstup.next();

		            if (r3.equalsIgnoreCase("y")) {
		                System.out.println("Ako?");
		                vstup.nextLine();
		                String Popis_priestupku_ = vstup.nextLine();
		                upravenia += c4 + " = '" + Popis_priestupku_ + "',";
		            }

		            System.out.println("CHces prepisat " + c5 + " \"" + rs.getString(c5) + "\" ? N/y");
		            String r4 = vstup.next();
		            if (r4.equalsIgnoreCase("y")) {
		                System.out.println("Ako?");
		                vstup.nextLine();
		                String Datum_ = vstup.nextLine();
		                upravenia += c5 + " = '" + Datum_ + "',";
		            }

		            System.out.println("CHces prepisat " + c6 + " \"" + rs.getString(c6) + "\" ? N/y");
		            String r5 = vstup.next();
		            if (r5.equalsIgnoreCase("y")) {
		                System.out.println("Ako?");
		                vstup.nextLine();
		                String Suma_ = vstup.nextLine();
		                upravenia += c6 + " = '" + Suma_ + "',";
		            }

		            if (!upravenia.isEmpty()) {
		                upravenia = upravenia.substring(0, upravenia.length() - 1);

		                String uprav = "UPDATE " + tabulka + " SET " + upravenia + " WHERE " + c1 + " = " + Totok;
		                System.out.println(uprav);
		                stmt.execute(uprav);
		                System.out.println("Update successful!");
		            } else {
		                System.out.println("Ziadne stlpce na aktualizaciu.");
		            }
		        } else {
		            System.out.println("Zaznam s ID " + Totok + " neexistuje.");
		        }
		    } catch (Exception e) {
		        System.out.println("Ovladac nenajdeny: " + e.toString());
		    }
		}


	}
	

	


