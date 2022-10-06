package p583;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author  Stepan M
 * @version 2022.10.06
 * ������ 1.  - ����������� ����� � ���������� �������.
 * P560
 */

public class Jukebox3 {

    //��� ��������� ������������ �����
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main (String[] args){
        new Jukebox3().go();
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
            File file = new File("SongListMore.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (Exception ex) {ex.printStackTrace();}
    } //end getSong()

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2],tokens[3]);
        songList.add(nextSong); //��� ����� ������ �������� �����, ������� ��������� � songList ������ ������ �������.
    }
}

class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;
    public int compareTo(Song s) {
        return title.compareTo(s.getTitle());
    }
    Song (String t, String a, String r,String b) {
        //���������� ������� ��������� � ����������� ��� �������� ������ ������� Song
        title = t;
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

