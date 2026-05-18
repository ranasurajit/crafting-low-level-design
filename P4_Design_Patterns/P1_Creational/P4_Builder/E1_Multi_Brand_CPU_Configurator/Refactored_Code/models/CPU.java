package P4_Design_Patterns.P1_Creational.P4_Builder.E1_Multi_Brand_CPU_Configurator.Refactored_Code.models;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getBaseClock() {
        return baseClock;
    }

    public void setBaseClock(double baseClock) {
        this.baseClock = baseClock;
    }

    public Double getTurboBoost() {
        return turboBoost;
    }

    public void setTurboBoost(Double turboBoost) {
        this.turboBoost = turboBoost;
    }

    public Boolean getOverclockable() {
        return overclockable;
    }

    public void setOverclockable(Boolean overclockable) {
        this.overclockable = overclockable;
    }

    public Boolean getIntegratedGPU() {
        return integratedGPU;
    }

    public void setIntegratedGPU(Boolean integratedGPU) {
        this.integratedGPU = integratedGPU;
    }

    public Integer getCoreCount() {
        return coreCount;
    }

    public void setCoreCount(Integer coreCount) {
        this.coreCount = coreCount;
    }

    public Integer getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(Integer threadCount) {
        this.threadCount = threadCount;
    }

    public Integer getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(Integer cacheSize) {
        this.cacheSize = cacheSize;
    }

    public Integer getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public Integer getNeuralEngine() {
        return neuralEngine;
    }

    public void setNeuralEngine(Integer neuralEngine) {
        this.neuralEngine = neuralEngine;
    }

    public Integer getUnifiedMemory() {
        return unifiedMemory;
    }

    public void setUnifiedMemory(Integer unifiedMemory) {
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
