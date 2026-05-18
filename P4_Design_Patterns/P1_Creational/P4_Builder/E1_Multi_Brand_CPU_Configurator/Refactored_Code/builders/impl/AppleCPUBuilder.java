package P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code.builders.impl;

import P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code.builders.CPUBuilder;

public class AppleCPUBuilder extends CPUBuilder {
    @Override
    public void buildBrand() {
        cpu.setBrand("Apple");
    }

    @Override
    public void buildProcessor() {
        cpu.setModel("M2");
        cpu.setBaseClock(3.2);
        cpu.setTurboBoost(null);
        cpu.setCoreCount(8);
        cpu.setThreadCount(8);
        cpu.setCacheSize(20);
    }

    @Override
    public void buildGPU() {
        cpu.setIntegratedGPU(true);
        cpu.setOverclockable(false);
    }

    @Override
    public void buildSMPS() {
        cpu.setPowerConsumption(20);
    }

    @Override
    public void buildNeuralEngine() {
        cpu.setNeuralEngine(16);
    }

    @Override
    public void buildRAM() {
        cpu.setUnifiedMemory(24);
    }
}
