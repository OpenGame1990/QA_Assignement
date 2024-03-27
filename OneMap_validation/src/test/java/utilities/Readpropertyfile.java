package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Readpropertyfile {

	public static void main(String args[]) throws Exception {
		
		FileReader fr=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
		Properties p= new Properties();
		p.load(fr);
		System.out.println(p.getProperty("search_field"));
	}
}
