/**
 *
 *  @author Radzewicz Michał S21148
 *
 */
package zad1;

import java.beans.*;

public class AccountLimitator implements VetoableChangeListener {
    private final double minValue;

    AccountLimitator(double value) {
        this.minValue = value;
    }

    @Override
    public void vetoableChange(PropertyChangeEvent e) throws PropertyVetoException {
        double val = (Double) e.getNewValue();
        if (val < minValue)
            throw new PropertyVetoException(e.getPropertyName() + "Unacceptable value change: " + val, e);
    }
}
