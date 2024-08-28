
package net.ahmed.customer_service.web;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.ahmed.customer_service.web package. 
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

    private final static QName _CustomersList_QNAME = new QName("http://web.customer_service.ahmed.net/", "customersList");
    private final static QName _CustomersListResponse_QNAME = new QName("http://web.customer_service.ahmed.net/", "customersListResponse");
    private final static QName _GetCustomerById_QNAME = new QName("http://web.customer_service.ahmed.net/", "getCustomerById");
    private final static QName _GetCustomerByIdResponse_QNAME = new QName("http://web.customer_service.ahmed.net/", "getCustomerByIdResponse");
    private final static QName _SaveCustomer_QNAME = new QName("http://web.customer_service.ahmed.net/", "saveCustomer");
    private final static QName _SaveCustomerResponse_QNAME = new QName("http://web.customer_service.ahmed.net/", "saveCustomerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.ahmed.customer_service.web
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomersList }
     * 
     */
    public CustomersList createCustomersList() {
        return new CustomersList();
    }

    /**
     * Create an instance of {@link CustomersListResponse }
     * 
     */
    public CustomersListResponse createCustomersListResponse() {
        return new CustomersListResponse();
    }

    /**
     * Create an instance of {@link GetCustomerById }
     * 
     */
    public GetCustomerById createGetCustomerById() {
        return new GetCustomerById();
    }

    /**
     * Create an instance of {@link GetCustomerByIdResponse }
     * 
     */
    public GetCustomerByIdResponse createGetCustomerByIdResponse() {
        return new GetCustomerByIdResponse();
    }

    /**
     * Create an instance of {@link SaveCustomer }
     * 
     */
    public SaveCustomer createSaveCustomer() {
        return new SaveCustomer();
    }

    /**
     * Create an instance of {@link SaveCustomerResponse }
     * 
     */
    public SaveCustomerResponse createSaveCustomerResponse() {
        return new SaveCustomerResponse();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link CustomerReq }
     * 
     */
    public CustomerReq createCustomerReq() {
        return new CustomerReq();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomersList }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomersList }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customer_service.ahmed.net/", name = "customersList")
    public JAXBElement<CustomersList> createCustomersList(CustomersList value) {
        return new JAXBElement<CustomersList>(_CustomersList_QNAME, CustomersList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomersListResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomersListResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customer_service.ahmed.net/", name = "customersListResponse")
    public JAXBElement<CustomersListResponse> createCustomersListResponse(CustomersListResponse value) {
        return new JAXBElement<CustomersListResponse>(_CustomersListResponse_QNAME, CustomersListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomerById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCustomerById }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customer_service.ahmed.net/", name = "getCustomerById")
    public JAXBElement<GetCustomerById> createGetCustomerById(GetCustomerById value) {
        return new JAXBElement<GetCustomerById>(_GetCustomerById_QNAME, GetCustomerById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomerByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCustomerByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customer_service.ahmed.net/", name = "getCustomerByIdResponse")
    public JAXBElement<GetCustomerByIdResponse> createGetCustomerByIdResponse(GetCustomerByIdResponse value) {
        return new JAXBElement<GetCustomerByIdResponse>(_GetCustomerByIdResponse_QNAME, GetCustomerByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCustomer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveCustomer }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customer_service.ahmed.net/", name = "saveCustomer")
    public JAXBElement<SaveCustomer> createSaveCustomer(SaveCustomer value) {
        return new JAXBElement<SaveCustomer>(_SaveCustomer_QNAME, SaveCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCustomerResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveCustomerResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customer_service.ahmed.net/", name = "saveCustomerResponse")
    public JAXBElement<SaveCustomerResponse> createSaveCustomerResponse(SaveCustomerResponse value) {
        return new JAXBElement<SaveCustomerResponse>(_SaveCustomerResponse_QNAME, SaveCustomerResponse.class, null, value);
    }

}
