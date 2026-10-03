public class Country {

    private String name;
    private String language;
    private int population;

    public Country(String name, String language, int population) {
        this.name = name;
        this.language = language;
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country: " + name +
                ", Language: " + language +
                ", Population: " + population;
    }
}