package com.xokker;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.InputStream;

/**
 * @author Ernest Sadykov
 * @since 26.09.2015
 */
public class CustomersReader {

    private final JAXBContext jaxbContext;
    private final Schema schema;

    public CustomersReader() {
        try {
            jaxbContext = JAXBContext.newInstance(Customers.class);
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            schema = schemaFactory.newSchema(ClassLoader.getSystemClassLoader().getResource("customers.xsd"));
        } catch (JAXBException | SAXException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Customers read(InputStream stream) throws JAXBException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setSchema(schema);

        return (Customers) unmarshaller.unmarshal(stream);
    }
}
