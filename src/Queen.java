public class Queen extends ChessPiece {
    public Queen(String color) {
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
        return checkGoQueen(line, column, toLine, toColumn);
    }

    private boolean checkGoQueen (int line, int column, int toLine, int toColumn) {
        if (Math.abs(line - toLine) == Math.abs(column - toColumn))
            return true;
        return toLine == line || toColumn == column;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
