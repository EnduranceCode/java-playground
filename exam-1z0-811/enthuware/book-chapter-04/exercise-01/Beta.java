package beta;

import alpha.Alpha;

public class Beta {

        public static String typeName = "Beta";

        public String betaField;

        public Beta(String value) {
                this.betaField = value;
        }

	public String getAlphaClass() {
		return Alpha.typeName;
	}

	public String getAlphaInstance(Alpha alpha) {
		return alpha.alphaField;
	}
}
