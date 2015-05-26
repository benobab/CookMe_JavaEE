package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validators.age")
public class AgeValidator implements Validator {
private static final String AGE_PATTERN = "*" ; 
private Pattern pattern;
private Matcher matcher;

public AgeValidator() {
	pattern = Pattern.compile(AGE_PATTERN);
}
@Override
public void validate (FacesContext context, UIComponent component, Object value) throws ValidatorException {
	matcher = pattern.matcher(value.toString()); 
	if(!matcher.matches()){
		FacesMessage msg = new FacesMessage("user name validation failed.","User Name Validation failed please follow the contraint"+AGE_PATTERN); 
		msg.setSeverity(FacesMessage.SEVERITY_ERROR); 
		throw new ValidatorException(msg); 
	}
}

}