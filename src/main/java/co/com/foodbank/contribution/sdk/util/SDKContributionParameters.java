package co.com.foodbank.contribution.sdk.util;

/**
 * @author mauricio.londono@gmail.com co.com.foodbank.packaged.sdk.util
 *         25/08/2021
 */
public final class SDKContributionParameters {



    public static final String _PREFIX = "/contribution";
    public static final String _SUFIX_CREATE_DETAIL_CONTRIB =
            "/createDetailContribution";
    public static final String _SUFIX_CREATE_GENERAL_CONTRIB =
            "/createGeneralContribution";
    public static final String _SUFIX_FIND_CONTRIB_ID = "/id/";


    public static final String PATH_CREATE_DETAIL_CONTRIB =
            _PREFIX + _SUFIX_CREATE_DETAIL_CONTRIB;
    public static final String PATH_CREATE_GENERAL_CONTRIB =
            _PREFIX + _SUFIX_CREATE_GENERAL_CONTRIB;
    public static final String PATH_FIND_CONTRIB_ID =
            _PREFIX + _SUFIX_FIND_CONTRIB_ID;


    public SDKContributionParameters() {}
}
