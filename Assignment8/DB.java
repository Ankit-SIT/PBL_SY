import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class DB {	
	static String url = "jdbc:mysql://localhost:3306/pbl";
	static String username ="root";
	static String password="toor";
	static Scanner scan;

	DB(){
		scan = new Scanner(System.in);
	}
	
	public static void addEmployee() throws SQLException {
		int empno;
		String name, department, job;
		float salary;
		
        try {
    		System.out.print(" Enter Employee Name : ");
    		name = scan.next();
    		System.out.print(" Enter Department : ");
    		department = scan.next();
    		System.out.print(" Enter Job : ");
    		job = scan.next();
    		System.out.print(" Enter Salary : ");
    		salary = scan.nextFloat();
    		
    		Connection con = DriverManager.getConnection(url, username, password);
    		Statement ps = con.createStatement();
    		String query = " insert into Employee (EMP_Name,EMP_Department,EMP_JOB,EMP_Salary) values('"+name+"','"+department+"','"+job+"',"+salary+")";

    		int r = ps.executeUpdate(query);
    		System.out.println("RECORD INSERTED!");
    		ps.close();
    		
    		PreparedStatement pss = con.prepareStatement(" select * from employee where EMP_Name='"+name+"' AND EMP_Department='"+department+"' AND EMP_JOB='"+job+"' AND EMP_Salary="+salary);
    		ResultSet rr = pss.executeQuery();
    		
    		while(rr.next()){
    			empno = Integer.parseInt(rr.getString("EMP_ID"));
    			System.out.println("ID : "+empno);
    		}
    		pss.close();
    		rr.close();
		}catch(Exception e) {
			System.out.println(" Exception : "+ e);
		}	
	}
	
    public static void display() throws SQLException {
    	int count = 1;
    	System.out.println("\n _______________________________________");
		System.out.println("| \tSr No \t|  Employee Name \t|");
		System.out.println("|---------------------------------------|");
		
		Connection con=DriverManager.getConnection(url, username, password);
		PreparedStatement ps = con.prepareStatement("select EMP_ID,EMP_Name from Employee");
		ResultSet r = ps.executeQuery();
		
		while(r.next()){
			System.out.println("|\t  "+count+" \t| \t"+r.getString("EMP_Name")+"\t\t|");
			count ++;
		}
		System.out.println("|_______________________________________|");
		ps.close();
		r.close();
	}
    
    public static void search() throws SQLException {
    	String name;
		int empno;
		
        try {
        	System.out.print("\n Enter Employee Name : ");
    		name = scan.next();
    		System.out.print("\n Enter Employee ID : ");
    		empno = scan.nextInt();
    		
    		System.out.println("| \tEmp ID \t| \tName \t| \tDepartment \t| \tJob \t\t| \tSalary \t\t|");
    		Connection con = DriverManager.getConnection(url, username, password);
    		PreparedStatement ps = con.prepareStatement("select * from Employee where EMP_Name='"+name+"' AND EMP_ID="+empno);
    			ResultSet r = ps.executeQuery();
    			while(r.next()){
    				System.out.println("| \t"+r.getString("EMP_ID")+" \t| \t"+r.getString("EMP_Name")+" \t| \t"+r.getString("EMP_Department")+" \t\t| \t"+r.getString("EMP_JOB")+" \t| \t"+r.getString("EMP_Salary")+" \t|");
    			}
    			ps.close();
    			r.close();
		}catch(Exception e) {
			System.out.println(" Exception : "+e);
		}
	}
    
    public static void update() throws SQLException {
    	int empno;
		float salary;
		
		try {
			System.out.print(" Enter Employee ID : ");
			empno = scan.nextInt();
			System.out.print(" Enter Updated Salary : Rs.");
			salary = scan.nextFloat();
			
			Connection con=DriverManager.getConnection(url, username, password);
			Statement ps = con.createStatement();
			String query = " update Employee set EMP_Salary="+salary+"where EMP_ID="+empno;
			int r = ps.executeUpdate(query);
			if(r == 0) {
				System.out.println(" Employee ID not Found!");
			}else {
				System.out.println(" Record Updated Successfully!");
			}
			ps.close();
		}catch(Exception e) {
			System.out.println(" Exception : "+e);
		}
	}
    
    public static void delete() throws SQLException {
    	int empno;
		try {
			System.out.print(" Enter Employee ID : ");
			empno = scan.nextInt();
			
			Connection con=DriverManager.getConnection(url, username, password);
			Statement ps = con.createStatement();

			String query = " delete from Employee where EMP_ID=" + empno;
			int r = ps.executeUpdate(query);
			if(r == 0) {
				System.out.println(" Employee ID not Found!");
			} else {
				System.out.println(" Record DELETED Successfully!");
			}
			ps.close();
		}catch(Exception e) {
			System.out.println(" Exception : "+e);
		}
	}
    
	public static void main(String[] args) throws SQLException {
		Integer choice;
		Scanner scan = new Scanner(System.in);

    	try {
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    		} catch(ClassNotFoundException Error) {
    			Error.printStackTrace();
    		}

    		Connection connection = DriverManager.getConnection(url, username, password);
    		System.out.println("ESTABLISHING CONNECTION- " + connection);	

    	} catch (SQLException e) {
            System.out.println("ERROR OCCURED!");
            e.printStackTrace();
        }
	
		while(true) {
			System.out.println("-- MENU --\n");
			System.out.println("1. ADD\n");
			System.out.println("2. DISPLAY\n");
			System.out.println("3. SEARCH\n");
			System.out.println("4. UPDATE\n");
			System.out.println("5. DELETE\n");
			System.out.println("6. EXIT\n");
			System.out.print("ENTER CHOICE: ");
			choice = scan.nextInt();
			
			switch(choice) {
			case 1:
				addEmployee();
				break;
			case 2:
				display();
				break;
			case 3:
				search();
				break;
			case 4:
				update();
				break;
			case 5:
				delete();
				break;
			case 6:
				return;
			default :
				System.out.println("INVALID CHOICE!");
			}
		}
	}
}
