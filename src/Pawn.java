public class Pawn extends ChessPiece {

    public Pawn(String color) {
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
        if (column != toColumn) return false;
        if (checkOwnFigure(chessBoard, toLine, toColumn)) return false;
        return checkGoPawn(line, toLine);
    }

    private boolean checkGoPawn(int line, int toLine) {
        if ((color.equals("White"))) {
            return (toLine - line == 1) || (isFirstMove(line) && toLine - line == 2);
        } else {
            return (toLine - line == -1) || (isFirstMove(line) && toLine - line == -2);
        }
    }

    private boolean isFirstMove (int line) {
        if((color.equals("White")) && line == 1) return true;
        if((color.equals("Black")) && line == 6) return true;
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
