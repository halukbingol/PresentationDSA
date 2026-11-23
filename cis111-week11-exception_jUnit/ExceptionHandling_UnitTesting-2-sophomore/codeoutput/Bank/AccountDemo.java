public class AccountDemo {
	public static void main(String[] args) {
		Account a = new Account("Ada");
		a.deposit(100);
		try {
			a.withdraw(30);
			a.withdraw(90);                          // too much
		} catch (InsufficientFundsException e) {
			System.out.println(e.getMessage() + "; missing " + e.getMissing());
		}
		try {
			a.deposit(-5);                           // a bug of the caller
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		a.close();
		try {
			a.deposit(10);                           // wrong time
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("balance " + a.getBalance());
		new Account(null);                           // not caught: see the report
	}
}
