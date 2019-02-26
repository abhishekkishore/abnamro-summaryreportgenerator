package com.abnamro.futuretransactions.report.model;

import java.util.Date;

/**
 * Represents a future transaction record. Interpreted as a fixed length record using
 * input_mapping.xml.
 *
 */
public class FutureTransactionRecord implements InputRecord {

    private String recordCode;
    private String clientType;
    private String clientNumber;
    private String accountNumber;
    private String subAccountNumber;
    private String oppositePartyCode;
    private String productGroupCode;
    private String exchangeCode;
    private String symbol;
    private Date expirationDate;
    private String currencyCode;
    private String movementCode;
    private String buySellCode;
    private String quantityLongSign;
    private Long quantityLong;
    private String quantityShortSign;
    private Long quantityShort;
    private String exchangeBrokerFeeDec;
    private String exchangeBrokerFeeDC;
    private String exchangeBrokerFeeCurCode;
    private String clearingFeeDec;
    private String clearingFeeDC;
    private String clearingFeeCurCode;
    private String commission;
    private String commissionDC;
    private String commissionCurCode;
    private Date transactionDate;
    private String futureReference;
    private String ticketNumber;
    private String externalNumber;
    private String transactionPriceDec;
    private String traderInitials;
    private String oppositeTraderId;
    private String openCloseCode;

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSubAccountNumber() {
        return subAccountNumber;
    }

    public void setSubAccountNumber(String subAccountNumber) {
        this.subAccountNumber = subAccountNumber;
    }

    public String getOppositePartyCode() {
        return oppositePartyCode;
    }

    public void setOppositePartyCode(String oppositePartyCode) {
        this.oppositePartyCode = oppositePartyCode;
    }

    public String getProductGroupCode() {
        return productGroupCode;
    }

    public void setProductGroupCode(String productGroupCode) {
        this.productGroupCode = productGroupCode;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getMovementCode() {
        return movementCode;
    }

    public void setMovementCode(String movementCode) {
        this.movementCode = movementCode;
    }

    public String getBuySellCode() {
        return buySellCode;
    }

    public void setBuySellCode(String buySellCode) {
        this.buySellCode = buySellCode;
    }

    public String getQuantityLongSign() {
        return quantityLongSign;
    }

    public void setQuantityLongSign(String quantityLongSign) {
        this.quantityLongSign = quantityLongSign;
    }

    public Long getQuantityLong() {
        return quantityLong;
    }

    public void setQuantityLong(Long quantityLong) {
        this.quantityLong = quantityLong;
    }

    public String getQuantityShortSign() {
        return quantityShortSign;
    }

    public void setQuantityShortSign(String quantityShortSign) {
        this.quantityShortSign = quantityShortSign;
    }

    public Long getQuantityShort() {
        return quantityShort;
    }

    public void setQuantityShort(Long quantityShort) {
        this.quantityShort = quantityShort;
    }

    public String getExchangeBrokerFeeDec() {
        return exchangeBrokerFeeDec;
    }

    public void setExchangeBrokerFeeDec(String exchangeBrokerFeeDec) {
        this.exchangeBrokerFeeDec = exchangeBrokerFeeDec;
    }

    public String getExchangeBrokerFeeDC() {
        return exchangeBrokerFeeDC;
    }

    public void setExchangeBrokerFeeDC(String exchangeBrokerFeeDC) {
        this.exchangeBrokerFeeDC = exchangeBrokerFeeDC;
    }

    public String getExchangeBrokerFeeCurCode() {
        return exchangeBrokerFeeCurCode;
    }

    public void setExchangeBrokerFeeCurCode(String exchangeBrokerFeeCurCode) {
        this.exchangeBrokerFeeCurCode = exchangeBrokerFeeCurCode;
    }

    public String getClearingFeeDec() {
        return clearingFeeDec;
    }

    public void setClearingFeeDec(String clearingFeeDec) {
        this.clearingFeeDec = clearingFeeDec;
    }

    public String getClearingFeeDC() {
        return clearingFeeDC;
    }

    public void setClearingFeeDC(String clearingFeeDC) {
        this.clearingFeeDC = clearingFeeDC;
    }

    public String getClearingFeeCurCode() {
        return clearingFeeCurCode;
    }

    public void setClearingFeeCurCode(String clearingFeeCurCode) {
        this.clearingFeeCurCode = clearingFeeCurCode;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getCommissionDC() {
        return commissionDC;
    }

    public void setCommissionDC(String commissionDC) {
        this.commissionDC = commissionDC;
    }

    public String getCommissionCurCode() {
        return commissionCurCode;
    }

    public void setCommissionCurCode(String commissionCurCode) {
        this.commissionCurCode = commissionCurCode;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getFutureReference() {
        return futureReference;
    }

    public void setFutureReference(String futureReference) {
        this.futureReference = futureReference;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getExternalNumber() {
        return externalNumber;
    }

    public void setExternalNumber(String externalNumber) {
        this.externalNumber = externalNumber;
    }

    public String getTransactionPriceDec() {
        return transactionPriceDec;
    }

    public void setTransactionPriceDec(String transactionPriceDec) {
        this.transactionPriceDec = transactionPriceDec;
    }

    public String getTraderInitials() {
        return traderInitials;
    }

    public void setTraderInitials(String traderInitials) {
        this.traderInitials = traderInitials;
    }

    public String getOppositeTraderId() {
        return oppositeTraderId;
    }

    public void setOppositeTraderId(String oppositeTraderId) {
        this.oppositeTraderId = oppositeTraderId;
    }

    public String getOpenCloseCode() {
        return openCloseCode;
    }

    public void setOpenCloseCode(String openCloseCode) {
        this.openCloseCode = openCloseCode;
    }

    @Override
    public String toString() {
        return "client number: " + clientNumber + ", client type: " + clientType + ", account number: " + accountNumber
                + ", sub account number: " + subAccountNumber + ", product group code: " + productGroupCode
                + ", exchange code:" + exchangeCode + ", symbol:" + symbol + ", expiration date: " + expirationDate
                + ", transaction date: " + transactionDate;
    }
}
