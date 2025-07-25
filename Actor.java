public class Actor extends Person {
    private String actingStyle;

    // Constructor
    public Actor(String name, int age, String actingStyle) {
        super(name, age); // Call parent constructor
        this.actingStyle = actingStyle;
    }

    // Getter for actingStyle
    public String getActingStyle() {
        return actingStyle;
    }

    // Setter for actingStyle
    public void setActingStyle(String actingStyle) {
        this.actingStyle = actingStyle;
    }

    // Overriding the performRole method
    @Override
    public void performRole() {
        System.out.println(getName() + " is acting in a " + actingStyle + " style.");
    }
}
