package by.stas.registration.accounting;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class RegAccountingContext implements Serializable {

    @Getter
    private final Query query = new Query();

    @Getter
    @Setter
    private SearchResults[] searchResults = new SearchResults[]{};

    @PostConstruct
    private void init() {
        System.out.println("SearchLocalDatabase created");
    }

}