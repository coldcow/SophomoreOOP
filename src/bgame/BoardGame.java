package bgame;

import java.util.Scanner;

import mgr.Manageable;

public class BoardGame implements Manageable {
    String name;
    String level;
    String genre;
    String NumOfMember;
    String time;
    //String explain;
    //설명 길면 txt 파일로 받아도 될 듯? or 0 입력하기 전까지 모두 입력받기
    // ㄴ ex) (설명 블라블라~ 0)

    @Override
    public void read(Scanner scan) {
        name = scan.next();
        level = scan.next();
        genre = scan.next();
        NumOfMember = scan.next();
        time = scan.next();
    }

    @Override
    public void print() {
        System.out.format("[%s]  난이도 : %s\t%s\t%s\t%s",name,level,genre,NumOfMember,time);
        System.out.println();
    }

    @Override
    public boolean matches(String kwd) {
        if (name.contains(kwd) ||
            genre.contains(kwd) ||
            NumOfMember.contains(kwd) ||
            time.contains(kwd) ||
            level.contains(kwd))
            return true;
        else
            return false;
    }

}