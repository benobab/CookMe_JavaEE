package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import model.UserSubmissionModel;

@FacesValidator(value = "validators.password")
public class PasswordValidator implements Validator {
private static final String PASSWORD_PATTERN = "\\*" ; 
private Pattern pattern;
private Matcher matcher;

public PasswordValidator() {
	pattern = Pattern.compile(PASSWORD_PATTERN);
}
@Override
public void validate (FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
	String obj =   component.getAttributes().get("premPass").toString();
	//System.out.println(obj.getSubmittedValue());
	System.out.println(obj + value.toString());
	if(obj.compareTo(value.toString())<0)
	{	
		FacesMessage msg = new FacesMessage("Mdp différent du premier","Veuillez rentrer deux mots de passe identiques."+PASSWORD_PATTERN); 
		msg.setSeverity(FacesMessage.SEVERITY_ERROR); 
		throw new ValidatorException(msg);
	}

}

}