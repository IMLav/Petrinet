package reseau_petri;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
class Place {
	private static final int DEFAULTTOKENVALUE =0;
	private static int DEFAULTIDVALUE =1 ;
	private int token;
	private int id;
	
		public Place() {
			this.id = DEFAULTIDVALUE;
			this.token = DEFAULTTOKENVALUE;
			DEFAULTIDVALUE +=1;
		}
		public Place(int token) {
			assert token > 0;
			this.token = token;
			this.id = DEFAULTIDVALUE;
			DEFAULTIDVALUE +=1;
		}
		
		public int getToken() {
			return this.token;
		}
		
		public void setToken(int token) {
			assert token >0; // est-ce vraiment utile vu que c'est dans le constructeur ? à tester
			this.token = token;
		}
		
		public String toString() {
			return ("La place "+this.id+" possède "+this.token+" jetons."+Petrinet.Newline);
		}
		
		
}
