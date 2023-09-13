package cycleSpring.cycleAuth;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CycleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private int stockCount;

    public int getStockCount() {
    	return this.stockCount;
    }
    
    public void setStockCount(int count) {
    	this.stockCount = count;
    }
}
