import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AccountControllerTest {
	AccountController accountController = new AccountController();
	
//	@BeforeTest
//	public void prepareSystemAccounts () throws FileNotFoundException {
//		
//		// Inserting Accounts Information from Users.txt into accountController's ArrayList of Accounts
//		
//		Scanner in = new Scanner(new File("Accounts.txt"));
//		while(in.hasNext()) {
//			Account account = new Account();
//			account.Name = in.next();
//			account.Age = in.nextInt();
//			account.Email = in.next();
//			account.Password = in.next();
//			account.Gender = in.next();
//			account.Type = in.next();
//			accountController.Acc.add(account);
//		}
//		in.close();
//		
//	}
	
	@BeforeTest
	public void prepareSignUpInputSource () throws FileNotFoundException {
		
		// Reinitialize accountController's Scanner to Accept Input from Login Input.txt
		accountController.in = new Scanner(new File("Accounts.txt"));		
				
	}

//	@BeforeTest
//	public void prepareLoginInputSource () throws FileNotFoundException {
//		
//		// Reinitialize accountController's Scanner to Accept Input from Login Input.txt
//		accountController.in = new Scanner(new File("Login Input.txt"));
//	}
//	
	
	// InvocationCount Equals to the Number of Test Cases in Login Input.txt File
	
	ArrayList<Account> accounts = new ArrayList<Account>();
	int i=0;
	
	@Test(invocationCount = 11 , priority = 0)
	public void Register() {
		Account NewMember = accountController.Registration();
        accounts.add(NewMember);
	}
	
	
	@Test(invocationCount = 36 , priority = 1)
	public void Login() throws FileNotFoundException {
		accountController.in = new Scanner(new File("Login Input.txt"));
		Account user = accounts.get(i);
		Assert.assertEquals(user.Type, accountController.Login(user));
	}
}
