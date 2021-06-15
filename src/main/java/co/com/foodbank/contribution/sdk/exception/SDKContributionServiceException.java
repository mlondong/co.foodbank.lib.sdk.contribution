package co.com.foodbank.contribution.sdk.exception;

/**
 * @author mauricio.londono@gmail.com co.com.foodbank.contribution.sdk.exception
 *         15/06/2021
 */
public class SDKContributionServiceException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public SDKContributionServiceException(Exception e) {
        super(e);
    }
}
