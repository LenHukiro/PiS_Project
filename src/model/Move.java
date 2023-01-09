package model;

import model.pieces.Piece;

record Move(Piece piece, Piece pieceOnCoordinate, Coordinate prev, Coordinate next) {
}
