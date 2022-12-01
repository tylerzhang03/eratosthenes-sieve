public class Sieve {
	
	private ArrayQueue<Integer> numbers;
	private ArrayQueue<Integer> primes;
	private ArrayQueue<Integer> newNums;
	
	public Sieve() {
		numbers = new ArrayQueue<>();
		primes = new ArrayQueue<>();
		newNums = new ArrayQueue<>();
	}
	
	public void primesTo(int n) {
		if (n < 2) throw new IllegalArgumentException("Error: Input must be a number greater than 2.");
		
		for (int i = 2; i <= n; i++) {
			numbers.enqueue(i);
		}
		
		int p = numbers.first();
		while (p <= Math.sqrt(n)) {
			primes.enqueue(p);
			eliminate(p);
			p = numbers.first();
		}
		
		while (!numbers.isEmpty()) {
			primes.enqueue(numbers.dequeue());
		}
		
		System.out.print("Primes up to " + n + " are: ");
		System.out.print(primes.dequeue());
		while (!primes.isEmpty()) {
			System.out.print(", " + primes.dequeue());
		}
	}
	
	private void eliminate(int p) {
		while (!numbers.isEmpty()) {
			if (numbers.first() % p == 0) {
				numbers.dequeue();
			} else newNums.enqueue(numbers.dequeue());
		}
		while (!newNums.isEmpty()) {
			numbers.enqueue(newNums.dequeue());
		}
	}
}
