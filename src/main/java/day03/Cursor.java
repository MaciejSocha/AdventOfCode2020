package day03;

public class Cursor {
    private int positionInRow;
    private int rowPosition;

    public Cursor() {
        positionInRow = 0;
        rowPosition = 0;
    }

    public void moveCursor(int column, int row) {
        this.positionInRow += column;
        this.rowPosition += row;
    }

    public void moveCursorInRow(int column){
        this.positionInRow += column;
    }

    public void moveCursorRow(int row){
        this.rowPosition += row;
    }

    public int getPositionInRow() {
        return positionInRow;
    }

    public int getRowPosition() {
        return rowPosition;
    }
}
