package commonclasses;

/**
 * Created by Rick on 9/26/2014.
 */
public interface ValidationCell extends PresentationCell{
    void setValidationRule(String regex);
    String getValidationRule();
    boolean isValid();
    void setValidationMessage(String regex);
    String getValidationMessage();
}
