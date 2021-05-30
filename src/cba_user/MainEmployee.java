package cba_user;

public class MainEmployee {

	public static void main(String[] args) {
		Employee emp = new Employee();
		//emp.passwordGen();
		String[] inputDetails = emp.inputDetails();
		
		emp.passwordGen(inputDetails);
	}

}
