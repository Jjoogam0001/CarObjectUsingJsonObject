package Lexicon.CarStillPlusJson.Model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import sun.text.resources.uk.JavaTimeSupplementary_uk;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonIO {
    private ObjectMapper objectMapper;

    public JsonIO(){
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_WITH_ZONE_ID,false);
        objectMapper.registerModule(new JavaTimeModule());


    }
    public void serializeToJson(List source, File file) throws IOException {
        if (!file.exists()){
            file.createNewFile();
        }
        objectMapper.writeValue(file,source);
    }

   public void deserializeFromJson(File file) throws IOException{
        List<Owner> owners = objectMapper.readValue(file, new TypeReference<List<Owner>>() {
        });

    for (Owner owner : owners) {
        System.out.println(owner.getFirstanme());
        System.out.println(owner.getLastname());
        System.out.println(owner.getOwnerId());
        System.out.println(owner.getOwnedCars());
        System.out.println(owner.getAge());
        System.out.println(owner.getPassword());

    }
}


}
