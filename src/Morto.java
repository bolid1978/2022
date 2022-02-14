import org.apache.log4j.xml.DOMConfigurator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Morto {
    public static final Logger LOGGER = LoggerFactory.getLogger(Morto.class);


    public static void main(String[] args) {
        //  @BeforeClass
        DOMConfigurator.configure("C:\\Users\\bolid\\IdeaProjects\\Test\\src\\log4j2.xml");
        LOGGER.error("Начало работы программы!!!");
        LOGGER.info("Пошла жара");

        try {
            LOGGER.warn("Внимание! Программа пытается разделить одно число на другое");
            System.out.println(12/0);
        } catch (ArithmeticException x) {

            LOGGER.error("Ошибка! Произошло деление на ноль!");
        }
    }
}
