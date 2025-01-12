import java.awt.*;
import java.util.*;
import java.io.*;
import java.lang.reflect.Method;
import javax.swing.*;

public class Score {
    File Save;

    public Score() {
        Save = new File("Save/score.txt");
    }

    public boolean SaveExist() {
        return Save.exists();
    }

    public void writeScore(int score) {
        try {
            if (!SaveExist()) {
                Save.createNewFile();
            }
            FileWriter write = new FileWriter(Save, true);
            write.append(score + "\n");
            write.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @SuppressWarnings("rawtypes")
    public Vector getScore() {
        Vector<Integer> result = new Vector<>();
        try {
            Scanner scan = new Scanner(Save);
            while (scan.hasNextLine()) {
                String line = scan.next();
                result.add(Integer.parseInt(line));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;
    }

    public int getBestScore() {
        int rep = 0;
        for (int i = 0; i < getScore().size(); i++) {
            int best = (int) getScore().get(0);
            if ((int)getScore().get(i)!= best) {
                rep=Math.max((int)getScore().get(i),best);
            }
        }
        return rep;
    }
}