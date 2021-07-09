package co.com.foodbank.contribution.sdk.service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import co.com.foodbank.contribution.dto.DetailContributionDTO;
import co.com.foodbank.contribution.dto.GeneralContributionDTO;
import co.com.foodbank.contribution.sdk.exception.SDKContributionServiceException;
import co.com.foodbank.contribution.sdk.exception.SDKContributionServiceIllegalArgumentException;
import co.com.foodbank.contribution.sdk.exception.SDKContributionServiceNotAvailableException;
import co.com.foodbank.contribution.sdk.model.ResponseContributionData;

/**
 * @author mauricio.londono@gmail.com co.com.foodbank.contribution.sdk.service
 *         15/06/2021
 */
@Service
@Validated
public class SDKContributionService implements ISDKContribution {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    private HttpHeaders httpHeaders;


    @Value("${urlSdlGeneralContribution}")
    private String urlSdlGeneralContribution;


    @Value("${urlSdlDetailContribution}")
    private String urlSdlDetailContribution;


    @Value("${urlSdlFindContribution}")
    private String urlSdlFindContribution;



    /**
     * Method to create a GeneralContribution through resttemplate
     */
    @Override
    public ResponseContributionData create(GeneralContributionDTO dto)
            throws JsonMappingException, JsonProcessingException,
            SDKContributionServiceException,
            SDKContributionServiceNotAvailableException,
            SDKContributionServiceIllegalArgumentException {

        try {

            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<GeneralContributionDTO> entity =
                    new HttpEntity<GeneralContributionDTO>(dto, httpHeaders);

            String response =
                    restTemplate
                            .exchange(urlSdlGeneralContribution,
                                    HttpMethod.POST, entity, String.class)
                            .getBody();

            return objectMapper.readValue(response,
                    new TypeReference<ResponseContributionData>() {});


        } catch (ResourceAccessException e) {
            throw new SDKContributionServiceNotAvailableException(e);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new SDKContributionServiceIllegalArgumentException(e);
            }
            throw new SDKContributionServiceException(e);
        } catch (Exception e) {
            throw new SDKContributionServiceException(e);
        }


    }


    /**
     * Method to create a GeneralContribution through resttemplate
     */
    @Override
    public ResponseContributionData create(DetailContributionDTO dto)
            throws JsonMappingException, JsonProcessingException,
            SDKContributionServiceException,
            SDKContributionServiceNotAvailableException,
            SDKContributionServiceIllegalArgumentException {

        try {

            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<DetailContributionDTO> entity =
                    new HttpEntity<DetailContributionDTO>(dto, httpHeaders);

            String response = restTemplate.exchange(urlSdlDetailContribution,
                    HttpMethod.POST, entity, String.class).getBody();

            return objectMapper.readValue(response,
                    new TypeReference<ResponseContributionData>() {});

        } catch (ResourceAccessException e) {
            throw new SDKContributionServiceNotAvailableException(e);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new SDKContributionServiceIllegalArgumentException(e);
            }
            throw new SDKContributionServiceException(e);
        } catch (Exception e) {
            throw new SDKContributionServiceException(e);
        }


    }



    @Override
    public ResponseContributionData findContributionById(String id)
            throws JsonMappingException, JsonProcessingException,
            SDKContributionServiceException,
            SDKContributionServiceNotAvailableException,
            SDKContributionServiceIllegalArgumentException {

        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);

        String response = restTemplate.exchange(urlSdlFindContribution + id,
                HttpMethod.GET, entity, String.class).getBody();


        return objectMapper.readValue(response,
                new TypeReference<ResponseContributionData>() {});
    }



}
