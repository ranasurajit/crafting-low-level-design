package P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code.builders.impl;

import P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code.builders.CPUBuilder;

public class AMDCPUBuilder extends CPUBuilder {
    @Override
    public void buildBrand() {
        cpu.setBrand("AMD");
    }

    @Override
    public void buildProcessor() {
        cpu.setModel("Ryzen 9 7950X");
        cpu.setBaseClock(4.2);
        cpu.setTurboBoost(5.6);
        cpu.setCoreCount(16);
        cpu.setThreadCount(32);
        cpu.setCacheSize(64);
    }

    @Override
    public void buildGPU() {
        cpu.setIntegratedGPU(true);
        cpu.setOverclockable(false);
    }

    @Override
    public void buildSMPS() {
        cpu.setPowerConsumption(170);
    }

    @Override
    public void buildNeuralEngine() {
        cpu.setNeuralEngine(null);
    }

    @Override
    public void buildRAM() {
        cpu.setUnifiedMemory(48);
    }
}
