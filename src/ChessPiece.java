public abstract class ChessPiece {

    protected String color;
    protected boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    protected boolean onBoard(int line, int column) {
        return (line >= 0 && line <= 7) && (column >= 0 && column <= 7);
    }

    protected boolean checkGoToCurrentPos(int line, int column, int toLine, int toColumn) {
        return line == toLine && column == toColumn;
    }

    protected boolean checkOwnFigure(ChessBoard chessBoard, int toLine, int toColumn) {
        if (!(chessBoard.board[toLine][toColumn] == null)) {
            return chessBoard.board[toLine][toColumn].getColor().equals(this.color);
        }
        return false;
    }

}
