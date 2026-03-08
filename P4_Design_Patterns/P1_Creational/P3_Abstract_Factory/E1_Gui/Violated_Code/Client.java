package P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Violated_Code;

import java.util.Scanner;

import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Violated_Code.controls.IButton;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Violated_Code.controls.ITextbox;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Violated_Code.controls.impl.MacButton;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Violated_Code.controls.impl.MacTextBox;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Violated_Code.controls.impl.WinButton;
import P4_Design_Patterns.P1_Creational.P3_Abstract_Factory.E1_Gui.Violated_Code.controls.impl.WinTextBox;

public class Client {
    public static void main(String[] args) {
        System.out.println("Enter machine OS");
        Scanner scanner = new Scanner(System.in);
        String osType = scanner.nextLine();
        scanner.close();

        IButton button;
        ITextbox textBox;

        // ❌ Problematic Conditional Logic
        if (osType.equals("windows")) {

            button = new WinButton();
            textBox = new WinTextBox();

        } else if (osType.equals("mac")) {

            button = new MacButton();
            textBox = new MacTextBox();

        } else {

            System.out.println("Invalid OS type");
            return;
        }

        button.press();
        textBox.setText();
    }
}
