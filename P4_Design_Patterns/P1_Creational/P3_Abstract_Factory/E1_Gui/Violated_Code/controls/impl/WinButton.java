package P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Violated_Code.controls.impl;

import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Violated_Code.controls.IButton;

public class WinButton implements IButton {
    @Override
    public void press() {
        System.out.println("Win button pressed");
    }
}
