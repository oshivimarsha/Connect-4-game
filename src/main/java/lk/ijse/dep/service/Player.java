package lk.ijse.dep.service;

public abstract class Player {
    protected Board board;  //HAS A
    public Player(Board board) {
        this.board = board;
    }

    public void movePiece(int col) {

    }
}
