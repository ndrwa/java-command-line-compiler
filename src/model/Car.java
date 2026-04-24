package model;

public class Car {
    private String make;
    private String model;
    private Owner owner;
    private History history;



    @Override
    public String toString() {
        return "{" +
                "\"make\": \"" + make + "\"," +
                "\"model\": \"" + model + "\"," +
                "\"year\": " + (history == null ? "null" : history.toString()) + "," +
                "\"owner\": " + (owner == null ? "null" : owner.toString()) +
                "}";
    }
    
}
