package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {

    public static void main(String[] args) {

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";//演奏按键

        GuitarString[] string = new GuitarString[37];

        for(int j=0;j<37;j++){
            string[j] = new GuitarString(440 * Math.pow(2,(j-24)/12));
        }//录入吉他弦

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                string[index].pluck();;
            }

            double sample = 0.0;
            for(int j=0;j<37;j++) {
                 sample += string[j].sample();
            }

            StdAudio.play(sample);

            for(int j=0;j<37;j++) {
                string[j].tic();
            }
        }
    }
}
