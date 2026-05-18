package P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Violated_Code.models;

public class CPU {
    private String brand;
    private String model;
    private double baseClock;
    private Double turboBoost;
    private Boolean overclockable;
    private Boolean integratedGPU;
    private Integer coreCount;
    private Integer threadCount;
    private Integer cacheSize;
    private Integer powerConsumption;
    private Integer neuralEngine;
    private Integer unifiedMemory;

    public CPU(String brand, String model, double baseClock,
            Double turboBoost, Boolean overclockable, Boolean integratedGPU,
            Integer coreCount, Integer threadCount, Integer cacheSize,
            Integer powerConsumption, Integer neuralEngine, Integer unifiedMemory) {

        this.brand = brand;
        this.model = model;
        this.baseClock = baseClock;
        this.turboBoost = turboBoost;
        this.overclockable = overclockable;
        this.integratedGPU = integratedGPU;
        this.coreCount = coreCount;
        this.threadCount = threadCount;
        this.cacheSize = cacheSize;
        this.powerConsumption = powerConsumption;
        this.neuralEngine = neuralEngine;
        this.unifiedMemory = unifiedMemory;
    }

    public void getCPUInfo() {
        System.out.println();
        System.out.println("======== CPU Information : " + this.brand + " ========");
        System.out.println();
        System.out.println("Processor : " + this.model);
        System.out.println("Base Clock : " + this.baseClock);
        System.out.println("Turbo Boost : " + this.turboBoost);
        System.out.println("Overclockable : " + this.overclockable);
        System.out.println("Integrated GPU : " + this.integratedGPU);
        System.out.println("Cores Count : " + this.coreCount);
        System.out.println("Thread Count : " + this.threadCount);
        System.out.println("L2 cache : " + this.cacheSize + " Mb");
        System.out.println("Power Consumption : " + this.powerConsumption);
        System.out.println("Neural Engine : " + this.neuralEngine);
        System.out.println("RAM (Unified Memory) : " + this.unifiedMemory + " Gb");
        System.out.println("===========================================");
    }
}
