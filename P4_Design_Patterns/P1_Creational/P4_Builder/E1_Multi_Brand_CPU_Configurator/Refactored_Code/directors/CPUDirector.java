package P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code.directors;

import P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code.builders.CPUBuilder;
import P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code.models.CPU;

public class CPUDirector {
    private CPUBuilder builder;

    public CPUDirector(CPUBuilder builder) {
        this.builder = builder;
    }

    public CPU buildCPU() {
        builder.buildBrand();
        builder.buildProcessor();
        builder.buildGPU();
        builder.buildSMPS();
        builder.buildNeuralEngine();
        builder.buildRAM();
        return builder.getCPUInfo();
    }
}
