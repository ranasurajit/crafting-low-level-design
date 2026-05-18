package P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Violated_Code;

import P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Violated_Code.models.CPU;

public class Client {
    public static void main(String[] args) {

        // 🔵 Intel CPU Configuration
        CPU intelCPU = new CPU(
                "Intel",
                "i7-13700K",
                3.4,
                5.4, // turboBoost
                true, // overclockable
                true, // integratedGPU
                16, // coreCount
                24, // threadCount
                30, // cacheSize
                125, // powerConsumption
                null, // neuralEngine (not applicable)
                null // unifiedMemory (not applicable)
        );

        // 🔴 AMD CPU Configuration
        CPU amdCPU = new CPU(
                "AMD",
                "Ryzen 9 7950X",
                4.5,
                5.7,
                true,
                false,
                16,
                32,
                64,
                170,
                null,
                null);

        // ⚪ Apple CPU Configuration
        CPU appleCPU = new CPU(
                "Apple",
                "M2",
                3.2,
                null, // ❌ no turboBoost for Apple
                null, // ❌ no overclocking
                true,
                8,
                8,
                null,
                20,
                16, // neuralEngine
                8 // unifiedMemory
        );

        // 🖨️ Print (assuming toString exists)
        intelCPU.getCPUInfo();
        amdCPU.getCPUInfo();
        appleCPU.getCPUInfo();
    }
}
