package reseau_petri;

/**
 * @author IML A place is represented by a circle. Each place contains a number
 *         of tokens. A place is liked to places though transitions. Each place
 *         has its own unique ID.
 */

public class Place {
	private static final int DEFAULTTOKENVALUE = 0;
	private static int IDVALUE = 1;
	private int nbTokens;
	private int id;

	/**
	 * Default constructor : initializes a place containing 0 tokens.
	 */
	public Place() {
		this.id = IDVALUE;
		this.nbTokens = DEFAULTTOKENVALUE;
		IDVALUE += 1;
	}

	/**
	 * @param nbTokens Constructor : initializes a place containing the number of
	 *                 tokens given as parameter.
	 */
	public Place(int token) {
		assert token > 0;
		this.nbTokens = token;
		this.id = IDVALUE;
		IDVALUE += 1;
	}

	/**
	 * @return nbTokens Retrieves the number of tokens.
	 */
	public int getNbToken() {
		return this.nbTokens;
	}

	/**
	 * @param nbTokens Sets the number of tokens.
	 */
	public void setToken(int nbTokens) {
		assert nbTokens > 0;
		this.nbTokens = nbTokens;
	}

	/**
	 * Returns a descriptive string of the place.
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("La place ");
		str.append(this.id);
		str.append(" possède ");
		str.append(this.nbTokens);
		str.append(" jetons.");

		return str.toString();
	}

}
