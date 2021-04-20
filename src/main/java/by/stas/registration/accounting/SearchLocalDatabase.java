package by.stas.registration.accounting;


import lombok.Getter;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class SearchLocalDatabase implements Serializable {
    @Getter
    private final Query query = new Query();
    private final SearchResults searchResults = new SearchResults();

    @PostConstruct
    private void init() {
        System.out.println("SearchLocalDatabase created");
    }

    public void searchIntoLocalDB()  {
        RestTemplate restTemplate = new RestTemplate();
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Инфо", searchResults.getSurname()));

    }

}
