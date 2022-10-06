package p560;

import java.util.*;
import java.io.*;
import java.util.ArrayList;

/**
 * @author  Stepan M
 * @version 2022.10.06
 * ������ 1.  - ����������� ����� � ���������� �������.
 * P560
 */

public class Jukebox1 {

    //��� ��������� ������������ �����
    ArrayList<String> songList = new ArrayList<>();

    public static void main (String[] args){
        new Jukebox1().go();
    }

    public void go() {
        getSongs();
        //������ ����� � ��� �������, � ������� ��� ���� ���������
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);

    }

    void getSongs() {
        try {
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (Exception ex) {ex.printStackTrace();}
    } //end getSong()

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        songList.add(tokens[0]); //��� ����� ������ �������� �����, ������� ��������� � songList ������ ������ �������.
    }
}

class Song {
    String title;
    String artist;
    String rating;
    String bpm;

    Song (String t, String a, String r,String b) {
        //���������� ������� ��������� � ����������� ��� �������� ������ ������� Song
        title =t;
        artist = a;
        rating = r;
        bpm = b;
    }

    public String getTitle() {
        return  title;
    }

    public String getArtist() {
        return  artist;
    }

    public  String getRating() {
        return rating;
    }
    public  String getBpm() {
        return bpm;
    }

    //��������������� toString(),
    public String toString() {
        return title;
    }
}
