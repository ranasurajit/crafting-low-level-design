package P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code.builders.impl;

import P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code.builders.CPUBuilder;

public class IntelCPUBuilder extends CPUBuilder {
    @Override
    public void buildBrand() {
        cpu.setBrand("Intel");
    }

    @Override
    public void buildProcessor() {
        cpu.setModel("i7-13700K");
        cpu.setBaseClock(3.4);
        cpu.setTurboBoost(5.4);
        cpu.setCoreCount(16);
        cpu.setThreadCount(24);
        cpu.setCacheSize(30);
    }

    @Override
    public void buildGPU() {
        cpu.setIntegratedGPU(true);
        cpu.setOverclockable(true);
    }

    @Override
    public void buildSMPS() {
        cpu.setPowerConsumption(125);
    }

    @Override
    public void buildNeuralEngine() {
        cpu.setNeuralEngine(null);
    }

    @Override
    public void buildRAM() {
        cpu.setUnifiedMemory(32);
    }
}
