package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Reading {
	
	Properties pro;
	public  Reading() {
		
		File f=new File("C:\\Users\\manid\\eclipse-workspace\\DataDrivenTesting_01\\DDTProperties\\DDT.properties");
		
		try {
			
			FileInputStream fis=new FileInputStream(f);
			pro=new Properties();
			pro.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
	
	}
	
	public String getAppURL() { 
		
		String url=pro.getProperty("appURL");
		return url;
	}
	
	public String getUsername() {
		
		String uname=pro.getProperty("username");
		return uname;
	}
	
	public String getPassword() {
		
		String pword=pro.getProperty("password");
		return pword;
				
	}


}
