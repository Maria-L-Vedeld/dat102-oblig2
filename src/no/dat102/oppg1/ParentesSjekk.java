package no.dat102.oppg1;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParentesSjekk {
	
	public static boolean sjekkParenteser(String s) {
		//sjekk om parentesene inneholder korrekte parentespar,
		//altså at alle startparenteser har matchende sluttparenteser
		//(og omvendt), og at rekkefølgen er riktig.
		//
	
		Deque<Character> stabel = new ArrayDeque<>();
		
		for (char c : s.toCharArray()) {
			if (erParentes(c)) {
				if (erForste(c)) {
					stabel.push(c);
				}
			else {
				if (stabel.isEmpty() || !match(stabel.pop(), c)) {
					return false;
				}
			}}
			
			
		}return stabel.isEmpty();
		
		
	}
	
	private static boolean erForste(char c) {
		return c == '{' || c == '[' || c == '<' || c == '(';		
	}
	
	private static boolean erParentes(char c) {
		return c == '{' || c == '}' || c == '[' || c == ']' ||
				c == '<' || c == '>' || c == '(' || c == ')';
		
	}
	
	private static boolean match(char open, char close) {
		return (open == '{' && close == '}') ||
				(open == '[' && close == ']') ||
				(open == '<' && close == '>') ||
				(open == '(' && close == ')');
	}
	

}







