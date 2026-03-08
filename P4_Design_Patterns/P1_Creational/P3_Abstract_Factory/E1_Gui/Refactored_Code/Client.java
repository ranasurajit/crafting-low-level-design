package P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code;

import java.util.Scanner;

import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.controls.IButton;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.controls.ITextbox;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.factory.GUIFactoryProvider;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.factory.IGUIFactory;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Refactored_Code.model.OSTypeEnum;

public class Client {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter the OS type ['mac', 'windows', 'win', 'linux'] : ");
            String osType = scanner.nextLine().trim().toUpperCase();
            OSTypeEnum osTypeEnum = OSTypeEnum.valueOf(osType);
            IGUIFactory guiFactory = GUIFactoryProvider.getGUIFactory(osTypeEnum);
            IButton button = guiFactory.createButton();
            ITextbox textbox = guiFactory.createTextbox();
            button.press();
            textbox.setText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
