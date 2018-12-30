package sec.project.domain;

import database.Database;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Signup extends AbstractPersistable<Long> implements Serializable {

    private String name;
    private String address;

    public Signup() {
        super();
    }

    public Signup(String name, String address
    //            , String db
    ) {
        this();
        //    setDb(new Database());
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Signup{" + "name=" + name + ", address=" + address + '}' //                +" DB: "+db
                ;
    }

}
