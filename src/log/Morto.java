package log;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Morto {
    public static final Logger LOGGER = LoggerFactory.getLogger(Morto.class);

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(12);
        DOMConfigurator.configure("C:\\Users\\sergey\\IdeaProjects\\2022\\src\\log\\2.xml");
        LOGGER.info("Начало работы программы!!!");
        LOGGER.info(arrayList.toString(),arrayList);

        try {
            LOGGER.warn("Внимание! Программа пытается разделить одно число на другое");
            System.out.println(12/0);
        } catch (ArithmeticException x) {

            LOGGER.error("Ошибка! Произошло деление на ноль!");
        }
    }

}


