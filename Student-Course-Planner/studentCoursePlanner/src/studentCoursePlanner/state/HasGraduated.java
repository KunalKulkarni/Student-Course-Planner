package studentCoursePlanner.state;

import java.util.ArrayList;
/**
 * Class to print out the number of semesters taken by the student to graduate.
 * @author Kunal
 *
 */
public class HasGraduated implements CoursePlannerStateI {

	studentCoursePlanner scp;
	public HasGraduated(studentCoursePlanner studentCoursePlanner) {
		// TODO Auto-generated constructor stub
		scp=studentCoursePlanner;
	}

	
	@Override
	public void checkCourses(char course) {
		// TODO Auto-generated method stub
		System.out.println("Student has Graduated");
	}

	@Override
	public void checkElectives(char course) {
		// TODO Auto-generated method stub
		System.out.println("Student has Graduated");
	}

	@Override
	public void checkAllowed(char course) {
		// TODO Auto-generated method stub
		System.out.println("Final List of courses made");
	}


	@Override
	public void checkGrad(char course) {
		// TODO Auto-generated method stub
		System.out.println("Student has graduated");
		
	}

	@Override
	public void isGrad(char course) {
		// TODO Auto-generated method stub
		
		int semesters=0;
		int size=scp.finalList.size();
		if(size%3==0) {
			semesters=size/3;
		}
		else
			semesters=size/3+1;
		
		String list=scp.finalList.toString();
		scp.r.setResult(scp.Bnumber+":"+list+"-"+semesters);// Number of Semesters sent to file 
		scp.done=1;
		scp.setCurrentState(scp.getHasPreferences());//Return to base state
	}

	public String toString() {
		return "HasGraduated class to calculate the number of semesters taken to graduate";
	}

}
