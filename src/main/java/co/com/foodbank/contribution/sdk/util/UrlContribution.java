package co.com.foodbank.contribution.sdk.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Class to handle Url for sdk Packaged.
 * 
 * @author mauricio.londono@gmail.com co.com.foodbank.vault.sdk.util 25/08/2021
 */
@Component
@Validated
public class UrlContribution {

    @Value("${sdk.service.contribution.scheme}")
    private String urlScheme;

    @Value("${sdk.service.contribution.url}")
    private String urlBase;



    public String toCreateDetailContrib() {
        return UriComponentsBuilder.newInstance().scheme(urlScheme)
                .host(urlBase)
                .path(SDKContributionParameters.PATH_CREATE_DETAIL_CONTRIB)
                .build().toString();
    }

    public String toCreateGeneralContrib() {
        return UriComponentsBuilder.newInstance().scheme(urlScheme)
                .host(urlBase)
                .path(SDKContributionParameters.PATH_CREATE_GENERAL_CONTRIB)
                .build().toString();
    }

    public String toFindContribById(String idContribution) {
        return UriComponentsBuilder.newInstance().scheme(urlScheme)
                .host(urlBase)
                .path(SDKContributionParameters.PATH_FIND_CONTRIB_ID
                        + idContribution)
                .buildAndExpand(encode(idContribution)).toString();
    }


    /**
     * Method for encode
     * 
     * @param value url
     * @return utf8 encoded url
     */
    private String encode(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

}
