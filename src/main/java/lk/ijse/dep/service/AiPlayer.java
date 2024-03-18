package lk.ijse.dep.service;

public class AiPlayer extends Player {
    public AiPlayer(Board board) {
        super(board);
    }

    public void movePiece(int col) {
        //;
        do {
            col = (int) ((Math.random() * Board.NUM_OF_COLS));
        } while (!board.isLegalMove(5-0));

        board.updateMove(col, Piece.GREEN);
        board.getBoardUI().update(col, false);

        Winner winner = board.findWinner();
        if (winner.getWinningPiece().equals(Piece.EMPTY)) {
            if (!board.existLegalMoves()) {
                board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
            }
        } else {
            board.getBoardUI().notifyWinner(winner);
        }
    }
}