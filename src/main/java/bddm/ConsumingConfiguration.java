package bddm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * Created by maksim on 22-Jul-17.
 */
@Configuration
public class ConsumingConfiguration {

    @Bean
    Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("bddm.dto.soap");
        return jaxb2Marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
	    webServiceTemplate.setMarshaller(marshaller);
	    webServiceTemplate.setUnmarshaller(marshaller);
        //webServiceTemplate.setDefaultUri("http://localhost:8080/ws_poslovne/nalog");

        return webServiceTemplate;
    }
}
