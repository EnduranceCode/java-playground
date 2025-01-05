public class FinancialApp {
	public static void main(String[] args) {
		double interest = FinancialFunctions.computeSimpleInterest(1000, 10, 1);

		System.out.println(interest);
	}
}


class FinancialFunctions {
	static double computeSimpleInterest(double principle, double rate, double time) {
		return principle * rate * time / 100;
	}
}
