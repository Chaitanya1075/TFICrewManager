public class Director extends Person {
    private String genreSpeciality;

    // Constructor
    public Director(String name, int age, String genreSpeciality) {
        super(name, age); // Call the Person constructor
        this.genreSpeciality = genreSpeciality;
    }

    // Getter for genreSpeciality
    public String getGenreSpeciality() {
        return genreSpeciality;
    }

    // Setter for genreSpeciality
    public void setGenreSpeciality(String genreSpeciality) {
        this.genreSpeciality = genreSpeciality;
    }

    // Overriding the performRole method
    @Override
    public void performRole() {
        System.out.println(getName() + " is directing a " + genreSpeciality + " film.");
    }
}
