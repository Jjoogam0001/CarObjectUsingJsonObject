package Lexicon.CarStillPlusJson.Model;

import Lexicon.CarStillPlusJson.Model.Utils.PasswordUtils;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Owner implements Serializable {
    private final UUID ownerId = UUID.randomUUID();
    private String firstanme ;
    private String lastname;
    private int age;
    private transient String password ;

    @JsonManagedReference
    private List<Car> ownedCars;

    public Owner() {
        super();
    }

    public Owner(String firstanme, String lastname, int age, String password, List<Car> ownedCars) {
        this.firstanme = firstanme;
        this.lastname = lastname;
        this.age = age;
        this.ownedCars = ownedCars;
        String salt = PasswordUtils.getSalt(30);
        String hashedpassword = PasswordUtils.generateSecurePassword(password,salt);
        this.password = hashedpassword;

    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public String getFirstanme() {
        return firstanme;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public List<Car> getOwnedCars() {
        return ownedCars;
    }


}
