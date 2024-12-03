import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
public class Solution_three {

	public static void main(String[] args) {
		String path="C:\\Users\\Alex\\Desktop\\mul.txt";
		try {
			String CorMem= new String(Files.readAllBytes((Paths.get(path)))); //loading data onto string variable
			Pattern pattern= Pattern.compile("mul\\((\\d+),(\\d+)\\)"); //filtering for the the mul(x,y) format
			Pattern doPattern = Pattern.compile("do\\(\\)"); //filtering for do()
	        Pattern dontPattern = Pattern.compile("don't\\(\\)");//filtering for don't()
			Matcher matcher= pattern.matcher(CorMem); //applying for our file
			boolean mulEnabled = true; // initially, mul instructions are enabled
			int sum=0;
			
			for(int i=0;i<CorMem.length();) {
				if(CorMem.startsWith("do()",i)){
					mulEnabled=true;
					i += 4; //passing "do()"
				}else if (CorMem.startsWith("don't()",i)) {
					mulEnabled=false;
					i+= 7; //passing "don't()"
				}
				//checking for mul(x,y)
				else if(matcher.find(i) && matcher.start() == i) {
					if(mulEnabled) {
						int x= Integer.parseInt(matcher.group(1)); //extracting numbers
						int y= Integer.parseInt(matcher.group(2));
						sum+=x*y; //adding multiplication product to sum
					}
					i=matcher.end();//passing mul(x,y)
				}else {
					//no matcher were found so we are moving the index
					i++;
				}
			}
			//SOLUTION TO N1
			/*while(matcher.find()) { //iterate through all matches
				try {
					int x= Integer.parseInt(matcher.group(1)); //extracting numbers
					int y= Integer.parseInt(matcher.group(2));
					sum+=x*y; //adding multiplication product to sum
				}catch(NumberFormatException e) {
					System.err.println("Error parsing numbers: " + e.getMessage());
				}
			}*/
			System.out.println("Sum: "+sum);
		}catch(IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
		}
	}

}
