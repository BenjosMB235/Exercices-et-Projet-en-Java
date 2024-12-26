 package Pile;

import java.util.Stack;

public class VerificateurParentheses {
	public static boolean sontParenthesesEquilibrees(String expression){
		Stack<Character> pile=new Stack<>();
		
		for(char caractere : expression.toCharArray()){
			if(caractere == '(' || caractere == '{' || caractere == '['){
				pile.push(caractere);
			}else if(caractere == ')' || caractere == '}' || caractere == ']'){
				if(pile.isEmpty()){
					return false;
				}
				char sommet = pile.pop();
				if(!correspond(sommet, caractere)){
					return false;
				}
			}
		}
		
		return pile.isEmpty();
	}
	
	private static boolean correspond(char ouvrante, char fermante){
		return(ouvrante == '(' && fermante == ')') || (ouvrante == '{' && fermante == '}') || (ouvrante == '[' && fermante ==']');
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] expressions={
				"(a+b)*(c-d)",
				"((a+b)",
				"({[a+b]}-c)",
				"(a+b]",
				""
		};
		
		for(String expression : expressions){
			System.out.println("Expression : \""+expression+"\"");
			if(sontParenthesesEquilibrees(expression)){
				System.out.println("->Equilibrée ☻");
			}else{
				System.out.println("-> Non équilibrée X");
			}
			System.out.println();
		}
	}

}
