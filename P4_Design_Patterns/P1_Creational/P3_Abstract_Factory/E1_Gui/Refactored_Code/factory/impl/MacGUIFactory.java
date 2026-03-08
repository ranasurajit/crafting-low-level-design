package P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.factory.impl;

import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.controls.IButton;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.controls.ITextbox;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.controls.impl.MacButton;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.controls.impl.MacTextBox;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.factory.IGUIFactory;

public class MacGUIFactory implements IGUIFactory {
    @Override
    public IButton createButton() {
        System.out.println("Created Mac Button");
        return new MacButton();
    }

    @Override
    public ITextbox createTextbox() {
        System.out.println("Created Mac Textbox");
        return new MacTextBox();
    }
}
