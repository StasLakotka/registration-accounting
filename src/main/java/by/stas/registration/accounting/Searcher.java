package by.stas.registration.accounting;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Searcher {

    @ManagedProperty(value = "#{regAccountingContext}")
    @Getter
    @Setter
    private RegAccountingContext regAccountingContext;

    @PostConstruct
    private void init() {
        System.out.println("Searcher created");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Searcher destroyed");
    }

    public void searchIntoLocalDB() {
        RestTemplate restTemplate = new RestTemplate();
        Query query = regAccountingContext.getQuery();
        SearchResults[] searchResults = restTemplate.getForObject("https://a.todes.by:13555/data-service-test/api/v1/data?" +
                "sys_organ=26&identif=" + query.getIdentif() + "&surname=" + query.getSurname() +
                "&name=" + query.getName() + "&patronymic=" + query.getPatronymic() + "&doc_series=" + query.getDocSeries() +
                "&doc_num=" + query.getDocNum(), SearchResults[].class);
        regAccountingContext.setSearchResults(searchResults);
    }

}
