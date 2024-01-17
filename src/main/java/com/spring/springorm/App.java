package com.spring.springorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        ApplicationContext context= new ClassPathXmlApplicationContext("com/spring/springorm/config.xml");
        StudentDao var=(StudentDao) context.getBean("studentDao");
        
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        boolean f=true;
        System.out.println("*************************************************");
        while(f) {
        	
            System.out.println("Enter 1 to add a new student");
            System.out.println("Enter 2 to view all the students details");
            System.out.println("Enter 3 to view the student detail of single student");
            System.out.println("Enter 4 to delete a student from the table");
            System.out.println("Enter 5 update the details of a student");
            System.out.println("Enter 6 to exit the app");
            int n=Integer.parseInt(br.readLine());
            System.out.println(n);
            switch (n) {
    		case 1:
    			System.out.println("enter studentId");
    			int id=Integer.parseInt(br.readLine());
    			System.out.println("enter studentName");
    			String name=(String)br.readLine();
    			System.out.println("enter studentCity");
    			String city=(String) br.readLine();

    			Student st=new Student(id,name,city);
    			var.insert(st);
    			System.out.println("*************************************************");
    			break;
    		case 2:
    			List<Student> l=new ArrayList<Student>();
    			l=(List<Student>) var.getAllStudents();
    			for(Student v:l) {
    				System.out.println(v);
    			}
    			System.out.println("*************************************************");
    			break;
    		case 3:
    			System.out.println("enter studentId");
    			int studentId=Integer.parseInt(br.readLine());
    			Student s=(Student) var.getStudent(studentId);
    			System.out.println(s);
    			System.out.println("*************************************************");
    			break;

    		case 4:
    			System.out.println("enter studentId");
    			Integer sId=Integer.parseInt(br.readLine());
    			var.deleteStudent(sId);
    			System.out.println("*************************************************");
    			break;	
    		case 5:
    			System.out.println("enter studentId");
    			int idU=Integer.parseInt(br.readLine());
    			System.out.println("enter studentName");
    			String nameU=(String)br.readLine();
    			System.out.println("enter studentCity");
    			String cityU=(String) br.readLine();
    			Student stU=new Student(idU,nameU,cityU);
    			var.updateStudent(stU);
    			System.out.println("*************************************************");
    			break;
    		case 6:
    			System.out.println("Thank you for using the app!");
    			System.out.println("Hope to see you soon");
    			System.out.println("*************************************************");
    			f=false;
    			break;
    		
    		default:
    			f=false;
    			break;
    		}
            
            }

    }
}
