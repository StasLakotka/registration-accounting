package by.stas.registration.accounting;

import lombok.Data;

@Data
public class Query {

    private String surname;
    private String name;
    private String patronymic;
    private String identif;
    private String doc_series;
    private String doc_num;

}
