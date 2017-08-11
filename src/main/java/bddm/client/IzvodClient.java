package bddm.client;

import bddm.dto.soap.DTOPresekZahtev;
import bddm.dto.soap.PresekRequest;
import bddm.dto.soap.PresekResponse;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Component
public class IzvodClient extends WebServiceGatewaySupport {

    public PresekResponse requirePresek(DTOPresekZahtev dto, int port) {
        PresekRequest request = new PresekRequest();
        request.setZahtev(dto);
        String uri = "http://localhost:" + port + "/ws";
        PresekResponse response = (PresekResponse) getWebServiceTemplate()
                .marshalSendAndReceive(uri, request);

        return response;
    }
}
