import java.util.Arrays;

public class Atomic {
	static final int LIMIT = 1000;

	public static void main(String[] args) {
		int[] broken = {500, 900};
		try {
			transferBroken(broken, 0, 1, 200);
		} catch (IllegalStateException e) {
			System.out.println("broken: " + e.getMessage() + ", now " + Arrays.toString(broken));
		}
		int[] atomic = {500, 900};
		try {
			transferAtomic(atomic, 0, 1, 200);
		} catch (IllegalStateException e) {
			System.out.println("atomic: " + e.getMessage() + ", now " + Arrays.toString(atomic));
		}
	}

	static void transferBroken(int[] balance, int from, int to, int amount) {
		balance[from] -= amount;                         // changed too early
		if (balance[to] + amount > LIMIT) {
			throw new IllegalStateException("limit of account " + to);
		}
		balance[to] += amount;
	}

	static void transferAtomic(int[] balance, int from, int to, int amount) {
		if (balance[to] + amount > LIMIT) {              // check everything first
			throw new IllegalStateException("limit of account " + to);
		}
		balance[from] -= amount;                         // then change
		balance[to] += amount;
	}
}
