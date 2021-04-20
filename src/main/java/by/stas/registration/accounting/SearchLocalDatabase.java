package by.stas.registration.accounting;


import lombok.Getter;

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


    @PostConstruct
    private void init() {
        System.out.println("SearchLocalDatabase created");
    }

    public void searchIntoLocalDB()  {

        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Инфо", query.toString()));

    }

}
