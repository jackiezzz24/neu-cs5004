package artists;

public class Poet extends AbstractArtist{

    private String publisher;
    /**
     * Poet constructor.
     *
     * @param name   : name of the poet.
     * @param age    : age of the poet.
     * @param genres : genres of art the poet develops.
     * @param awards : awards earned by the poet.
     * @param publisher: publisher that publishes books/work for the poet.
     */
    public Poet(String name, int age, String[] genres, String[] awards, String publisher) {
        super(name, age, genres, awards);
        this.publisher = publisher;
    }

    @Override
    public String toString(){
        return "My name is " + super.getName() + "\n"
                + "My age is " + super.getAge() + "\n"
                + "I am an POET" + "\n"
                + "I make these types of poems: " + super.getGenresAsSingleString() + "\n"
                + "My publishing company is: " + publisher;
    }
}
