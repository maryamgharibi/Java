import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * @author maryam
 *
 */
public class PasswordValidator {
	private Pattern pattern;
	private Matcher matcher;
private static final String PASSWORD_PATTERN =
"((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";



	public boolean ValidatePassword(final String pass) {
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(pass);
		return matcher.matches();
	 
		 
		
	}
	
	 

}
