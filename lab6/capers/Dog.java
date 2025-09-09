package capers;

import java.io.File;
import java.io.Serializable;

import static capers.CapersRepository.CAPERS_FOLDER;

/** Represents a dog that can be serialized.
 * @author sunrise
*/
public class Dog implements Serializable {

    /** Folder that dogs live in. */
    /** Hint: look at the 'join' function in Utils.*/
    static final File DOG_FOLDER = Utils.join(CAPERS_FOLDER,"dogs");

    /** Age of dog. */
    private int age;
    /** Breed of dog. */
    private String breed;
    /** Name of dog. */
    private String name;

    /**
     * Creates a dog object with the specified parameters.
     * @param name Name of dog
     * @param breed Breed of dog
     * @param age Age of dog
     */
    public Dog(String name, String breed, int age) {
        this.age = age;
        this.breed = breed;
        this.name = name;
    }

    /**
     * Reads in and deserializes a dog from a file with name NAME in DOG_FOLDER.
     *
     * @param name Name of dog to load
     * @return Dog read from file
     */
    public static Dog fromFile(String name) {
        File f = Utils.join(DOG_FOLDER,name); //定位到狗狗
        return Utils.readObject(f,Dog.class); //反序列化读取为Dog类对象
    }

    /**
     * Increases a dog's age and celebrates!
     */
    public void haveBirthday() {
        age += 1;
        System.out.println(toString());
        System.out.println("Happy birthday! Woof! Woof!");
    }

    /**
     * Saves a dog to a file for future use.
     */
    public void saveDog() {
        // (hint: don't forget dog names are unique)
        Utils.writeObject(Utils.join(DOG_FOLDER,this.name),this);//创建狗狗空文件，将序列化的狗狗写入文件
    }

    @Override
    public String toString() {
        return String.format(
            "Woof! My name is %s and I am a %s! I am %d years old! Woof!",
            name, breed, age);
    }

}
