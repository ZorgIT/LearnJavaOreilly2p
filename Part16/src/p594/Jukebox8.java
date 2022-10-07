package p594;

import java.io.*;

import java.util.*;

/**
 * @author  Stepan M
 * @version 2022.10.06
 * ������ 1.  - ����������� ����� � ���������� �������.
 * P589
 */

public class Jukebox8 {

    //��� ��������� ������������ �����
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main (String[] args){
        new Jukebox8().go();
    }

    public void go() {
        getSongs();
        //������ ����� � ��� �������, � ������� ��� ���� ���������
        System.out.println("ArrayList" + songList);
        Collections.sort(songList);
        System.out.println("ArrayList sorted" +songList);
        HashSet<Song> songSet = new HashSet<Song>();
        songSet.addAll(songList);
        System.out.println("Hashset " + songSet);
        TreeSet<Song> songSet2 = new TreeSet<Song>();
        songSet2.addAll(songList);
        System.out.println("TreeSet autosort " + songSet2);

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

    //HashSet( ��� ���-������ ��� ��� �������� ���� ������) �������� ���� ������ ������ song.
    public boolean equals (Object aSong) {
        Song s = (Song) aSong;
        //��������� title ��� ������, �  ������� ���� ���������������� ����� equals()
        // ����� ���� ��������� � ���������� title ��������� �� �� �������� � ��������� ���������� �����
        return getTitle().equals(s.getTitle());
    }

    public int hashCode() {
        //�.�. ����� String �������� ���������������� ����� hashCOde()
        // �� ��� ����� ������� �� ���������� title � ������� ���������.
        return title.hashCode();
    }

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

