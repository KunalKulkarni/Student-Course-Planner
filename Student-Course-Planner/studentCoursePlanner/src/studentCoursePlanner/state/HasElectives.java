package studentCoursePlanner.state;

/**
 * Class to check if the course taken is an elective
 * @author Kunal
 *
 */
public class HasElectives implements CoursePlannerStateI{

	studentCoursePlanner scp;
	public HasElectives(studentCoursePlanner studentCoursePlanner) {
		scp=studentCoursePlanner;
	}

	/**
	 * Not a course, an elective
	 */
	@Override
	public void checkCourses(char course) {
		System.out.println("Checking for courses done");
	}
	/**
	 * If elective send to HasCourses state
	 */
	@Override
	public void checkElectives(char course) {
		// TODO Auto-generated method stub
		
		if(course>='Q' && course<='Z') {
			
			scp.isElective=true;
			scp.type="Electives";
			scp.setCurrentState(scp.getHasCourses());
			System.out.println("Elective "+course+" is checked");
		}
		else
			scp.setCurrentState(scp.getHasPreferences()); //Not a course or an elective
	}
	/**
	 *  Not valid course
	 */
	@Override
	public void checkAllowed(char course) {
		// TODO Auto-generated method stub
		System.out.println("Not a course or an elective");
	}


	@Override
	public void checkGrad(char course) {
		// TODO Auto-generated method stub
	}

	@Override
	public void isGrad(char course) {
		// TODO Auto-generated method stub		
	}

	public String toString() {
		return "HasElectives class to check if input is an Elective";
	}
	
}
