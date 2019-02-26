package com.abnamro.futuretransactions.report.model;

import java.util.Date;
import java.util.Objects;

/**
 * Encapsulates product information. Used for grouping records.
 *
 */
public class ProductInfo {
    private String productGroupCode = "";
    private String exchangeCode = "";
    private String symbol = "";
    private Date expirationDate;

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

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ProductInfo)) {
            return false;
        }
        ProductInfo productInfo = (ProductInfo) obj;

        return productGroupCode.equals(productInfo.getProductGroupCode())
                && exchangeCode.equals(productInfo.getExchangeCode()) && symbol.equals(productInfo.getSymbol())
                && ((expirationDate == null && productInfo.getExpirationDate() == null)
                        || (expirationDate.equals(productInfo.getExpirationDate())));

    }

    @Override
    public int hashCode() {
        return Objects.hash(productGroupCode, exchangeCode, symbol, expirationDate);
    }

    @Override
    public String toString() {
        return exchangeCode + "," + productGroupCode + "," + symbol + "," + expirationDate;
    }
}
