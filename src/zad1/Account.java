/**
 *
 *  @author Radzewicz Michał S21148
 *
 */
package zad1;

import java.beans.*;

public class Account {
    private double balance;
    private final int number;
    private static int count = 0;

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private final VetoableChangeSupport vetoableChangeSupport = new VetoableChangeSupport(this);

    Account() {
        this.balance = 0;
        this.number = ++count;
    }

    Account(double balance) {
        this.balance = balance;
        this.number = ++count;
    }

    public void deposit(double money) throws PropertyVetoException {
        setBalance(money);
    }

    public void withdraw(double money) throws PropertyVetoException {
        setBalance(balance - money);
    }

    public void transfer(Account account, double money) throws PropertyVetoException {
        setTransfer(account, money);
    }

    private synchronized void setTransfer(Account account, double balance) throws PropertyVetoException {
        setBalance(this.balance - balance);
        account.setBalance(account.balance + balance);
    }

    private synchronized void setBalance(double balance) throws PropertyVetoException {
        double oldValue = this.balance;
        vetoableChangeSupport.fireVetoableChange(number + ": ", oldValue, balance);
        this.balance = balance;
        propertyChangeSupport.firePropertyChange(number + ": ", oldValue, balance);
    }

    public synchronized void addVetoableChangeListener(VetoableChangeListener vetoableChangeListener) {
        vetoableChangeSupport.addVetoableChangeListener(vetoableChangeListener);
    }

    public String toString() {
        return "Acc " + number + ": " + balance;
    }
}
