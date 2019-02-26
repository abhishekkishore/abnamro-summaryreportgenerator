package com.abnamro.futuretransactions.report.model;

import java.util.Objects;

/**
 * Encapsulates client information. Used for grouping records.
 *
 */
public class ClientInfo {
    private String clientType = "";
    private String clientNumber = "";
    private String accountNumber = "";
    private String subAccountNumber = "";

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
//        if ((clientType == null && clientInfo.getClientType() != null)
//                || (clientType != null && clientInfo.getClientType() == null)
//                || (clientNumber == null && clientInfo.getClientNumber() != null)
//                || (clientNumber != null && clientInfo.getClientNumber() == null)
//                || (accountNumber == null && clientInfo.getAccountNumber() != null)
//                || (accountNumber != null && clientInfo.getAccountNumber() == null)
//                || (subAccountNumber == null && clientInfo.getSubAccountNumber() != null)
//                || (subAccountNumber != null && clientInfo.getSubAccountNumber() == null)) {
//            return false;
//        }

        return clientInfo.getAccountNumber().equals(accountNumber) && clientInfo.getClientNumber().equals(clientNumber)
                && clientInfo.getClientType().equals(clientType)
                && clientInfo.getSubAccountNumber().equals(subAccountNumber);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return Objects.hash(accountNumber, subAccountNumber, clientNumber, clientType);
    }

    @Override
    public String toString() {
        return clientType + "," + clientNumber + "," + accountNumber + "," + subAccountNumber;
    }
}
