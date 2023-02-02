package artists;

import java.util.Arrays;

public class Musician extends AbstractArtist{

    private String album;
    private String company;
    /**
     * Musician constructor.
     *
     * @param name   : name of the musician.
     * @param age    : age of the musician.
     * @param genres : genres of art the musician develops.
     * @param awards : awards earned by the musician.
     * @param album: the title of current album of this musician.
     * @param company: the recording company of this musician.
     */
    public Musician(String name, int age, String[] genres, String[] awards, String album, String company) {
        super(name, age, genres, awards);
        this.album = album;
        this.company = company;

    }

    @Override
    public String toString(){
        return "My name is " + super.getName() + "\n"
                + "My age is " + super.getAge() + "\n"
                + "I am an MUSICIAN" + "\n"
                + "I make these types of music: " + super.getGenresAsSingleString() + "\n"
                + "My current album is: " + album + "\n"
                + "My recording company is: " + company;
    }
}
