package com.MyRH.MyRH.Helpers;

public interface Enum {
    enum role {ResHuman, AGENT}
    enum statusVal {Pending, Confirmed, Rejected}
    enum transactionType {Transfer, Withdrawal, Deposit, OnlinePayment, BillPayment}
    enum accType {Standard, Professional}
    enum bills {Phone, Water, Electricity}
    enum dotationType {National, International}
}
