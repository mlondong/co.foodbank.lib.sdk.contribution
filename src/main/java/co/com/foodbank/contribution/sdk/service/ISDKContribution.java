package co.com.foodbank.contribution.sdk.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import co.com.foodbank.contribution.dto.DetailContributionDTO;
import co.com.foodbank.contribution.dto.GeneralContributionDTO;
import co.com.foodbank.contribution.sdk.exception.SDKContributionNotFoundException;
import co.com.foodbank.contribution.sdk.exception.SDKContributionServiceException;
import co.com.foodbank.contribution.sdk.exception.SDKContributionServiceIllegalArgumentException;
import co.com.foodbank.contribution.sdk.exception.SDKContributionServiceNotAvailableException;
import co.com.foodbank.contribution.sdk.model.ResponseContributionData;

/**
 * @author mauricio.londono@gmail.com co.com.foodbank.contribution.sdk.service
 *         15/06/2021
 */
public interface ISDKContribution {


    /**
     * Method to create DetailContribution.
     * 
     * @param dto
     * @return {@code ResponseContributionData}
     * @throws JsonMappingException
     * @throws JsonProcessingException
     * @throws SDKContributionServiceException
     * @throws SDKContributionServiceNotAvailableException
     * @throws SDKContributionServiceIllegalArgumentException
     */
    ResponseContributionData create(GeneralContributionDTO dto)
            throws JsonMappingException, JsonProcessingException,
            SDKContributionServiceException,
            SDKContributionServiceNotAvailableException,
            SDKContributionServiceIllegalArgumentException;


    /**
     * Method to create DetailContribution.
     * 
     * @param dto
     * @return {@code ResponseContributionData}
     * @throws JsonMappingException
     * @throws JsonProcessingException
     * @throws SDKContributionServiceException
     * @throws SDKContributionServiceNotAvailableException
     * @throws SDKContributionServiceIllegalArgumentException
     */
    ResponseContributionData create(DetailContributionDTO dto)
            throws JsonMappingException, JsonProcessingException,
            SDKContributionServiceException,
            SDKContributionServiceNotAvailableException,
            SDKContributionServiceIllegalArgumentException;



    /**
     * Method to find Contribution.
     * 
     * @param id
     * @return {@code ResponseContributionData}
     * @throws JsonMappingException
     * @throws JsonProcessingException
     * @throws SDKContributionServiceException
     * @throws SDKContributionServiceNotAvailableException
     * @throws SDKContributionServiceIllegalArgumentException
     */
    ResponseContributionData findContributionById(String id)
            throws JsonMappingException, JsonProcessingException,
            SDKContributionServiceException,
            SDKContributionServiceNotAvailableException,
            SDKContributionServiceIllegalArgumentException,
            SDKContributionNotFoundException;
}
