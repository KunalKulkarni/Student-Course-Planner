package studentCoursePlanner.state;

import java.util.ArrayList;

/**
 * HasCourses state called when a course/Elective is valid
 * 
 * @author Kunal
 *
 */
public class HasCourses implements CoursePlannerStateI{

	studentCoursePlanner scp;
	public HasCourses(studentCoursePlanner studentCoursePlanner) {
		scp=studentCoursePlanner;
	}

	/**
	 * Course is valid but not allowed
	 */
	@Override
	public void checkCourses(char course) {
		// TODO Auto-generated method stub
		System.out.println("Checking for courses done");
	}
	/**
	 * Not an elective
	 */
	@Override
	public void checkElectives(char course) {
		// TODO Auto-generated method stub
		System.out.println("Course "+course+" will be checked");
	}

	/**
	 * Check if course is allowed
	 * Check if pre-requisites have been satisfied
	 * Check for waitlist
	 */
	@Override
	public void checkAllowed(char course) {
		
		String type=scp.type;
		
		if(scp.isElective==true) {
	
			ifElective(type, course); // If it is an elective add it, order does not matter
		}
		
		else {
			
			if(scp.CourseMap.get(type)==null)
			{
				ifMapEmpty(type,course); // If Arraylist of the type is empty, add the course
			}

			else if(scp.CourseMap.get(type)!=null){
				
				addifAllowed(type,course);	// If not empty, check if it is in alphabetic order
			}
		}
		
			if(scp.waitList.isEmpty()==false) {
			
				checkWaitlist(); //Check if elements from a waitlist can be added 

			}
		
		scp.setCurrentState(scp.getAllowed());
	}

  /**
 *  If it is an elective put it in the Elective arraylist.
 * @param type Category of course
 * @param course 
 */
	void ifElective(String type,char course) {
		
		scp.finalList.add(course);
		
		if(scp.CourseMap.get(type)==null) {
		ArrayList<Character> elect=new ArrayList<Character>();
		elect.add(course);
		scp.CourseMap.put(type,elect);
		}
		else 
			scp.CourseMap.get(type).add(course);
		
		scp.isElective=false;
	}
	/**
	 * If the corresponding arraylist of the category is empty add the course
	 * If it is any of the last courses in the categories add them to the waitlist.
	 * @param type
	 * @param course
	 */
	void ifMapEmpty(String type,char course) {
		if(course=='D' || course=='H' || course=='L' || course=='P') {
			scp.waitList.add(course);	
			scp.waitMap.put(course,type);
		}
		else {

			scp.finalList.add(course);
			ArrayList<Character> arr=new ArrayList<Character>();
			arr.add(course);
			scp.CourseMap.put(type,arr);
			
			}	
	}
	/**
	 * If the course does not fulfill the alphabetical order requirement place it in the waitlist
	 * @param type
	 * @param course
	 */
	void addifAllowed(String type,char course) {
		
		int size=scp.CourseMap.get(type).size();
		ArrayList<Character> list=scp.CourseMap.get(type);
		int cnt=0;
		for(int i=0;i<size;i++) {
		if(course>list.get(i)) {
			cnt++;
			}
		}
		if(cnt==size) {
		scp.CourseMap.get(type).add(course);
		scp.finalList.add(course);  //Add to final list if requirement fulfilled
		}
	else 
		scp.waitList.add(course); //Else add to the waitlist
		scp.waitMap.put(course, type);
	}
	/**
	 * Check if any element in waitlist can be added
	 */
	void checkWaitlist() {
		
		for(int i=0;i<scp.waitList.size();i++) {
			
			char waitCourse=scp.waitList.get(i);
			String waitType=scp.waitMap.get(waitCourse); //Get category of course in the waitlist
			
			ArrayList<Character> wlist=scp.CourseMap.get(waitType);
			
			if(wlist!=null) {
				
				if(wlist.get(wlist.size()-1)<waitCourse || wlist.size()>=2) {
					
					scp.finalList.add(waitCourse); //Add if criteria is fulfilled
					scp.waitMap.remove(waitCourse);
					scp.waitList.remove(i);
					scp.CourseMap.get(waitType).add(waitCourse);					
					
				}
			}
			
		}
	}
	
	/**
	 * Course is not allowed
	 */
	@Override
	public void checkGrad(char course) {
		// TODO Auto-generated method stub
		System.out.println("Course/Elective not allowed");
	}

	/**
	 * Not graduated yet
	 */
	@Override
	public void isGrad(char course) {
		// TODO Auto-generated method stub
		System.out.println("Not graduated");
	}

public String toString() {
	return "HasCourses class to check if the course/elective is allowed";
}
}
