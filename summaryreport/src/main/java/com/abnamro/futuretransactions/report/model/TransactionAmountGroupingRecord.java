package com.abnamro.futuretransactions.report.model;

/**
 * Represents an output record based on grouping done via {@link SummaryRecord}.
 * Interpreted as a CSV using output_mapping.xml.
 *
 */
public class TransactionAmountGroupingRecord implements OutputRecord {
    private String clientInformation;
    private String productInformation;
    private String totalTransactionAmount;

    public String getClientInformation() {
        return clientInformation;
    }

    public void setClientInformation(String clientInformation) {
        this.clientInformation = clientInformation;
    }

    public String getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation;
    }

    public String getTotalTransactionAmount() {
        return totalTransactionAmount;
    }

    public void setTotalTransactionAmount(String totalTransactionAmount) {
        this.totalTransactionAmount = totalTransactionAmount;
    }
}
