import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Sieve newSieve = new Sieve();
		Scanner scan = new Scanner(System.in);
		int n;
		
		System.out.println("Please enter upper bound");
		n = Integer.valueOf(scan.nextLine());
		
		newSieve.primesTo(n);
	}

}
