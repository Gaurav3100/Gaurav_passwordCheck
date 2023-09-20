package cycleSpring.cycleAuth;

import java.util.List;

 

public class CartPaymentDto {
    private List<CycleBasketEntity> cartCycles;
    private int totalPayment;
	public List<CycleBasketEntity> getCartCycles() {
		return cartCycles;
	}
	public void setCartCycles(List<CycleBasketEntity> cartCycles) {
		this.cartCycles = cartCycles;
	}
	public int getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(int totalPayment) {
		this.totalPayment = totalPayment;
	}

 

}
