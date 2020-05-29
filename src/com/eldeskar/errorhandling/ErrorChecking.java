package com.eldeskar.errorhandling;

import java.net.UnknownServiceException;
import java.util.List;

/**
 * 
 * @author Eldeskar
 * @version 29.05.2020
 */
public class ErrorChecking {

	public int divideNumbers(int numberToDivide, int divisor) {
		// Hier wird gepr�ft, ob durch null geteilt wird
		if (divisor == 0) {
			// hier wird eine exception geworfen, die der Aufrufer (Caller) der methode nun
			// l�sen muss.
			throw new IllegalArgumentException("Division durch null");
		}
		// hier wird die division durchgef�hrt.
		int result = numberToDivide / divisor;
		return result;
	}

	public double getAccountBalance(String accountOwner, boolean isLoggedIn) throws Exception {
		// Hier wird gepr�ft, ob der benutzer angemeldet wird. nat�rlich nur symbolisch
		// um
		// dies zu veranschaulichen.
		if (isLoggedIn) {
			return 10000;
		} else {
			// hier wird eine exception geworfen, die der Aufrufer (Caller) der methode nun
			// l�sen muss.
			throw new IllegalAccessException("Benutzer nicht authentifiziert");
		}
	}

	public Data getData(Connection connection) throws UnknownServiceException {
		// Hier wird die verbindung gepr�ft.
		if (connection.isConnected) {
			return connection.getData();
		} else {
			// hier wird eine exception geworfen, die der Aufrufer (Caller) der methode nun
			// l�sen muss.
			throw new UnknownServiceException("Keine Verbindung aufgebaut");
		}
	}

	public void saveNumber(int number) {
		// Hier wird gepr�ft, ob die Zahl sechs stellen hat.
		if (Integer.toString(number).length() == 6) {
			// hier w�rde die Zahl jetzt theoretisch gespeichert werden.
		} else {
			// hier wird eine exception geworfen, die der Aufrufer (Caller) der methode nun
			// l�sen muss.
			throw new IllegalArgumentException("Zahl ung�ltig");
		}
	}

	public int getNumber(int[] arrayOfInts, int index) {
		// hier pr�fe ich, ob der index g�ltig ist f�r diesen Array.
		if (index >= 0 && index < arrayOfInts.length) {
			return arrayOfInts[index];
		} else {
			// Hier l�se ich das problem ohne exception. Beispielsweise wurde hier
			// festgelegt, dass alle nicht vorhandenen indexe den wert 0 erhalten. ansonsten
			// w�rde ich dies ebenfalls mit einer exception l�sen.
			return 0;
		}
	}

	public void addUser(String user, List<String> userList) {
		// Hier pr�fe wird gepr�ft, ob der user bereits gespeichert wurde.
		if (userList.contains(user)) {
			// Hier wird gemeldet, dass der user bereits vorhanden ist.
			System.out.println("Benutzer bereits vorhanden");
		} else {
			// hier wird der user hinzugef�gt.
			userList.add(user);
		}
	}

	public void addDifferentNumbers(int number1, int number2) {
		// hier wird gepr�ft, ob die zahlen gleich sind.
		if (number1 == number2) {
			// hier wird gemeldet, dass die Zahlen gleich sind.
			System.out.println("Zahlen identisch");
		} else {
			// Hier wird das resultat ausgegeben.
			System.out.println(number1 + number2);
		}
	}

	private class Data {
		public String getInfos() {
			return "Hier k�nnte ihre Werbung stehen";
		}
	}

	private class Connection {
		boolean isConnected;

		public Data getData() {
			return new Data();
		}
	}

}
