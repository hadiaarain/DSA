public class Country {
    public String name;
    public String language;
    public int population;

    public Country(String name, String language, int population) {
        this.name = name;
        this.language = language;
        this.population = population;
    }

    public String toString() {
        return "Country: " + name + ", Language: " + language + ", Population: " + population;
    }
}