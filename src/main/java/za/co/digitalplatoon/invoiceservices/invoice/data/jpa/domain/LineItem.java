
package za.co.digitalplatoon.invoiceservices.invoice.data.jpa.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class LineItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long 		id;
	@Min(message="Quantity cannot be less than 0", value=0)
	private Long 		quantity;
	@NotNull(message = "Item description required")
	private String 		description;
	@Min(message="Unit cannot be negative", value=0)
	private BigDecimal	unitPrice;


	protected LineItem() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getLineItemTotal(){
		return(getUnitPrice().multiply(BigDecimal.valueOf(getQuantity())));
	}


	@Override
	public String toString() {
		return(String.format("{id: %d, quantity: %d, description: %s}",id,  quantity, description));
	}
}
