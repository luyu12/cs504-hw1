package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class UserInfo {

//    @GeneratedValue
//    private final Long id;
    private String username;
    private String address;


    public UserInfo()
    {

    }

    public UserInfo(String username,String address) {
//        this.id = id;
        this.username = username;
        this.address = address;
    }
}
