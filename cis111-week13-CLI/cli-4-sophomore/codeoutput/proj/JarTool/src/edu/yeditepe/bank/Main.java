package edu.yeditepe.bank;

public class Main {
    public static void main(String[] args) {
        Account a = new Account("Ayşe");
        a.deposit(12_550);
        a.deposit(499);
        System.out.println(a);
    }
}
