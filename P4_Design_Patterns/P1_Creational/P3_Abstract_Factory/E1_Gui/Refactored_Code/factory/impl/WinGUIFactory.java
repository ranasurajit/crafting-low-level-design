package P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.factory.impl;

import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.controls.IButton;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.controls.ITextbox;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.controls.impl.WinButton;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.controls.impl.WinTextBox;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.factory.IGUIFactory;

public class WinGUIFactory implements IGUIFactory {
    @Override
    public IButton createButton() {
        System.out.println("Created Windows Button");
        return new WinButton();
    }

    @Override
    public ITextbox createTextbox() {
        System.out.println("Created Windows Textbox");
        return new WinTextBox();
    }
}
