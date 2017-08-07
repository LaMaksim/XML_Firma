package bddm.client;

import bddm.dto.soap.DTOUplatnica;
import bddm.dto.soap.UplatnicaRequest;
import bddm.dto.soap.UplatnicaResponse;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Component
public class UplatnicaClient extends WebServiceGatewaySupport {

    public UplatnicaResponse payUplatnica(DTOUplatnica dtoUplatnica) {

        UplatnicaRequest request = new UplatnicaRequest();
        request.setUplatnica(dtoUplatnica);
        UplatnicaResponse response = (UplatnicaResponse) getWebServiceTemplate()
                //.marshalSendAndReceive("http://localhost:8084/ws/bussinessBank", request);
                .marshalSendAndReceive("http://localhost:8084/ws", request);
        return response;

    }
}
