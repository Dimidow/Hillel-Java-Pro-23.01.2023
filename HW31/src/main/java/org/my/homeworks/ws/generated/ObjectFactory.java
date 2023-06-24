
package org.my.homeworks.ws.generated;

import javax.xml.namespace.QName;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.my.homeworks package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddOrder_QNAME = new QName("http://homeworks.my.org/", "addOrder");
    private final static QName _AddOrderResponse_QNAME = new QName("http://homeworks.my.org/", "addOrderResponse");
    private final static QName _GetAllOrders_QNAME = new QName("http://homeworks.my.org/", "getAllOrders");
    private final static QName _GetAllOrdersResponse_QNAME = new QName("http://homeworks.my.org/", "getAllOrdersResponse");
    private final static QName _GetOrderById_QNAME = new QName("http://homeworks.my.org/", "getOrderById");
    private final static QName _GetOrderByIdResponse_QNAME = new QName("http://homeworks.my.org/", "getOrderByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.my.homeworks
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddOrder }
     * 
     */
    public AddOrder createAddOrder() {
        return new AddOrder();
    }

    /**
     * Create an instance of {@link AddOrderResponse }
     * 
     */
    public AddOrderResponse createAddOrderResponse() {
        return new AddOrderResponse();
    }

    /**
     * Create an instance of {@link GetAllOrders }
     * 
     */
    public GetAllOrders createGetAllOrders() {
        return new GetAllOrders();
    }

    /**
     * Create an instance of {@link GetAllOrdersResponse }
     * 
     */
    public GetAllOrdersResponse createGetAllOrdersResponse() {
        return new GetAllOrdersResponse();
    }

    /**
     * Create an instance of {@link GetOrderById }
     * 
     */
    public GetOrderById createGetOrderById() {
        return new GetOrderById();
    }

    /**
     * Create an instance of {@link GetOrderByIdResponse }
     * 
     */
    public GetOrderByIdResponse createGetOrderByIdResponse() {
        return new GetOrderByIdResponse();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddOrder }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddOrder }{@code >}
     */
    @XmlElementDecl(namespace = "http://homeworks.my.org/", name = "addOrder")
    public JAXBElement<AddOrder> createAddOrder(AddOrder value) {
        return new JAXBElement<AddOrder>(_AddOrder_QNAME, AddOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddOrderResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddOrderResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://homeworks.my.org/", name = "addOrderResponse")
    public JAXBElement<AddOrderResponse> createAddOrderResponse(AddOrderResponse value) {
        return new JAXBElement<AddOrderResponse>(_AddOrderResponse_QNAME, AddOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllOrders }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllOrders }{@code >}
     */
    @XmlElementDecl(namespace = "http://homeworks.my.org/", name = "getAllOrders")
    public JAXBElement<GetAllOrders> createGetAllOrders(GetAllOrders value) {
        return new JAXBElement<GetAllOrders>(_GetAllOrders_QNAME, GetAllOrders.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllOrdersResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllOrdersResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://homeworks.my.org/", name = "getAllOrdersResponse")
    public JAXBElement<GetAllOrdersResponse> createGetAllOrdersResponse(GetAllOrdersResponse value) {
        return new JAXBElement<GetAllOrdersResponse>(_GetAllOrdersResponse_QNAME, GetAllOrdersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetOrderById }{@code >}
     */
    @XmlElementDecl(namespace = "http://homeworks.my.org/", name = "getOrderById")
    public JAXBElement<GetOrderById> createGetOrderById(GetOrderById value) {
        return new JAXBElement<GetOrderById>(_GetOrderById_QNAME, GetOrderById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetOrderByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://homeworks.my.org/", name = "getOrderByIdResponse")
    public JAXBElement<GetOrderByIdResponse> createGetOrderByIdResponse(GetOrderByIdResponse value) {
        return new JAXBElement<GetOrderByIdResponse>(_GetOrderByIdResponse_QNAME, GetOrderByIdResponse.class, null, value);
    }

}
