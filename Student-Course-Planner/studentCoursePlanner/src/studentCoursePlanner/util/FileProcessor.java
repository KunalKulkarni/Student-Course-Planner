package studentCoursePlanner.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

	String filename;
	BufferedReader br;
	FileReader fr;
	/**
	 * 
	 * @param filenameIn - Input filename to be processed on.
	 */
	public FileProcessor(String filenameIn){
		
		if(filenameIn!=null){
			
			filename=filenameIn;
			File f=new File(filename);
			try {
				fr=new FileReader(f);
				br=new BufferedReader(fr);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	/**
	 * Function to read a line from the file and return it to the Driver.
	 * @return
	 */
	public String readLine(){
		
		String str=null;
		try {
			str=br.readLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
public String toString() {
	String s="Processing on file-"+filename;
	return s;
}
}
