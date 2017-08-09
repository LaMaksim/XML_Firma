package bddm;

import bddm.client.IzvodClient;
import bddm.client.UplatnicaClient;
import org.springframework.beans.factory.annotation.Autowired;
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
        webServiceTemplate.setDefaultUri("http://localhost:8084/ws");

        return webServiceTemplate;
    }

    @Bean
    public UplatnicaClient uplatnicaClient(Jaxb2Marshaller jaxb2Marshaller) {
        UplatnicaClient client = new UplatnicaClient();
        //client.setDefaultUri("http://localhost:8084/ws/bussinessBank");
        client.setDefaultUri("http://localhost:8084/ws");
        client.setMarshaller(jaxb2Marshaller);
        client.setUnmarshaller(jaxb2Marshaller);

        return client;
    }

    @Bean
    public IzvodClient izvodClient(Jaxb2Marshaller jaxb2Marshaller) {
        IzvodClient client = new IzvodClient();
        client.setDefaultUri("http://localhost:8084/ws");
        client.setMarshaller(jaxb2Marshaller);
        client.setUnmarshaller(jaxb2Marshaller);

        return client;
    }
}
