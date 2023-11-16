package _09_Databaza_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Result;


public class Starter_01 {

	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost/";
		String username = "root";
		String password = "";
		String databaza = "Java";
		String tabulka = "Tabulka_01";
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
			System.out.println("1. Insert; 2.Update; 3.Remove; 4.Print; 5.Exit" );
			
			int volba = vstup.nextInt();
			switch(volba) {
			/*case 1: insert(stmt); break;
			case 2: update(stmt); break;
			case 3: remove(stmt); break;*/
			case 4: select(stmt); break;
			case 5: System.exit(0);
			default: System.out.println("Chyba, iba medzi 1 a 5.");
			}
		}
	}
	
	public static void select(Statement stmt) {
		try {
			String dotaz = "SELECT * FROM Tabulka_01";
			ResultSet rs = stmt.executeQuery(dotaz);
			
			while(rs.next()) {
				System.out.println(rs.getString("id") + " : " + rs.getString("Meno")  + " : " + rs.getString("Pocet_deti") 
				 + " : " + rs.getString("Bydlisko")  + " : " + rs.getString("Stav"));
			}
		}
		catch (Exception e) {
			System.out.println("Ovladac nenajdeny: " + e.toString());
		}
	}
		
		/*public static void insert(Statement stmt) {
			try {
				Scanner vstup = new Scanner(System.in);
				System.out.println("Zadaj id:");
				String id = vstup.next();
				System.out.println("Zadaj Meno:");
				String Meno = vstup.next();
				System.out.println("Zadaj Pocet_deti:");
				String Pocet_deti = vstup.next();
				System.out.println("Zadaj Bydlisko:");
				String Bydlisko = vstup.next();
				System.out.println("Zadaj Stav:");
				String Stav = vstup.next();
				
				String vloz = "INSERT INTO Tabulka_01 (id, Meno, Pocet_deti, Bydlisko, Stav VALUES"
						+ "{'"id+"'}" ;
				
				
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}*/
	
	
	
	}
	

	


