package cycleSpring.cycleAuth;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String userName;

    private String passWord;

    public String getUserName() {
    	return this.userName;
    }
    
    public String getPassword() {
    	return this.passWord;
    }
}
