package by.stas.registration.accounting;


import lombok.Getter;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@ManagedBean
@SessionScoped
public class SearchLocalDatabase implements Serializable {
    @Getter
    private final Query query = new Query();


    @PostConstruct
    private void init() {
        System.out.println("SearchLocalDatabase created");
    }

    public void searchIntoLocalDB() throws UnsupportedEncodingException {
        String surname = URLEncoder.encode(query.getSurname(), "UTF-8");

        RestTemplate restTemplate = new RestTemplate();

        SearchResults[] searchResults = restTemplate.getForObject("https://a.todes.by:13555/data-service-test/api/v1/data?" +
                "sys_organ=26&identif=" + query.getIdentif() + "&surname=" + surname +
                "&name=" + query.getName() + "&patronymic=" + query.getPatronymic() + "&doc_series=" + query.getDocSeries() +
                "&doc_num=" + query.getDocNum(), SearchResults[].class);
        SearchResults searchResults1 = new SearchResults();
        if (searchResults != null) {
            for (SearchResults results : searchResults) {
                System.out.println(results);

            }
        }

        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Инфо", searchResults1.toString()));

    }

}