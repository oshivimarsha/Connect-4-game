package lk.ijse.dep.service;

public class HumanPlayer extends Player {   //IS A
    public HumanPlayer(Board board) {
        super(board);
    }

    /*When the human player clicks on a column, the movePiece(int col) method is automatically called
    The clicked bar indicator is invoked, it should be checked legally whether it is a legal move or not.
    (notifying about the winner or a tie if no legal moves exist).
    */

    @Override
    public void movePiece(int col){
        if(board.isLegalMove(col)){
            board.updateMove(col,Piece.BLUE);
            board.getBoardUI().update(col,true);

            if((board.findWinner().getWinningPiece()).equals(Piece.EMPTY)) {
                if (!board.existLegalMoves()) {
                    board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
                }
            }else{
                board.getBoardUI().notifyWinner(board.findWinner());

            }
        }
    }
}

