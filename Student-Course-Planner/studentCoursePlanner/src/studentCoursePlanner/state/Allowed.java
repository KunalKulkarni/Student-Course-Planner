package studentCoursePlanner.state;

import java.util.ArrayList;

/**
 * Allowed class state when a course is allowed
 * If graduated send to graduated state else not graduated state
 * @author Kunal
 *
 */
public class Allowed implements CoursePlannerStateI{

	studentCoursePlanner scp;
	public Allowed(studentCoursePlanner studentCoursePlanner) {
		// TODO Auto-generated constructor stub
		scp=studentCoursePlanner;
	}

	/**
	 * Courses have already been checked
	 */
	@Override
	public void checkCourses(char course) {
		// TODO Auto-generated method stub
	 System.out.println("Course is valid");
	}

	/**
	 * Electives also checked
	 */
	@Override
	public void checkElectives(char course) {
		// TODO Auto-generated method stub
		System.out.println("Elective check done");
	}

	/**
	 * Course not allowed
	 */
	@Override
	public void checkAllowed(char course) {
		// TODO Auto-generated method stub
		System.out.println("Course/Elective not allowed");
	}


	/**
	 * Check if Graduation criteria is fulfilled
	 * If not,go to the next course
	 */
	@Override
	public void checkGrad(char course) {
		
		ArrayList<Character> longProgramming=scp.CourseMap.get("LongProgramming");
		ArrayList<Character> DataStructures=scp.CourseMap.get("DataStructures");
		ArrayList<Character> Hardware=scp.CourseMap.get("Hardware");
		ArrayList<Character> DataAnalytics=scp.CourseMap.get("DataAnalytics");
		ArrayList<Character>Electives=scp.CourseMap.get("Electives");

		if(longProgramming!=null && DataStructures!=null && Hardware!=null && DataAnalytics!=null && Electives!=null ) {
		
		if(longProgramming.size()>=2 && DataStructures.size()>=2 && Hardware.size()>=2 && DataAnalytics.size()>=2 
				&& Electives.size()>=2) {
			
			scp.setCurrentState(scp.getHasGraduated());	//Criteria satisfied
			
		
		}
		else if(scp.counter==scp.numberOfCourses) {
			scp.setCurrentState(scp.getHasNotGraduated()); //End of File, Criteria not satisfied
	
		}
		else
			scp.setCurrentState(scp.getHasPreferences()); //Not Graduated yet
		
	}
		else if(scp.counter==scp.numberOfCourses)
			scp.setCurrentState(scp.getHasNotGraduated()); //End of File,Not Graduated
		
		else
			scp.setCurrentState(scp.getHasPreferences()); //End of File, Go to the next course
	}

	@Override
	public void isGrad(char course) {
	}


	public String toString() {
		
		return "Allowed class to check if student has graduated or not";
	}
}
