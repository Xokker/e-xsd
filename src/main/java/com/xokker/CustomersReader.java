package com.xokker;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Ernest Sadykov
 * @since 26.09.2015
 */
@Service
public class CustomersReader {

    private final JAXBContext jaxbContext;
    private final Schema schema;

    public CustomersReader() {
        try {
            jaxbContext = JAXBContext.newInstance(Customers.class);
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Resource resource = new ClassPathResource("customers.xsd");
            schema = schemaFactory.newSchema(resource.getFile());
        } catch (JAXBException | SAXException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }     }

    public Customers read(InputStream stream) throws JAXBException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setSchema(schema);

        return (Customers) unmarshaller.unmarshal(stream);
    }
}
