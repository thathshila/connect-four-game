package lk.ijse.dep.service;

public class BoardImpl implements Board {
    private Piece[][] pieces;
    private BoardUI boardUI;

    @Override
    public  int findNextAvailableSpot(int col){
        for (int i=0; i<pieces[col].length;i++) {
            if (pieces[col][i]==Piece.EMPTY){
                return i;
            }
        }

        return -1;
    }
    @Override
    public  boolean isLegalMove(int col){
        for (int i=0; i<pieces[col].length;i++) {
            if (pieces[col][i]==Piece.EMPTY){
                return true;
            }
        }

        return false;
    }
    @Override
    public  boolean existLegalMoves() {
        for (int i = 0; i <pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] == Piece.EMPTY) {
                    return true;
                }

            }
        }
        return false;
    }

    @Override
    public  void updateMove(int col,Piece move){

        pieces[col][findNextAvailableSpot(col)]=move;
       /* for (int i = 0; i <pieces[col].length ; i++) {
            if (pieces[col][i] == Piece.EMPTY) {
                pieces[col][i]= move;
            }
        }*/

    }
    @Override
    public  Winner findWinner() {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length - 3; j++) {
                if (pieces[i][j] != Piece.EMPTY && pieces[i][j] == pieces[i][j + 1] && pieces[i][j] == pieces[i][j + 2] && pieces[i][j] == pieces[i][j + 3]) {
                    return new Winner(pieces[i][j], i, j,i, j + 3);
                }

            }

        }

        for (int i = 0; i < pieces.length-3; i++) {
            for (int j = 0; j <pieces[i].length; j++) {
                if (pieces[i][j] != Piece.EMPTY && pieces[i][j] == pieces[i+1][j] && pieces[i][j] == pieces[i+2][j] && pieces[i][j] == pieces[i+3][j] ) {
                    return new Winner(pieces[i][j], i, j,i+3, j );
                }
            }
        }

        return new Winner(Piece.EMPTY);
    }
    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        pieces =new Piece [NUM_OF_COLS] [NUM_OF_ROWS];

        for (int i=0; i< pieces.length;i++) {
            for (int j=0; j< pieces[i].length;j++){
                pieces[i][j]=Piece.EMPTY;
            }

        }
    }


    public BoardUI getBoardUI() {
        return boardUI;
    }

    public void setBoardUI(BoardUI boardUI) {
        this.boardUI = boardUI;
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[][] pieces) {
        this.pieces = pieces;
    }
}