package za.co.digitalplatoon.invoiceservices.invoice.data.jpa.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Test {

    public static void main(String ...args){
        LineItem item   =   new LineItem();
        Long qty    =   19L;
        item.setQuantity(qty);
        item.setId(Long.valueOf(2));
        item.setUnitPrice(BigDecimal.valueOf(30));
        item.setDescription("Sugar");

        System.err.println("Item :"+item);
        System.err.println("Invoice Total :"+item.getLineItemTotal());

        LineItem item1   =   new LineItem();
        item1.setQuantity(qty);
        item1.setId(Long.valueOf(2));
        item1.setUnitPrice(BigDecimal.valueOf(30));
        item1.setDescription("Sugar");


        Invoice invoice =   new Invoice();

        invoice.getLineItems().add(item);
        invoice.getLineItems().add(item1);
        invoice.setVatRate(Long.valueOf(14));
        invoice.setClient("TK");
        invoice.setId(Long.valueOf(2));
        invoice.setInvoiceDate(new Date());

        System.err.println("Invoice :"+invoice);
        System.err.println("Invoice Total :"+invoice.getTotal());
    }
}
