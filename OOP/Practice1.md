## Quantum Car Factory

### Design a car factory with the following criteria:

- The car may have an engine that may be replaced easily.
- You have 3 types of engines:
    - Gas engine
    - Electric engine
    - Hybrid Engine, which contains both (Gas and Electric)
- Car has four operations
    1. start
    2. stop
    3. Accelerate: which speeds the car by 20 km/h up to 200 km/h
    4. Brake: which decreases the speed of the car by 20 km/h
- Installed engine should be notified when starting/stopping car
- When changing the speed, the car should advice the installed engine about the current speed
- In the case of a hybrid engine, the Electric engine should work on speeds below 50, otherwise the Gas engine should work, the hybrid engine should be cost optimized.
- The car factory should be able to create a car based on the engine type, or replace the engine for an existing car.

``` java

public interface Engine {
    void start();
    void stop();
    void onSpeedChange(int speed);
}

public class GasEngine implements Engine {
    @Override
    public void start(){
        System.out.println("GasEngine started");
    }
    @Override
    public void stop(){
        System.out.println("GasEngine stopped");
    }
    @Override
    public void onSpeedChange(int speed) {
        System.out.println("GasEngine" +  " running at: " + speed + " km/h");
    }
}

public class ElectricEngine implements Engine {

    @Override
    public void start(){
        System.out.println("Electric Engine is started");
    }
    @Override
    public void stop(){
        System.out.println("Electric Engine is stopped");
    }
    @Override
    public void onSpeedChange(int speed) {
        System.out.println("Electric Engine" +  " running at: " + speed + " km/h");
    }
}

public class HybridEngine implements Engine{
    ElectricEngine electricEngine = new ElectricEngine();
    GasEngine gasEngine = new GasEngine();
    Engine engine;

    public HybridEngine(){
        this.engine = electricEngine;
    }

    @Override
    public void start() {
        System.out.print("Hybrid engine started... ");
        engine.start();
    }

    @Override
    public void stop() {
        System.out.print("Hybrid engine stopped... ");
        engine.stop();
    }

    @Override
    public void onSpeedChange(int speed) {
        if(speed < 50 && engine != electricEngine) {
            engine = electricEngine;
        }
        else if(speed >= 50 && engine != gasEngine ) {
            engine = gasEngine;
        }
        engine.onSpeedChange(speed);
    }
}

public class Car {
    Engine engine;
    private int speed = 0;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start(){
        engine.start();
    }

    public void stop() {
        engine.stop();
    }

    public void accelerate() {
        if(this.speed + 20 <= 200)
            this.speed+=20;
        engine.onSpeedChange(speed);
    }

    public void brake() {
        if(this.speed - 20 >= 0)
            this.speed-=20;
        engine.onSpeedChange(speed);
    }
}

public enum EngineType {
    GAS, ELECTRIC, HYBRID
}

public class CarFactory {
    public static Car createCar(EngineType type) {
        Car car = new Car();
        installEngine(car, type);
        return car;
    }
    private static Engine createEngine(EngineType type) {
        return switch (type) {
            case GAS -> new GasEngine();
            case ELECTRIC -> new ElectricEngine();
            case HYBRID -> new HybridEngine();
        };
    }
    public static void installEngine(Car car,EngineType type){
        car.setEngine(createEngine(type));
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = CarFactory.createCar(EngineType.HYBRID);
        car.start();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.stop();
    }
}

```


    Hybrid engine started... Electric Engine is started
    Electric Engine running at: 20 km/h
    Electric Engine running at: 40 km/h
    GasEngine running at: 60 km/h
    GasEngine running at: 80 km/h
    Hybrid engine stopped... GasEngine stopped

    
