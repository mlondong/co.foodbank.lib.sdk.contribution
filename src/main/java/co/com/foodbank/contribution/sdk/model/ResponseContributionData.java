package co.com.foodbank.contribution.sdk.model;

import java.util.Date;
import co.com.foodbank.contribution.dto.IContribution;
import co.com.foodbank.contribution.state.IStateContribution;
import co.com.foodbank.vehicule.dto.VolumeDTO;


/**
 * @author mauricio.londono@gmail.com co.com.foodbank.contribution.sdk.model
 *         2/07/2021
 */
public class ResponseContributionData implements IContribution {

    private String id;
    private String description;
    private Date date;

    private IStateContribution state;

    /* For General Contribution specifications */
    public VolumeDTO volume;

    /* For Detail Contribution specifications */
    private String codeBar;
    private Long numOfPackage;


    /**
     * Default constructor.
     */
    public ResponseContributionData() {

    }


    public String getCodeBar() {
        return codeBar;
    }


    public void setCodeBar(String codeBar) {
        this.codeBar = codeBar;
    }


    public Long getNumOfPackage() {
        return numOfPackage;
    }


    public void setNumOfPackage(Long numOfPackage) {
        this.numOfPackage = numOfPackage;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setState(IStateContribution state) {
        this.state = state;
    }

    public void setVolume(VolumeDTO volume) {
        this.volume = volume;
    }

    public VolumeDTO getVolume() {
        return volume;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public IStateContribution getState() {
        return state;
    }

    @Override
    public String getId() {
        return id;
    }
}
