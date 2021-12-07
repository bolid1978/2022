package XML;

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.io.StringWriter;

public class Convert {
    public static void main(String[] args) throws JAXBException {
        String object = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<yamaha>\n" +
                "    <model>525</model>\n" +
                "    <name>BMW</name>\n" +
                "</yamaha>";
        Car car = new Car();
        car.setName("BMW");
        car.setModel(525);
       // Car.Moto h = new Car.Moto();

        //-----
        StringReader reader = new StringReader(object);

        JAXBContext contextOne = JAXBContext.newInstance(Car.class);
        Unmarshaller unmarshaller = contextOne.createUnmarshaller();

        Car carXml = (Car) unmarshaller.unmarshal(reader);
        carXml.setModel(550);
        carXml.setName("Ferrari");

        //писать результат сериализации будем в Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // сама сериализация
        marshaller.marshal(carXml, writer);
        //  marshaller.marshal(h, writer);

        //преобразовываем в строку все записанное в StringWriter

        System.out.println(writer.toString());
    }
}
