package artists;

import java.util.Arrays;

public class Actor extends AbstractArtist{
    private String[] movies;

    /**
     * Actor constructor.
     *
     * @param name   : name of the actor.
     * @param age    : age of the actor.
     * @param genres : genres of art the actor develops.
     * @param awards : awards earned by the actor.
     * @param movies: movies acted by the actor.
     */
    public Actor(String name, int age, String[] genres, String[] awards, String[] movies) {
        super(name, age, genres, awards);
        this.movies = movies;
    }

    @Override
    public String toString(){
        return "My name is " + super.getName() + "\n"
                + "My age is " + super.getAge() + "\n"
                + "I am an ACTOR\n"
                + "I make these types of movies: " + super.getGenresAsSingleString() + "\n"
                + "I have acted in these movies: " + Arrays.toString(movies);
    }
}
