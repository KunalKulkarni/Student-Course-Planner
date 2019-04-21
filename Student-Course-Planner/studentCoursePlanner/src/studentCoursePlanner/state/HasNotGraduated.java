package studentCoursePlanner.state;
/**
 * Class to print courses of the student who has not graduated.
 * @author Kunal
 *
 */
public class HasNotGraduated implements CoursePlannerStateI {
	
	studentCoursePlanner scp;
	public HasNotGraduated(studentCoursePlanner studentCoursePlanner) {
		scp=studentCoursePlanner;
	}

	@Override
	public void checkCourses(char course) {
		// TODO Auto-generated method stub
		System.out.println("Student has not Graduated");
	}

	@Override
	public void checkElectives(char course) {
		// TODO Auto-generated method stub
		System.out.println("Student has not Graduated");
	}

	@Override
	public void checkAllowed(char course) {
		// TODO Auto-generated method stub
		System.out.println("Student has not Graduated");
	}

	@Override
	public void checkGrad(char course) {
		// TODO Auto-generated method stub
		System.out.println("Student has not Graduated");
	}

	@Override
	public void isGrad(char course) {
		// TODO Auto-generated method stub
		System.out.println("Not graduated");
		scp.r.setResult(scp.Bnumber+":"+scp.finalList+"  Will Not Graduate");
		scp.setCurrentState(scp.getHasPreferences());
	}

	public String toString()
	{
		return "HasNotGraduated class to conclude that the student has not graduated";
	}
}

