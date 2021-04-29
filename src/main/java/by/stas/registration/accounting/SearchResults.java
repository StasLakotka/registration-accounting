package by.stas.registration.accounting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SearchResults  {

    private String surname;
    private String name;
    private String sname;
    private String bdate;
    private String identif;
    private AddressLast addressLast;
    private String ateAddress;
    private String dsdDateRec;


}
