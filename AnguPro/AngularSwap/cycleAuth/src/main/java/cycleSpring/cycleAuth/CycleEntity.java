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

    private int numBorrowed;
    
    private int price;

    public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStockCount() {
    	return this.stockCount;
    }
    
    public void setStockCount(int count) {
    	this.stockCount = count;
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumBorrowed() {
		return numBorrowed;
	}

	public void setNumBorrowed(int numBorrowed) {
		this.numBorrowed = numBorrowed;
	}
}
