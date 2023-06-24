
package org.my.homeworks.ws.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;

import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "OrderServiceImplService", targetNamespace = "http://homeworks.my.org/", wsdlLocation = "file:/C:/Users/Dimidow/Hillel%20HW/Hillel-Java-Pro-23.01.2023/HW31/src/main/resources/OrderService.wsdl")
public class OrderServiceImplService
    extends Service
{

    private final static URL ORDERSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException ORDERSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName ORDERSERVICEIMPLSERVICE_QNAME = new QName("http://homeworks.my.org/", "OrderServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/Dimidow/Hillel%20HW/Hillel-Java-Pro-23.01.2023/HW31/src/main/resources/OrderService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ORDERSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        ORDERSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public OrderServiceImplService() {
        super(__getWsdlLocation(), ORDERSERVICEIMPLSERVICE_QNAME);
    }

    public OrderServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ORDERSERVICEIMPLSERVICE_QNAME, features);
    }

    public OrderServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, ORDERSERVICEIMPLSERVICE_QNAME);
    }

    public OrderServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ORDERSERVICEIMPLSERVICE_QNAME, features);
    }

    public OrderServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OrderServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns OrderService
     */
    @WebEndpoint(name = "OrderServiceImplPort")
    public OrderService getOrderServiceImplPort() {
        return super.getPort(new QName("http://homeworks.my.org/", "OrderServiceImplPort"), OrderService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OrderService
     */
    @WebEndpoint(name = "OrderServiceImplPort")
    public OrderService getOrderServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://homeworks.my.org/", "OrderServiceImplPort"), OrderService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ORDERSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw ORDERSERVICEIMPLSERVICE_EXCEPTION;
        }
        return ORDERSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
