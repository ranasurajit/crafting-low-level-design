package P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.factory;

import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.controls.IButton;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.controls.ITextbox;

public interface IGUIFactory {
    public IButton createButton();

    public ITextbox createTextbox();
}
