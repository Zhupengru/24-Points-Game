//24 point automation calculator
import java.text.DecimalFormat;
import java.util.*;
public class Point24 {
	static char[] operator = {'+','-','*','/'};
	static boolean found = false;
	public static void main(String[] args){
		double target = 24.0;
		double[] nums = {8,7,3,2};
		//System.out.println(Double.parseDouble(new DecimalFormat("##.##").format(nums[2]/(nums[0]-nums[3]/nums[1]))));
		
		for(int i = 0; i < 4; i++) {
			nums[i] = (int)(Math.random() * 13 + 1);
			System.out.print((int)(nums[i])+" ");
		}
		System.out.println();
		ArrayList<Double> initialRemain = new ArrayList<Double>();
		ArrayList<Double> initialPut = new ArrayList<Double>();
		for(int i = 0; i < 4; i++)
			initialRemain.add(nums[i]);
		
		recursionTry(initialRemain, initialPut);
		if (!found) System.out.print("No Way");
		//calculate(initialRemain);
	}
	public static void recursionTry(ArrayList<Double> remain, ArrayList<Double> put){
		if (put.size() == 4){
			if(calculate(put)) found = true;
			return;
		}
		if(found) return;
		int size = remain.size();
		for (int i = 0; i < size; i++){
			put.add(remain.get(i));
			remain.remove(i);
			recursionTry(remain, put);
			remain.add(put.get(put.size()-1));
			put.remove(put.size()-1);
		}
	}
	public static boolean calculate(ArrayList<Double> put){
		boolean getResult = false;
		double result;
		double result1;
		
		
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				for (int k = 0; k < 4; k++){
					//in order
					result = put.get(0);
					if(operator[i] == '+') result += put.get(1);
					if(operator[i] == '-') result -= put.get(1);
					if(operator[i] == '*') result *= put.get(1);
					if(operator[i] == '/') result /= put.get(1);
					
					if(operator[j] == '+') result += put.get(2);
					if(operator[j] == '-') result -= put.get(2);
					if(operator[j] == '*') result *= put.get(2);
					if(operator[j] == '/') result /= put.get(2);
					
					if(operator[k] == '+') result += put.get(3);
					if(operator[k] == '-') result -= put.get(3);
					if(operator[k] == '*') result *= put.get(3);
					if(operator[k] == '/') result /= put.get(3);
					
					result = Double.parseDouble(new DecimalFormat("##.##").format(result));
					if(result == 24.0) {
						System.out.println("((("+(put.get(0))+" "+operator[i]+" "+put.get(1)+")"+operator[j]+put.get(2)+")"+operator[k]+put.get(3)+")");
						return(true);
					}
					
					
					//first three numbers
					result = put.get(0);
					if ((operator[j] == '*' || operator[j] == '/') && (operator[i] == '+' || operator[i] == '-')){
						if (operator[j] == '*' && operator[i] == '+') result += put.get(1) * put.get(2);
						if (operator[j] == '*' && operator[i] == '-') result -= put.get(1) * put.get(2);
						if (operator[j] == '/' && operator[i] == '+') result += put.get(1) / put.get(2);
						if (operator[j] == '/' && operator[i] == '-') result -= put.get(1) / put.get(2);
						if(operator[k] == '+') result += put.get(3);
						if(operator[k] == '-') result -= put.get(3);
						if(operator[k] == '*') result *= put.get(3);
						if(operator[k] == '/') result /= put.get(3);
						result = Double.parseDouble(new DecimalFormat("##.##").format(result));
						if(result == 24.0) {
							System.out.println("(("+(put.get(0))+" "+operator[i]+" ("+put.get(1)+operator[j]+put.get(2)+"))"+operator[k]+put.get(3)+")");
							return(true);
						}
					}
					
					
					
					//last three numbers
					result = put.get(0);
					result1 = put.get(1);
					if ((operator[k] == '*' || operator[k] == '/') && (operator[j] == '+' || operator[j] == '-')){
						if (operator[k] == '*' && operator[j] == '+') result1 += put.get(2) * put.get(3);
						if (operator[k] == '*' && operator[j] == '-') result1 -= put.get(2) * put.get(3);
						if (operator[k] == '/' && operator[j] == '+') result1 += put.get(2) / put.get(3);
						if (operator[k] == '/' && operator[j] == '-') result1 -= put.get(2) / put.get(3);
						if(operator[i] == '+') result += result1;
						if(operator[i] == '-') result -= result1;
						if(operator[i] == '*') result *= result1;
						if (result1 != 0)
						if(operator[i] == '/') result /= result1;
						result = Double.parseDouble(new DecimalFormat("##.##").format(result));
						if(result == 24.0) {
							System.out.println("("+(put.get(0))+" "+operator[i]+" ("+put.get(1)+operator[j]+"("+put.get(2)+operator[k]+" "+put.get(3)+")))");
							return(true);
						}
					} 
					else{
						if(operator[j] == '+') result1 += put.get(2);
						if(operator[j] == '-') result1 -= put.get(2);
						if(operator[j] == '*') result1 *= put.get(2);
						if(operator[j] == '/') result1 /= put.get(2);
						
						if(operator[k] == '+') result1 += put.get(3);
						if(operator[k] == '-') result1 -= put.get(3);
						if(operator[k] == '*') result1 *= put.get(3);
						if(operator[k] == '/') result1 /= put.get(3);
						
						if(operator[i] == '+') result += result1;
						if(operator[i] == '-') result -= result1;
						if(operator[i] == '*') result *= result1;
						if (result1 != 0)
						if(operator[i] == '/') result /= result1;
						result = Double.parseDouble(new DecimalFormat("##.##").format(result));
						if(result == 24.0) {
							System.out.println("("+(put.get(0))+" "+operator[i]+" ("+put.get(1)+" "+operator[j]+" "+put.get(2)+operator[k]+" "+put.get(3)+"))");
							return(true);
						}
					}
					
					
					//first two last two
					result = put.get(0);
					result1 = put.get(2);
			
					if(operator[i] == '+') result += put.get(1);
					if(operator[i] == '-') result -= put.get(1);
					if(operator[i] == '*') result *= put.get(1);
					if(operator[i] == '/') result /= put.get(1);
					if(operator[k] == '+') result1 += put.get(3);
					if(operator[k] == '-') result1 -= put.get(3);
					if(operator[k] == '*') result1 *= put.get(3);
					if(operator[k] == '/') result1 /= put.get(3);
					if(operator[j] == '+') result += result1;
					if(operator[j] == '-') result -= result1;
					if(operator[j] == '*') result *= result1;
					if (result1 != 0)
					if(operator[j] == '/') result /= result1;
					result = Double.parseDouble(new DecimalFormat("##.##").format(result));
					if(result == 24.0) {
						System.out.println("("+(put.get(0))+" "+operator[i]+" "+put.get(1)+" ) "+operator[j]+" ( "+put.get(2)+operator[k]+" "+put.get(3)+")");
						return(true);
					}
					
					result = put.get(0);
					result1 = put.get(2);
				}
			}
		}
		return getResult;
	}
}
