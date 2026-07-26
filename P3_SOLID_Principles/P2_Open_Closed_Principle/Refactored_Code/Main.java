package P3_SOLID_Principles.P2_Open_Closed_Principle.Refactored_Code;

import P3_SOLID_Principles.P2_Open_Closed_Principle.Refactored_Code.models.impl.EmployeePriceCalculator;
import P3_SOLID_Principles.P2_Open_Closed_Principle.Refactored_Code.models.impl.FestivalPriceCalculator;
import P3_SOLID_Principles.P2_Open_Closed_Principle.Refactored_Code.models.impl.NormalPriceCalculator;
import P3_SOLID_Principles.P2_Open_Closed_Principle.Refactored_Code.models.impl.PriceCalculator;
import P3_SOLID_Principles.P2_Open_Closed_Principle.Refactored_Code.models.impl.StudentPriceCalculator;

public class Main {
    public static void main(String[] args) {
        PriceCalculator normalCalculator = new NormalPriceCalculator();
        System.out.println("Final price (student discount): " + normalCalculator.finalPrice(1000));

        PriceCalculator studentCalculator = new StudentPriceCalculator();
        System.out.println("Final price (student discount): " + studentCalculator.finalPrice(1000));

        PriceCalculator festivalCalculator = new FestivalPriceCalculator();
        System.out.println("Final price (festival discount): " + festivalCalculator.finalPrice(1000));

        PriceCalculator employeeCalculator = new EmployeePriceCalculator();
        System.out.println("Final price (employee discount): " + employeeCalculator.finalPrice(1000));
    }
}
