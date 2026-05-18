package P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code.builders;

import P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code.models.CPU;

public abstract class CPUBuilder {
    protected CPU cpu = new CPU();

    public abstract void buildBrand();

    public abstract void buildProcessor();

    public abstract void buildGPU();

    public abstract void buildSMPS();

    public abstract void buildNeuralEngine();

    public abstract void buildRAM();

    public CPU getCPUInfo() {
        return cpu;
    }
}
