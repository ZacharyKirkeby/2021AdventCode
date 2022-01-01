package days;

import java.util.ArrayList;

public class Day8Clock {
	private String[] signals;
	private String[] outputs;
	private int count;
	
	
	public Day8Clock(String words) {
		
		signals = words.substring(0, words.indexOf("|")).split(" ");
		outputs = words.substring(words.indexOf("|") + 2).split(" ");
		//translate();
		translateAllOutput();
		
	}
	
	public void translate() {
		for(int i = 0; i < outputs.length; i++) {
			String temp = outputs[i];
			
			if(temp.length() == 2) {
				//codes[1] = temp;
				count++;
				
			}else if(temp.length() == 4) {
				//codes[4] = temp;
				count++;
			}else if(temp.length() == 3) {
				//codes[7] = temp;
					count++;
			}else if(temp.length() == 7) {
				//codes[8] = temp;
					count++;
			}
			
			
		}

		
	}
	
	
	public void translateAllOutput() {
		String outputTotal = "";
		for(int i = 0; i < outputs.length; i++) {
			String temp = outputs[i];
			if(temp.length() == 6) {
				if(temp.indexOf('f') == -1) {
					outputTotal+="0";
				}else if(temp.indexOf('a')== -1 ) {
					outputTotal+="6";
				}else
					outputTotal+="9";
			}else if(temp.length() == 2) {
				outputTotal+="1";
			}else if(temp.length() == 4) {
				outputTotal+="4";
			}else if(temp.length() == 3) {
				outputTotal+="7";
			}else if(temp.length() == 7) {
				outputTotal+="8";
			}else if(temp.length() == 5) {
				if(temp.indexOf('e') > -1) {
					outputTotal+="5";
				}else if(temp.indexOf('g') == -1) {
					outputTotal+="3";
				}else
					outputTotal+="2";
			}
		}
		System.out.println(outputTotal);
		count = Integer.parseInt(outputTotal);
	}
	
	public int getCount() {
		return count;
	}
	
}
	