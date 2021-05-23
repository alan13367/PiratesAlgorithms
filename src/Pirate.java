/**
 * Class implementing the a Pirate for the Tables Data Structure
 * @author Ramon Sabater
 * @version 2.0 15 May 2021
 */
public class Pirate {
    private String name;
    private int age;
    private String role;

    /**
     * Constructor for when data comes from the file.
     * @param data the line from the file.
     */
    public Pirate(String data) {
        String split[] = data.split(",");
        this.name = split[0];
        this.age = Integer.parseInt(split[1]);
        this.role = split[2];
    }

    /**
     * Regular constructor.
     * @param name the name of the pirate.
     * @param age the age of the pirate.
     * @param role the role of the pirate.
     */
    public Pirate(String name, int age, String role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    /**
     * Getter for the name.
     * @return a string containing the name for the pirate.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the age of the pirate.
     * @return an int with the.
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter for the role of the pirate.
     * @return a String with the role of the pirate.
     */
    public String getRole() {
        return role;
    }
}
