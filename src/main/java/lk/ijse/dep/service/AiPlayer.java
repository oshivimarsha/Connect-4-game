package lk.ijse.dep.service;

import java.util.Random;

//Inheritance
public class AiPlayer extends Player {      //AiPlayer IS A

    //calls the constructor of the superclass Player passing newBoard as an argument using the super keyword.
    public AiPlayer(Board newBoard) {
        super(newBoard);    //Super keyword
    }

    @Override
    public void movePiece(int col) {

        int x = colChosser();   //calls the colChosser method
        if (x == -1){

            do {
                col = (int)(Math.random() * 6);

            }while (!board.isLegalMove(col));
        }else {
            col = x;
        }

        board.updateMove(col, Piece.GREEN);
        board.getBoardUI().update(col, false);

        if(board.findWinner().getWinningPiece()!=(Piece.EMPTY)) {
            board.getBoardUI().notifyWinner(board.findWinner());    //win

        }else {
            if (!board.existLegalMoves())
                board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
        }
    }

    private int colChosser() {  //return type method

        for (int i = 0; i < 6; i++) {

            if (board.isLegalMove(i) ){
                int row = board.findNextAvailableSpot(i);
                board.updateMove(i,Piece.GREEN);
                if (board.findWinner().getWinningPiece() == Piece.GREEN) {

                    board.updateMove(i, row, Piece.EMPTY);
                    return i;
                }
                else{
                    board.updateMove(i, row, Piece.EMPTY);
                }
            }
        }

        for (int i = 0; i < 6; i++) {

            if (board.isLegalMove(i) ){
                int row = board.findNextAvailableSpot(i);
                board.updateMove(i,Piece.BLUE);
                if (board.findWinner().getWinningPiece() == Piece.BLUE) {

                    board.updateMove(i, row, Piece.EMPTY);
                    return i;
                }
                else {
                    board.updateMove(i, row, Piece.EMPTY);
                }
            }
        }
        return -1;
    }
}