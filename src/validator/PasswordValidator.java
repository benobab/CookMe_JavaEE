package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
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
	
	UserSubmissionModel obj = (UserSubmissionModel) component.getAttributes().get("TRUC");
	if(!(obj.getPwd().compareTo(obj.getRepwd())==0))
	{	
		FacesMessage msg = new FacesMessage("user name validation failed.","User Name Validation failed please follow the contraint"+PASSWORD_PATTERN); 
		msg.setSeverity(FacesMessage.SEVERITY_ERROR); 
		throw new ValidatorException(msg);
	}

}

}