package studentCoursePlanner.state;

import java.util.ArrayList;
import java.util.HashMap;

import studentCoursePlanner.util.Results;
/**
 * Context class which facilitates following actions:
 * 1. Takes in the input from driver and parses into different courses
 * 2. Used to set the current state
 * 3. Has getters/setters for different states.
 * @author Kunal
 *
 */
public class studentCoursePlanner {

	CoursePlannerStateI HasCourses;
	CoursePlannerStateI HasElectives;
	CoursePlannerStateI HasGraduated;
	CoursePlannerStateI HasNotGraduated;
	CoursePlannerStateI HasPreferences;
	CoursePlannerStateI Allowed;
	CoursePlannerStateI NotAllowed;
	CoursePlannerStateI currentState;
	
	String course;
	public ArrayList<Character> courseList=new ArrayList<Character>();
	int Bnumber;
	int numberOfCourses;
	int counter;
	String type;
	public int done=0;
	
	HashMap<String,ArrayList<Character>> CourseMap=new HashMap<String,ArrayList<Character>>();
	HashMap<Character,String> waitMap=new HashMap<Character,String>();
    ArrayList<Character> finalList=new ArrayList<Character>();
	ArrayList<Character> waitList=new ArrayList<Character>();
	
	boolean isElective=false;
	public Results r;
	
	/**
	 * Constructor which takes in the input as a parameter and a result instance sent from the driver.
	 * The constructor also initializes all the categories in the Hashmap and sets the current state as HasPreferences
	 * @param courseIn
	 * @param rIn
	 */
	public studentCoursePlanner(String courseIn,Results rIn){
		
		HasCourses = new HasCourses(this);
		HasElectives=new HasElectives(this);
		HasGraduated=new HasGraduated(this);
		HasNotGraduated=new HasNotGraduated(this);
		HasPreferences=new HasPreferences(this);
		Allowed=new Allowed(this);
		
		CourseMap.put("LongProgramming",null);
		CourseMap.put("DataStructures",null);
		CourseMap.put("DataAnalytics",null);
		CourseMap.put("Hardware",null);
		CourseMap.put("Electives", null);
		
		course=courseIn;
		r=rIn;
		if(courseIn==null)
			currentState=HasNotGraduated;
		else {
		currentState=HasPreferences;
		
		splitString(course);
		}
	}

	/**
	 * Method to split a space delimited string in various courses
	 * And add the courses to a course list.
	 * @param input
	 */
	public void splitString(String input) {
		
		String arr[]=input.split(":");
		Bnumber=Integer.parseInt(arr[0]);
		String list=arr[1];
		list=list.trim();
		String arr1[]=list.split(" ");
		
		for(int i=0;i<arr1.length;i++) {
				courseList.add(arr1[i].charAt(0));
		}
		numberOfCourses=courseList.size();
	}
	/**
	 * Executes the checkCourses method of the current state
	 * @param course
	 */
	public void checkCourses(char course) {
		currentState.checkCourses(course);
	}
/**
 * Execute the checkElectives method of the current stage
 * @param course
 */
	public void checkElectives(char course) {
		currentState.checkElectives(course);
	}
	/**
	 * Executes the checkAllowed method of the current state
	 * @param course
	 */
	public void checkAllowed(char course) {
		currentState.checkAllowed(course);
	}
	/**
	 * Executes the checkGrad method of the current stage
	 * @param course
	 */
	public void checkGrad(char course) {
		currentState.checkGrad(course);
	}
	/**
	 * Executes the isGrad method of the current stage
	 * @param course
	 */
	public void isGrad(char course) {
		currentState.isGrad(course);
	}
	
	/**
	 * Setter for the current state 
	 * @param currentState
	 */
	public void setCurrentState(CoursePlannerStateI currentState) {
		this.currentState=currentState;
	}
	/**
	 * Getter for the current state
	 * @return
	 */
	public CoursePlannerStateI getCurrentState() {
		return currentState;
	}
	/**
	 * Returns HasCourses state
	 * @return
	 */
	public CoursePlannerStateI getHasCourses() {
		return HasCourses;
	}
	/**
	 * Returns HasElectives state
	 * @return
	 */
	public CoursePlannerStateI getHasElectives() {
		return HasElectives;
	}
	/**
	 * Returns HasPreferences state
	 * @return
	 */
	public CoursePlannerStateI getHasPreferences() {
		return HasPreferences;
	}
	/**
	 * Returns Allowed state
	 * @return
	 */
	public CoursePlannerStateI getAllowed() {
		return Allowed;
	}
	/**
	 * Returns HasGraduated state
	 * @return
	 */
	public CoursePlannerStateI getHasGraduated() {
		return HasGraduated;
	}
	/**
	 * Returns HasNotGraduated state
	 * @return
	 */
	public CoursePlannerStateI getHasNotGraduated() {
		return HasNotGraduated;
	}
	public String toString() {
		return "Context class which has all states declared and getters for those states";
	}
}
