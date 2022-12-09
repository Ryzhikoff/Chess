public class King extends ChessPiece{
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!onBoard(toLine, toColumn)) return false;
        if (checkGoToCurrentPos(line, column, toLine, toColumn)) return false;
        if (checkOwnFigure(chessBoard, toLine, toColumn)) return false;
        return checkGoKing(line, column, toLine, toColumn);
    }

    private boolean checkGoKing(int line, int column, int toLine, int toColumn) {
        return Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int l = 0; l < 8; l++) {
            for (int c = 0; c < 8; c++) {
                if (board.board[l][c] == null) continue;
                if (!board.board[l][c].getColor().equals(this.color) && board.board[l][c].canMoveToPosition(board, l,c,line, column))
                    return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
