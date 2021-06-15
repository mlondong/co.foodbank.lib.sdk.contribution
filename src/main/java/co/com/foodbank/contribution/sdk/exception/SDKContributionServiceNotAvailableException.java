package co.com.foodbank.contribution.sdk.exception;

/**
 * @author mauricio.londono@gmail.com co.com.foodbank.contribution.sdk.exception
 *         15/06/2021
 */
public class SDKContributionServiceNotAvailableException
        extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public SDKContributionServiceNotAvailableException(Exception e) {
        super(e);
    }

}
