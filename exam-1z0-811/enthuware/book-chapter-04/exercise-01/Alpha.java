package alpha;

import beta.Beta;

public class Alpha {

	public static String typeName = "Alpha";

	public String alphaField;

	public Alpha(String value) {
		this.alphaField = value;
	}

	public static void main(String[] args) {

		Alpha alpha = new Alpha("alpha");
		Beta beta = new Beta("beta");

		System.out.println("Alpha access Beta class field: " + Beta.typeName);
		System.out.println("Alpha access Beta instance field: " + beta.betaField);

		System.out.println("Beta acess Alpha class field: " +  beta.getAlphaClass());
		System.out.println("Beta access Alpha instance field: " + beta.getAlphaInstance(alpha));
	}
}
