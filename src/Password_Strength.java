import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Password_Strength {

	static String path = "\\C:\\Users\\Dylan\\workspace\\Password_Strength\\src\\Password_List";
	static String horrible = "horrible";
	static String bad = "bad";
	static String ok = "ok";
	static String strong = "strong";
	static boolean onList = false;
	static String gPassword = "argHRTHER4566!@#";
	
	public static void main(String[] args) {
		String strength = horrible;
		try {
			checkList(gPassword);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(onList == false){
			strength = checkPasswordStrength(gPassword);
			System.out.println("Your password strength is " + strength + " [checked]");
		}
		else{
			System.out.println("Your password strength is " + strength);
		}
    }
	
	private static boolean checkList(String password) throws IOException{
		FileReader fr = new FileReader(path);
		BufferedReader reader = new BufferedReader(fr);
		
		int lines = readLines();
		String[] data = new String[lines];
		
		int i;
		for(i=0; i<lines; i++){
			data[i] = reader.readLine();
			if(data[i].equals(password.trim())){
				onList = true;
			}
		}
		
		reader.close();
		return onList;
	}
	
	private static int readLines() throws IOException{
		FileReader fr = new FileReader(path);
		BufferedReader bf = new BufferedReader(fr);
		
		String line;
		int lines = 0;
		
		while(( line = bf.readLine()) != null){
			lines++;
		}
		bf.close();
		return lines;
	}
	
    private static String checkPasswordStrength(String password) {
                String  strengthPercentage = "";
        String[] partialRegexChecks = { ".*[a-z]+.*", // lower
                ".*[A-Z]+.*", // upper
                ".*[\\d]+.*", // digits
                ".*[@#$%]+.*" // symbols
        };

        if(password.trim().equals("")){   
            return strengthPercentage = "You must enter a password";
        }
        
        if (password.matches(partialRegexChecks[0])) {
        strengthPercentage = horrible;
        }
        if (password.matches(partialRegexChecks[1])) {
        strengthPercentage = bad;
        }
        if (password.matches(partialRegexChecks[2])) {
        strengthPercentage = ok;
        }
        if (password.matches(partialRegexChecks[3])) {
        strengthPercentage = strong;
        }

        return strengthPercentage;
    }
	
}
