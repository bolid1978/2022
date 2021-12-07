package JSON;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class JSON {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        SomeDate someDate =  new SomeDate();
        someDate.setDate(123);
        someDate.setDateString("Строка");
        someDate.setB(true);

        StringWriter someDateJson = new StringWriter();
        objectMapper.writeValue(someDateJson, someDate);
        String str = objectMapper.writeValueAsString(someDate);
        System.out.println(str);
       // System.out.println(someDateJson.toString());


    }
}
