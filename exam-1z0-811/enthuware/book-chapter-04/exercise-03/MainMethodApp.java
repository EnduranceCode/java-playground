public class MainMethodApp {

	public static void main(String[] args) {

		int argumentsNumber = args.length;
		System.out.println("The number of provided arguments is " + argumentsNumber);

		for (int i = 0; i < argumentsNumber; i++) {
			System.out.println("Argument[" + i + "] = " + args[i]);
		}
	}
}
