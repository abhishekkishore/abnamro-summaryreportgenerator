package com.abnamro.futuretransactions.report.model;

import java.util.Date;
import java.util.Objects;

/**
 * Encapsulates grouping criteria for summary report generation that includes client information,
 * product information and transaction date.
 *
 */
public class SummaryRecord {
    private ClientInfo clientInfo;
    private ProductInfo productInfo;
    private Date transactionDate;

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SummaryRecord)) {
            return false;
        }
        SummaryRecord summaryRecord = (SummaryRecord) obj;

        return clientInfo.equals(summaryRecord.getClientInfo()) && productInfo.equals(summaryRecord.getProductInfo())
                && transactionDate.equals(summaryRecord.getTransactionDate());
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return Objects.hash(clientInfo, productInfo, transactionDate);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return clientInfo.toString() + productInfo.toString() + "," + transactionDate;
    }
}
