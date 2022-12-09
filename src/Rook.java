public class Rook extends ChessPiece {
    public Rook(String color) {
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
        return checkGoRook(line, column, toLine, toColumn);
    }

    private boolean checkGoRook(int line, int column, int toLine, int toColumn) {
        return toLine == line || toColumn == column;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
