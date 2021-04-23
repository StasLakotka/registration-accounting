package by.stas.registration.accounting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResults  {

    private String surname;
    private String name;
    private String sname;
    private String bdate;
    private String identif;
   // private String addressLast;
    private String ateAddress;
    private String dsdDateRec;

}
