package studentCoursePlanner.driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import studentCoursePlanner.state.studentCoursePlanner;
import studentCoursePlanner.util.FileProcessor;
import studentCoursePlanner.util.Results;

/**
 * Driver code which facilitates following actions:
 * 1.Validation of Command Line Arguments
 * 2.Process the input file and send the data to Context class
 * 3.Run all functions for each course from the List
 * 4.Write the corresponding result to the output file.
 * @author Kunal
 *
 */
public class Driver {
		
	
	/**
	 * Function to check if the command line arguments are valid or not.
	 * @param arr - Array of command line arguments.
	 */
	static void argCheck(String arr[]){
		
			for(int i=0;i<arr.length;i++){
				
				if(arr.length!=2){
					
					System.err.println("Invalid Number of Arguments.Enter 2 Arguments- Input Output");
					System.exit(1);
				}
				if(arr[i].contains("${")){
					
				System.err.println("Invalid Entry.Enter 2 Arguments- Input Output");
				System.exit(1);
			}
			}
		}
		/**
		 * Function to check if the input file exists.
		 * @param filename - input file. 
		 */
	static void fileCheck(String filename){
		
		File file=new File(filename);
		if(file.exists()==false){
			
			System.err.println(filename+ "File does not exist. Please Enter a valid filename/path");
			System.exit(1);
		}
	}
	/**
	 * Main function to send file to context and then all the courses through the states	
	 * @param args
	 */
	public static void main(String[] args) {
		
			argCheck(args);
			String inputFile=args[0];
			String outputFile=args[1];
			fileCheck(inputFile);
			//fileCheck(outputFile);
			
			ArrayList<String> courses=new ArrayList<String>();
			FileProcessor fp=new FileProcessor(inputFile);
			String line=null;
			line=fp.readLine();
			Results r=new Results();
			studentCoursePlanner scp=new studentCoursePlanner(line,r);
			ArrayList<Character> list=scp.courseList;
			
			for(int i=0;i<list.size() && scp.done==0;i++) {
				
				char c=list.get(i);
				scp.checkCourses(c);
				scp.checkElectives(c);
				scp.checkAllowed(c);
				scp.checkGrad(c);
				scp.isGrad(c);
			}
			
			r.write(outputFile);
			r.debwrite();
		}

		
	public String toString() {
		return "Driver code that send the input file to Context class and then on to different States";
	}

}
