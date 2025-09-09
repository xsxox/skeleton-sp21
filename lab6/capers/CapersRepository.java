package capers;

import java.io.File;
import java.io.IOException;

/** A repository for Capers
 * @author sunrise
 * The structure of a Capers Repository is as follows:
 * .capers/ -- top level folder for all persistent data in your lab12 folder
 *    - dogs/ -- folder containing all of the persistent data for dogs
 *    - story -- file containing the current story
 *
 */
public class CapersRepository {
    /** Current Working Directory. */
    static final File CWD = new File(System.getProperty("user.dir"));

    /** Main metadata folder.
     Hint: look at the 'join' function in Utils. */
    static final File CAPERS_FOLDER = Utils.join(CWD,".capers");

    static File story = Utils.join(CAPERS_FOLDER,"story");


    /**
     * Does required filesystem operations to allow for persistence.
     * (creates any necessary folders or files)
     * Remember: recommended structure (you do not have to follow):
     * .capers/ -- top level folder for all persistent data in your lab12 folder
     *    - dogs/ -- folder containing all of the persistent data for dogs
     *    - story -- file containing the current story
     * 创建文件夹与文件 */

    public static void setupPersistence() {
        CAPERS_FOLDER.mkdir();
        Dog.DOG_FOLDER.mkdir();
        try{
            story.createNewFile();
        } catch (IOException e) {
            Utils.exitWithError("story File create error!");
        }
    }

    /**
     * Appends the first non-command argument in args
     * to a file called `story` in the .capers directory.
     * @param text String of the text to be appended to the story
     * 文本内容添加到 story 文件   */

    public static void writeStory(String text) {
        String update = Utils.readContentsAsString(story)+text+"\n";//text + \n
        Utils.writeContents(story,update); //覆盖原文件
        System.out.print(update);
    }

    /**
     * Creates and persistently saves a dog using the first
     * three non-command arguments of args (name, breed, age).
     * Also prints out the dog's information using toString().
     */
    public static void makeDog(String name, String breed, int age) {
        Dog w = new Dog(name,breed,age);//创建对象
        System.out.println(w.toString());//打印狗狗信息
        w.saveDog();//将序列化的狗狗写入文件
    }

    /**
     * Advances a dog's age persistently and prints out a celebratory message.
     * Also prints out the dog's information using toString().
     * Chooses dog to advance based on the first non-command argument of args.
     * @param name String name of the Dog whose birthday we're celebrating.
     */
    public static void celebrateBirthday(String name) {
        Dog w = Dog.fromFile(name);//读取该名字的狗狗对象
        w.haveBirthday();//过生日
    }
}
