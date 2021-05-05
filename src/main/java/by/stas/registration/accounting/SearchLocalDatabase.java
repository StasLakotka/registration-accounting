package by.stas.registration.accounting;

import lombok.Getter;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class SearchLocalDatabase implements Serializable {

    @Getter
    private final Query query = new Query();

    @Getter
    private SearchResults[] searchResults;

    @PostConstruct
    private void init() {
        System.out.println("SearchLocalDatabase created");
    }

    public void searchIntoLocalDB() {
        RestTemplate restTemplate = new RestTemplate();
        searchResults = restTemplate.getForObject("https://a.todes.by:13555/data-service-test/api/v1/data?" +
                "sys_organ=26&identif=" + query.getIdentif() + "&surname=" + query.getSurname() +
                "&name=" + query.getName() + "&patronymic=" + query.getPatronymic() + "&doc_series=" + query.getDocSeries() +
                "&doc_num=" + query.getDocNum(), SearchResults[].class);


//        FacesContext.getCurrentInstance()
//                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Инфо", query.toString()));

    }
}