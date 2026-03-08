package P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.controls.impl;

import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.controls.IButton;

public class MacButton implements IButton {
    @Override
    public void press() {
        System.out.println("Mac button pressed");
    }
}
