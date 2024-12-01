import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arr= new ArrayList<>();
		
		try {
			File myObj= new File("C:\\Users\\Alex\\Desktop\\input.txt"); //Loading Data
			Scanner myReader= new Scanner(myObj);
			while(myReader.hasNextLine()) {
				String data= myReader.nextLine();
				String arr2[]= new String[1]; //using array to split elements
				//System.out.println(data);	
				arr2=(data.split("   "));
				for(int i=0;i<2;i++) {
					arr.add(arr2[i]); //adding the splitted elements
				}
			}
			myReader.close();
		}catch(FileNotFoundException e) {
			System.out.println("An error occurred");
			e.printStackTrace();
		}
		ArrayList<Integer> list1= new ArrayList<>();
		ArrayList<Integer> list2= new ArrayList<>();
		//separating in two array lists
		for (int i=0;i<arr.size();i++) {
			if(i%2==0) {
				list1.add(Integer.parseInt(arr.get(i)));
			}
			else {
				list2.add(Integer.parseInt(arr.get(i)));
			}	
		}
		//PROBLEM 2 SOLUTION
		ArrayList<Integer> freq=new ArrayList<>();
		int frequency;
		for(int i=0;i<list1.size();i++) {
			frequency=0;
			for(int j=0;j<list2.size();j++) {
				if(list1.get(i).equals(list2.get(j))) {
					System.out.println("Entered");
					frequency++;
				}
				
			}
			freq.add(frequency);
		}
		for(int i=0;i<freq.size();i++) {
			freq.set(i, (list1.get(i)*freq.get(i)));
		}
		int sum=0;
		for(int i=0;i<freq.size();i++) {
			sum= sum+freq.get(i);
		}
		System.out.println(" "+sum);
		//PROBLEM 1 SOLUTION
		bubbleSort(list1);
		bubbleSort(list2);
		ArrayList<Integer>distances= new ArrayList<>();
		for(int i=0;i<list1.size();i++) {
			distances.add(Math.abs(list1.get(i)-list2.get(i)));
		}
		int sum2=0;
		for(int i=0;i<distances.size();i++) {
			sum2= sum2+ distances.get(i);
		}
		System.out.println(" "+sum2);	
	}
	public static void bubbleSort(ArrayList<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // To optimize, track if swapping happened
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    // Swap list[j] and list[j + 1]
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            // If no two elements were swapped, the list is sorted
            if (!swapped) break;
        }
    }
}
