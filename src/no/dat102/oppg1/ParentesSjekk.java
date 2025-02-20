package no.dat102.oppg1;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParentesSjekk {
	
	public static boolean sjekkParenteser(String s) {
		//sjekk om parentesene inneholder korrekte parentespar,
		//altså at alle startparenteser har matchende sluttparenteser
		//(og omvendt), og at rekkefølgen er riktig.
		//
		//split strengen og sjekk element for element. 
		//sjekk først om strengen er delelig med to, hvis den er det vil den også
		//ha et likt antall parenteser
		//sjekk så første i første del og siste i siste del, og jobb innover.
		
		
		Deque<Character> stabel = new ArrayDeque<>();
		for (char c : s.toCharArray()) {
			if (erForste(c)) {
				stabel.push(c);
			}else {
				if (stabel.isEmpty() || !match(stabel.pop(), c)) {
					return false;
				}
			}
			
			
		}return stabel.isEmpty();
		
		
	}
	
	private static boolean erForste(char c) {
		return c == '{' || c == '[' || c == '(';
		
	}
	
	private static boolean match(char open, char close) {
		return (open == '{' && close == '}') ||
				(open == '[' && close == ']') ||
				(open == '<' && close == '>') ||
				(open == '(' && close == ')');
	}
	
	public static void main (String [] args) {
		System.out.println(sjekkParenteser("{[()]}"));
	}

}

/*MÅ GJØRE NOEN ENDRINGER, DEN TAR IKKE HØYDE FOR ANDRE SYMBOLER ENN DE
 * SOM ER I KODEN. DEN MÅ KUNNE SKILLE PÅ DET SOM ER PARENTES OG DET SOM IKKE
 * ER ET PARENTES!!  
 * 
 * 
 * 
 */








