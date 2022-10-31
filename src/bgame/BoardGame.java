package bgame;

import java.util.Scanner;

import mgr.Manageable;

public class BoardGame implements Manageable {
    String name;
    String level;
    String genre;
    String explain;
    //설명 길면 txt 파일로 받아도 될 듯? or 0 입력하기 전까지 모두 입력받기
    // ㄴ ex) (설명 블라블라~ 0)

    @Override
    public void read(Scanner scan) {
        // TODO Auto-generated method stub

    }

    @Override
    public void print() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean matches(String kwd) {
        // TODO Auto-generated method stub
        return false;
    }

}