/**
 *
 *  @author Radzewicz Michał S21148
 *
 */
package zad1;
import java.beans.*;

public class AccountChange implements VetoableChangeListener {
    @Override
    public void vetoableChange(PropertyChangeEvent e) {
        double oldValue = (Double) e.getOldValue();
        double newValue = (Double) e.getNewValue();
        if (newValue < 0)
            System.out.println(e.getPropertyName() + "Value changed from " + oldValue + " to " + newValue + ", balance < 0!");
        else
            System.out.println(e.getPropertyName() + "Value changed from " + oldValue + " to " + newValue);
    }
}
