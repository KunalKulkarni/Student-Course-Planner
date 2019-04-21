package studentCoursePlanner.state;

/**
 * Interface to declare all the actions used by the different states
 * @author Kunal
 *
 */
public interface CoursePlannerStateI {

	
	public void checkCourses(char course);
	public void checkElectives(char course);
	public void checkAllowed(char course);
	public void checkGrad(char course);
	public void isGrad(char course);
}
