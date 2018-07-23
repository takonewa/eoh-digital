
package za.co.digitalplatoon.invoiceservices.invoice.data.jpa.domain;



import javax.validation.constraints.*;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long 			id;
	@NotNull(message = "Invoice client is require")
	private String 			client;
	@Min(message="Vat cannot be less than 0", value=0)
	private Long 			vatRate;
	@NotNull(message = "Invoice date is require")
	private Date 			invoiceDate;
	@OneToMany(cascade = CascadeType.ALL)
	private List<LineItem> 	lineItems;

	protected Invoice() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Long getVatRate() {
		return vatRate;
	}

	public void setVatRate(Long vatRate) {
		this.vatRate = vatRate;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public BigDecimal getSubTotal(){
		BigDecimal	total	=	BigDecimal.valueOf(0);
		for(LineItem item: lineItems){
			total = total.add(item.getLineItemTotal());
		}
		return(total);
	}

	public BigDecimal getVat(){
		return(getSubTotal().multiply(BigDecimal.valueOf(getVatRate()).divide(BigDecimal.valueOf(100))));
	}

	public BigDecimal getTotal(){
		return(getSubTotal().add(getVat()));
	}

	@Override
	public String toString() {
		return(String.format("{id :%d, client: %s, vatRate: %s," +
							" invoiceDate: %s, lineItems: %s}", id, client,
							vatRate, invoiceDate, getLineItems().toString(), this.getVat()));
	}
}
