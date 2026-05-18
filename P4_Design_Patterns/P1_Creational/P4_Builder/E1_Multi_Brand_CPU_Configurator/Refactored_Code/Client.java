package P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code;

import P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code.builders.impl.AMDCPUBuilder;
import P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code.builders.impl.AppleCPUBuilder;
import P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code.builders.impl.IntelCPUBuilder;
import P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code.directors.CPUDirector;
import P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code.models.CPU;

public class Client {
    public static void main(String[] args) {
        CPUDirector intelCPUDirector = new CPUDirector(new IntelCPUBuilder());
        CPU intelCPU = intelCPUDirector.buildCPU();
        intelCPU.getCPUInfo();

        CPUDirector amdCPUDirector = new CPUDirector(new AMDCPUBuilder());
        CPU amdCPU = amdCPUDirector.buildCPU();
        amdCPU.getCPUInfo();

        CPUDirector appleCPUDirector = new CPUDirector(new AppleCPUBuilder());
        CPU appleCPU = appleCPUDirector.buildCPU();
        appleCPU.getCPUInfo();
    }
}
