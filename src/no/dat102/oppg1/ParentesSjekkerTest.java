package no.dat102.oppg1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParentesSjekkerTest {
	
	    @Test
	    void testGyldigeParenteser() {
	        assertTrue(ParentesSjekk.sjekkParenteser("{ [ ( ) ] }")); 
	        	        
	    }

	    @Test
	    void testUgyldigeParenteser() {
	        assertFalse(ParentesSjekk.sjekkParenteser("{[(])}")); 
	        assertFalse(ParentesSjekk.sjekkParenteser("{ [ ( ) }")); 
	        assertFalse(ParentesSjekk.sjekkParenteser("[ ( ) ] }"));
	        assertFalse(ParentesSjekk.sjekkParenteser("{ [ ( ] ) }"));
	       
	    }


	    @Test
	    void testKombinasjonAvSymbolerOgParenteser() {
	        String javaprog = """
	        class HelloWorld {
	            public static void main(String[] args) {
	                System.out.println("Hello World!"); 
	            }
	        }
	        """;
	        assertTrue(ParentesSjekk.sjekkParenteser(javaprog)); 
	    }
	}

