package org.example.designpatterns;

public class Computer {
    // Mandatory fields
    private final String HDD;
    private final String RAM;

    // Optional fields
    private final boolean hasGPU;
    private final boolean hasPrinter;

    // private constructor to prevent direct instantiation
    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.hasGPU = builder.hasGPU;
        this.hasPrinter = builder.hasPrinter;
    }

    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public boolean isHasGPU() {
        return hasGPU;
    }

    public boolean isHasPrinter() {
        return hasPrinter;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "HDD='" + HDD + '\'' +
                ", RAM='" + RAM + '\'' +
                ", hasGPU=" + hasGPU +
                ", hasPrinter=" + hasPrinter +
                '}';
    }

    public static class ComputerBuilder {
        // Mandatory fields
        private final String HDD;
        private final String RAM;

        // Optional fields
        private boolean hasGPU;
        private boolean hasPrinter;

        //Constructor for mandatory fields
        public ComputerBuilder(String HDD, String RAM) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        //Setter for GPU with method chaining
        public ComputerBuilder setGPU(boolean hasGPU) {
            this.hasGPU = hasGPU;
            return this;
        }

        //Setter for printer with method chaining
        public ComputerBuilder setPrinter(boolean hasPrinter) {
            this.hasPrinter = hasPrinter;
            return this;
        }

        // Build method to return the final Computer object
        public Computer build() {
            return new Computer(this);
        }
    }
}
