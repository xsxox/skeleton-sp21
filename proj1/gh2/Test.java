package gh2;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        File midfile = new File("D:\\星座になれたら.mid.mid");//建议用现成的midi文件，不要用MP3转换，不然会变成叙利亚音质
        GuitarPlayer player = new GuitarPlayer(midfile);
        player.play();
    }
}


// You can also do this:
// GuitarPlayer player = new GuitarPlayer(new java.io.File("path/to/music.mid"));
// player.play();
