package cba_user;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
	
	// Taking Employee details from console and Validation of field as per the requirements
	public String[] inputDetails() {
		String lName = null, fName = null, User_Emailid = null, User_Mobile = null;
		String regex = "[6-9][0-9]{9}";
		String regexE = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Boolean flag = false;
		ArrayList<String> result = new ArrayList<String>(4);
		Scanner scan = new Scanner(System.in);
		
		// Logic for taking inputs from console
		do {
			System.out.print("Enter First Name of Employee : ");
			fName = scan.next();
			System.out.print("Enter Last Name of Employee : ");
			lName = scan.next();
			System.out.print("Enter EmailId  of Employee : ");
			User_Emailid = scan.next();
			System.out.print("Enter Mobile Number  of Employee : ");
			User_Mobile = scan.next();

			// logics for field Validations
			if (fName.length() < 3 && !(User_Mobile.matches(regex)) && !User_Emailid.matches(regexE)) {
				System.out.println("Input Errors : ");
				System.out.println("Enter valid name hints : first Name Length should be minimum 3 ");
				System.out.println("Enter Valid mobile Number and ");
				System.out.println("Enter valid  EmailId");
				flag = true;
				continue;
			} else if (!(User_Mobile.matches(regex))) {
				System.out.println("Enter Valid mobile Number :");
				flag = true;
			}
			if (fName.length() < 3) {
				System.out.println("Enter valid name hints : first Name Length should be minimum 3");
				flag = true;
			}
			if (!User_Emailid.matches(regexE)) {
				System.out.println("Enter valid  EmailId");
				flag = true;
			}

		} while (flag);

		if (flag == false) {
			result.add(fName);
			result.add(lName);
			result.add(User_Emailid);
			result.add(User_Mobile);
			return result.toArray(new String[4]);
		} else {
			return null;
		}

	}

	// Password generation
	public void passwordGen(String[] details) {

		if (details!=null && (details[3].toString()).length() == 10 && details[2] != null && details[0].length() >= 4) {

			// first 4 digit is last 4 digit of their mobile number
			String mobile = details[3].toString();
			String first_four_digitOfPassword = mobile.substring(6);

			// last 3 chars extracted from their first 3digit of their first name
			String last_three_digitsOfPassword = details[0].substring(0, 3);

			// 8 Digit password
			String password = first_four_digitOfPassword.concat("$").concat(last_three_digitsOfPassword);

			// displaying the Username and Password
			System.out.println("User_Name and Password For " + details[0] + " " + details[1]);
			System.out.print("Username : " + details[2] + "     ");
			System.out.println("Password : " + password);
			System.out.print("\n");
		} else {
			System.out.println("Some Mandatory details are not Available please inform to Employee : " + details[0]
					+ " " + details[1]);

		}
	}

}
