package by.stas.registration.accounting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AddressLast {

    private String areaL;
    private String regionL;
    private String villageCouncil;
    private String typeCityL;
    private String cityL;
    private String typeStreetL;
    private String streetL;
    private String house;
    private String korps;
    private String app;


}
