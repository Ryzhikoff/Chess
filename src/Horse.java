public class Horse extends ChessPiece{

    public Horse(String color) {
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
        return checkGoHorse(line, column, toLine, toColumn);
    }

    private boolean checkGoHorse(int line, int column, int toLine, int toColumn) {
        if ((Math.abs(line - toLine) == 2) && (Math.abs(column - toColumn) == 1)) return true;
        return (Math.abs(line - toLine) == 1) && (Math.abs(column - toColumn) == 2);
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
