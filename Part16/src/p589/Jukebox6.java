package p589;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author  Stepan M
 * @version 2022.10.06
 * Задача 1.  - сортировать песни в алфавитном порядке.
 * P589
 */

public class Jukebox6 {

    //Для храненеия наименоавний песен
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main (String[] args){
        new Jukebox6().go();
    }

    public void go() {
        getSongs();
        //Выводи песни в том порядке, в котором они были добавлены
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
        HashSet<Song> songSet = new HashSet<Song>();
        songSet.addAll(songList);
        System.out.println(songSet);

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
        songList.add(nextSong); //Нам нужно только название песни, поэтому добавляем в songList только первую лексему.
    }
}

class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;

    //HashSet( или кто-нибудь еще кто вызывает этот методо) передает сюда другой объект song.
    public boolean equals (Object aSong) {
        Song s = (Song) aSong;
        //Поскольку title это строка, а  устроки есть переопределенный метод equals()
        // нужно лишь запросить у переменной title совпадает ли ее значение с названием переданной песни
        return getTitle().equals(s.getTitle());
    }

    public int hashCode() {
        //т.к. класс String содержит переопределенный метод hashCOde()
        // то его можно вызвать из переменной title и вернуть результат.
        return title.hashCode();
    }

    public int compareTo(Song s) {
        return title.compareTo(s.getTitle());
    }
    Song (String t, String a, String r,String b) {
        //Переменные которые передатся в конструктор при создании нового объекта Song
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

    //Переопредлеение toString(),
    public String toString() {
        return title;
    }
}

