package cycleSpring.cycleAuth;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class Transaction {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	 	private String username;
	 	
	 	@ManyToMany
	 	@JoinColumn(name="Items", referencedColumnName = "cycle",insertable=false, updatable=false)
	    private List<CycleBasketEntity> Items;

	    private int totalPrice;
	    
	    
	    @Temporal(value=TemporalType.TIMESTAMP )
	    private Date purchasedTime;
	    
	    public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		

		public String getUserName() {
			return username;
		}

		public void setUserName(String userName) {
			this.username = userName;
		}

		public List<CycleBasketEntity> getItems() {
			return Items;
		}

		public void setItems(List<CycleBasketEntity> items) {
			Items = items;
		}

		public int getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(int totalPrice) {
			this.totalPrice = totalPrice;
		}

		public Date getPurchasedTime() {
			return purchasedTime;
		}

		public void setPurchasedTime(Date purchasedTime) {
			this.purchasedTime = purchasedTime;
		}

		@Override
	    public String toString() {
	    	StringBuilder sb = new StringBuilder();
	        sb.append("[");
	        
	        if (Items != null && !Items.isEmpty()) {
	            for (CycleBasketEntity cycle : Items) {
	                sb.append(cycle.toString()).append(", ");
	            }
	            sb.delete(sb.length() - 2, sb.length()); // Remove the trailing ", "
	        }
	        
	        sb.append("]");
	        
	        return sb.toString();
	    }
}
