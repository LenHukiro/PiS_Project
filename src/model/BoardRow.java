package model;

enum BoardRow {
    a(1), b(2), c(3), d(4), e(5), f(6), g(7), h(8);

    private final int boardRow;

    BoardRow(int numVal) {
        this.boardRow = numVal;
    }

    public int getBoardNumber() {
        return boardRow;
    }
}
