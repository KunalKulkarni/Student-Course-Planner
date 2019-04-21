## To clean:
ant -buildfile studentCoursePlanner/src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile studentCoursePlanner/src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 

ant -buildfile studentCoursePlanner/src/build.xml run -Darg0=input.txt -Darg1=output.txt 

-----------------------------------------------------------------------


"I have done this assignment completely on my own. I have not copied it, nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating I will have to sign an official form that I have cheated and that this form will be stored in my official university record. I also understand that I will receive a grade of 0 for the involved assignment for my first offense and that I will receive a grade of F for the course for any additional offense.”

[Date: ] -- 03/13/2018

-----------------------------------------------------------------------

Implementation of the State Pattern:

The Pattern starts with the default state of HasPreferences, and checks if the course entered belongs to a category or is an elective by going to HasElectives state if elective.If not either, it returns to HasPreferences state to consider the next course. Then the valid course/elective go to the HasCourses state which checks if the course is allowed and also checks for elements in the waitlist. If course is not allowed it goes inside the waitlist. After every course is added/not added it checks if the student has graduated by going to the Allowed state,if graduated, student is sent to the HasGraduated state else next course is checked. If at the end of file the student has not graduated s(he) is sent to the HasNotGraduated state. Finally the result is printed and initial state of HasPreferences is restored.

Waitlist Implementation: 

The waitlist is checked after every course from the list is checked. As soon as a pre-requisite has been fulfilled for a course in the waitlist the course gets added to the final list and removed from the waitlist.If only D is chosen in the list the student will never graduate and D will never be taken.


A hashmap of the course in the waitlist and its corresponding type is maintained. This gets updated along with the hashmap for categories and their respective courses.

If after the criteria of minimum 2 courses is satisfied no particular order is followed, therefore if after A and D is in the final list, B is selected as the criteria has been fulfilled already.

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).