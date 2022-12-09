public class Bishop extends ChessPiece{
    public Bishop(String color) {
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
        return checkGoBishop(line, column, toLine, toColumn);
    }

    private boolean checkGoBishop(int line, int column, int toLine, int toColumn) {
        return Math.abs(line - toLine) == Math.abs(column - toColumn);
    }
    @Override
    public String getSymbol() {
        return "B";
    }
}
