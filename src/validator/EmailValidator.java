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
private static final String MAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"; 
private Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
private Matcher matcher;

public EmailValidator() {
	
}
@Override
public void validate (FacesContext context, UIComponent component, Object value) throws ValidatorException {
	matcher = pattern.matcher(value.toString()); 
	if(!matcher.matches()){
		FacesContext.getCurrentInstance().addMessage( null,new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Incorrect email adress",
                        "Please enter correct email adress"));
		FacesMessage msg = new FacesMessage("Ce n'est pas une @ mail","Il faut suivre le pattern suivant, mail correct : "+MAIL_PATTERN); 
		msg.setSeverity(FacesMessage.SEVERITY_ERROR); 
		throw new ValidatorException(msg); 
	}
}

}