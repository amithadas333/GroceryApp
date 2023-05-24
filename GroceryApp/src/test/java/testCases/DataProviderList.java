package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderList {
	@DataProvider (name = "userLogin")

	public Object[][] validUserLogin() {
		
		

		return new Object[][] {
			{ "valid","admin", "admin" },
			{"invalid", "wrongusername", "wrongpassword" }
				
		};

	}

	
}
