package Lexicon.CarStillPlusJson;

import Lexicon.CarStillPlusJson.Model.Car;
import Lexicon.CarStillPlusJson.Model.JsonIO;
import Lexicon.CarStillPlusJson.Model.Owner;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args )
    {


        List<Car> Cars = Arrays.asList(new Car("UEW 731","Mazda","2013 COMBI 2.1",LocalDate.parse("2007-11-10")),
                new Car("TBH 367","DOGDE","2014 SUV carnival",LocalDate.parse("2003-11-23")));
        List<Car> cars2 = Arrays.asList(new Car("UWS 765", "BENZ","2019 E220", LocalDate.parse("2020-11-10")), new Car("KTH 730","OPEL","2010 T.12I ", LocalDate.parse("2020-08-23")));
        List<Owner> owners = Arrays.asList(new Owner("Martin","Mujemya",26,"Namagela123",Cars),new Owner("Kennedy","Marcus",27,"ELVIS2017",cars2));


        JsonIO JsonIO = new JsonIO();
        try {
            List<Owner> ownersback = new ArrayList<>();
            JsonIO.serializeToJson(owners,new File("owners.json"));
            JsonIO.serializeToJson(Cars,new File("cars.json"));
            JsonIO.deserializeFromJson(new File("owners.json"));


        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
