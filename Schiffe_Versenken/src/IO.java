/** 
 * macht das Einlesen von Einfachen Daten einfacher 
 * durch Verdecken des Exception-Handlings
*/


import java.io.*;

public class IO {

	public static BufferedReader input
          = new BufferedReader(new InputStreamReader(System.in));
	public static String eingabe = "";

	// Einlesen eines char
	public static char readChar() {
		try {
			eingabe = input.readLine();
			return eingabe.charAt(0);
		}
		catch(Exception e) {
			return '\0';
		}
	}

	// Einlesen eines short
	public static short readShort() {
		try {
			eingabe = input.readLine();
			Integer string_to_short = new Integer(eingabe);
			return (short)string_to_short.intValue();
		}
		catch (Exception e) {
			return 0;
		}
	}	

	// Einlesen eines int
	public static int readInt() {
		try {
			eingabe = input.readLine();
			Integer string_to_int = new Integer(eingabe);
			return string_to_int.intValue();
		}
		catch (Exception e) {
		  return 0;
		}
	}

	// Einlesen eines long
	public static long readLong() {
		try {
			eingabe = input.readLine();
			Long string_to_long = new Long(eingabe);
			return string_to_long.longValue();
		}
		catch (Exception e) {
			return 0L;
		}
	}

	// Einlesen eines float
	public static float readFloat() {
		try {
			eingabe = input.readLine();
			Float string_to_float = new Float(eingabe);
			return string_to_float.floatValue();
		}
		catch (Exception e) {
			return 0.0F;
		}
	}

	// Einlesen eines double
	public static double readDouble() {
		try {
			eingabe = input.readLine();
			Double string_to_double = new Double(eingabe);
			return string_to_double.doubleValue();
		}
		catch (Exception e) {
			return 0.0;
		}
	}

	// Einlesen eines string
	public static String readString() {
		try {
			return input.readLine();
		}
		catch (Exception e) {
			return "";
		}
	}
	
	// Ausgabe
	public static void println(String s){
		System.out.println(s);
	}
	
	public static void print(String s){
		System.out.print(s);
	}
	
		public static void println(double s){
		System.out.println(s);
	}
	
	public static void print(double s){
		System.out.print(s);
	}
		public static void println(long s){
		System.out.println(s);
	}
	
	public static void print(long s){
		System.out.print(s);
	}
		public static void println(char s){
		System.out.println(s);
	}
	
	public static void print(char s){
		System.out.print(s);
	}
	
	
}

