package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validators.email")
public class EmailValidator implements Validator {
private static final String MAIL_PATTERN = "[a-zA-Z0-9-._]+@[a-zA-Z0-9-._].[a-z]+" ; 
private Pattern pattern;
private Matcher matcher;

public EmailValidator() {
	pattern = Pattern.compile(MAIL_PATTERN);
}
@Override
public void validate (FacesContext context, UIComponent component, Object value) throws ValidatorException {
	matcher = pattern.matcher(value.toString()); 
	if(!matcher.matches()){
		FacesMessage msg = new FacesMessage("Ce n'est pas une @ mail","Il faut suivre le pattern suivant, mail correct : "+MAIL_PATTERN); 
		msg.setSeverity(FacesMessage.SEVERITY_ERROR); 
		throw new ValidatorException(msg); 
	}
}

}