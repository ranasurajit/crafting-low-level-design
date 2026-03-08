package P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.factory;

import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.factory.impl.MacGUIFactory;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.factory.impl.WinGUIFactory;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.model.OSTypeEnum;

public class GUIFactoryProvider {
    public static IGUIFactory getGUIFactory(OSTypeEnum osType) {
        switch (osType) {
            case MAC:
                return new MacGUIFactory();
            case WINDOWS:
            case WIN:
                return new WinGUIFactory();
            case LINUX:
                throw new UnsupportedOperationException("Linux UI not implemented");
            default:
                throw new IllegalArgumentException("Unsupported OS: " + osType);
        }
    }
}
