package patterns.builder;

import java.util.List;

public class Car {

    private final String model;
    private final String color;
    private final String engine;
    private final String transmission;
    private final String drivetrain;
    private final int wheelSize;
    private final List<String> options;


    private Car(CarBuilder builder) {
        this.model = builder.model;
        this.color = builder.color;
        this.engine = builder.engine;
        this.transmission = builder.transmission;
        this.drivetrain = builder.drivetrain;
        this.wheelSize = builder.wheelSize;
        this.options = builder.options;
    }


    public static class CarBuilder {

        private final String model;
        private String color;
        private String engine;
        private String transmission;
        private String drivetrain;
        private int wheelSize;
        private List<String> options;

        public CarBuilder(String model) {
            this.model = model;
        }

        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder engine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder transmission(String transmission) {
            this.transmission = transmission;
            return this;
        }

        public CarBuilder drivetrain(String drivetrain) {
            this.drivetrain = drivetrain;
            return this;
        }

        public CarBuilder wheelSize(int wheelSize) {
            this.wheelSize = wheelSize;
            return this;
        }

        public CarBuilder options(List<String> options) {
            this.options = options;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getEngine() {
            return engine;
        }

        public void setEngine(String engine) {
            this.engine = engine;
        }

        public String getTransmission() {
            return transmission;
        }

        public void setTransmission(String transmission) {
            this.transmission = transmission;
        }

        public String getDrivetrain() {
            return drivetrain;
        }

        public void setDrivetrain(String drivetrain) {
            this.drivetrain = drivetrain;
        }

        public int getWheelSize() {
            return wheelSize;
        }

        public void setWheelSize(int wheelSize) {
            this.wheelSize = wheelSize;
        }

        public List<String> getOptions() {
            return options;
        }

        public void setOptions(List<String> options) {
            this.options = options;
        }

    }
    @Override
    public String toString() {
        return "CarBuilder{" +
               "model='" + model + '\'' +
               ", color='" + color + '\'' +
               ", engine='" + engine + '\'' +
               ", transmission='" + transmission + '\'' +
               ", drivetrain='" + drivetrain + '\'' +
               ", wheelSize=" + wheelSize +
               ", options=" + options +
               '}';
    }
}


