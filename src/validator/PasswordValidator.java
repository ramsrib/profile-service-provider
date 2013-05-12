package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class PasswordValidator  extends FieldValidatorSupport{

    private Pattern digitPattern = Pattern.compile("[0-9]");
    private Pattern letterPattern = Pattern.compile("[a-zA-Z]");
    private Pattern specialCharsDefaultPattern = Pattern.compile("!@#$");


    @Override
    public void validate(Object object) throws ValidationException {

        String fieldName = getFieldName();
        String fieldValue = (String) getFieldValue(fieldName, object);

        fieldValue = fieldValue.trim();

        Matcher digitMatcher = digitPattern.matcher(fieldValue);
        Matcher letterMatcher = letterPattern.matcher(fieldValue);
        Matcher specialCharsMatcher;


        if (getSpecialCharacters() != null) {
            Pattern specialPattern = Pattern.compile("[" + getSpecialCharacters() + "]");
            specialCharsMatcher = specialPattern.matcher(fieldValue);
        } else {
            specialCharsMatcher = specialCharsDefaultPattern.matcher(fieldValue);
        }

        if (!digitMatcher.find()) {
            addFieldError(fieldName, object);
        } else if (!letterMatcher.find()) {
            addFieldError(fieldName, object);
        } else if (!specialCharsMatcher.find()) {
            addFieldError(fieldName, object);
        }

    }

    private String specialCharacters;

    public String getSpecialCharacters() {
        return specialCharacters;
    }

    public void setSpecialCharacters(String specialCharacters) {
        this.specialCharacters = specialCharacters;
    }
}
