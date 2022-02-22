package wordle;

public class Guess {

	protected char[] info = new char[5];
	protected String input;
	
	
	public static void main(String[] args) {
		Guess g = new Guess();
		g.input("whoop","diddl");
		System.out.println(g);
	}
	public Guess() {
		for (int i = 0; i < 5; i++) info[i] = 'x';
	}
	
//	public Guess(String input) {
//		this();
//		input(input);
//	}
//	
//	public Guess (String input, String word) {
//		this(input);
//		calcInfo(word);
//	}
	
	public void input (String input,String word) {
		if (input.length()<5) {
			int len = input.length();
			for (int i=0;i < 5-len;i++) input+=" ";
		}
		this.input = input;
		calcInfo(word);
	}
	
	public void calcInfo(String word) {
		int edge = 5;
		for (int i = 0; i < edge; i++) {
			char letter = input.toLowerCase().charAt(i);
			int numletter = 0;
			//calculates the number of times letter appears in final word
			for (int w = 0; w < edge; w++) {
				if (letter==word.charAt(w)) numletter++;
			}
			int inputno = 0;
			//calculates how many times the letter has appeared so far in input.
			for (int w = 0; w < i; w++) {
				if (letter==input.charAt(w)) inputno++;
			}
			/*
			 * issue with this is that if theres a green. so final word:"sswww" input word:"wwwwq" 
			 * positions1,2 will be yellow, 3 and 4 will be green. indicating theres 4 w's when there's only actually 3
			 */
			if (word.indexOf(letter)>-1 && inputno<numletter) { 
				info[i] = 'y';
			}
			if (letter == word.charAt(i)) info[i] = 'g';	
		}	
	}
	
	public boolean isCorrect() {
		for (char c : info) {
			if (c!='g') return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		String r = ":  ";
		for (char a : info) {
			r += a;
		}
		r += "  :  " + ((input==null)?(""):(input));
		return r;
	}
}
