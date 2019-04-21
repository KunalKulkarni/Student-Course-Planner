package studentCoursePlanner.state;

/**
 * Initial state which checks if course entered is a course in a category or an elective
 * @author Kunal
 *
 */
public class HasPreferences implements CoursePlannerStateI {

	studentCoursePlanner scp;
	public HasPreferences(studentCoursePlanner studentCoursePlanner) {
		// TODO Auto-generated constructor stub
		scp=studentCoursePlanner;
	}
	/**
	 * Checks if course belongs to one of the categories else send to the Has Elective state
	 */
	@Override
	public void checkCourses(char course) {
		// TODO Auto-generated method stub
		
		scp.counter++;
		if(course>='A' && course<='P') {
			
			scp.setCurrentState(scp.getHasCourses());
			
			if(course>='A' && course<='D')
				scp.type="LongProgramming";
			if(course>='E' && course<='H')
				scp.type="DataStructures";
			if(course>='I' && course<='L')
				scp.type="Hardware";
			if(course>='M' && course<='P')
				scp.type="DataAnalytics";
			
		}
		else 
			scp.setCurrentState(scp.getHasElectives());
	}
	@Override
	public void checkElectives(char course) {
		// TODO Auto-generated method stub
		System.out.println("Neither a course, nor an elective");
		
	}	
	@Override
	public void checkAllowed(char course) {
		// TODO Auto-generated method stub
		System.out.println("Invalid Course/Elective");
	}
	
	@Override
	public void checkGrad(char course) {
		// TODO Auto-generated method stub
		System.out.println("Course/Elective not allowed");
		
	}
	@Override
	public void isGrad(char course) {
		// TODO Auto-generated method stub
		System.out.println("Not graduated yet");
	}

	public String toString() {
		return "Class to check if course has been entered or else send to check for Elective";
	}
}
