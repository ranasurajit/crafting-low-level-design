package P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Violated_Code.controls.impl;

import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Violated_Code.controls.ITextbox;

public class MacTextBox implements ITextbox {
    @Override
    public void setText() {
        System.out.println("Setting text in Mac Textbox");
    }
}
