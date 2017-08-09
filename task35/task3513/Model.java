package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles=new Tile[FIELD_WIDTH][FIELD_WIDTH];
    int score;
    int maxTile;
    private Stack previousStates = new Stack();
    private Stack previousScores = new Stack();
    private boolean isSaveNeeded = true;

    private void saveState(Tile[][] tiles){
        Tile[][] tempTile = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++){
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tempTile[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(tempTile);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback(){
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = (Tile[][]) previousStates.pop();
            score = (int) previousScores.pop();
        }
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public Model() {
        resetGameTiles();
    }
    public void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        score = 0;
        maxTile = 2;
        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> list = getEmptyTiles();
        if (list.size() > 0) {
            list.get((int) (list.size()*Math.random())).value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) {
                    list.add(gameTiles[i][j]);
                }
            }
        }
        return list;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean change = false;
        for (int k = 0; k < tiles.length - 1; k++) {
            for (int i = 0; i < tiles.length - 1; i++) {
                if (tiles[i].isEmpty() && !tiles[i+1].isEmpty()) {
                    change = true;
                    tiles[i] = tiles[i+1];
                    tiles[i+1] = new Tile();
                }
            }
        }
        return change;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean change = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i+1].value && !tiles[i].isEmpty() && !tiles[i+1].isEmpty()) {
                change = true;
                tiles[i].value *= 2;
                tiles[i+1] = new Tile();
                maxTile = maxTile > tiles[i].value ? maxTile : tiles[i].value;
                score += tiles[i].value;
                compressTiles(tiles);
            }
        }
        return change;
    }

    public void left() {
        if (isSaveNeeded) { saveState(gameTiles); }
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++){
            if (compressTiles(gameTiles[i])) { isChanged = true; }
            if (mergeTiles(gameTiles[i])) { isChanged = true; }
        }
        if (isChanged) {addTile(); }
        isSaveNeeded = true;
    }

    private void rotateToRight() {
        Tile tmp;
        for (int i = 0; i < FIELD_WIDTH / 2; i++) {
            for (int j = i; j < FIELD_WIDTH - 1 - i; j++) {
                tmp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[FIELD_WIDTH-j-1][i];
                gameTiles[FIELD_WIDTH-j-1][i] = gameTiles[FIELD_WIDTH-i-1][FIELD_WIDTH-j-1];
                gameTiles[FIELD_WIDTH-i-1][FIELD_WIDTH-j-1] = gameTiles[j][FIELD_WIDTH-i-1];
                gameTiles[j][FIELD_WIDTH-i-1] = tmp;
            }
        }
    }

    void right() {
        saveState(gameTiles);
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
    }

    void up() {
        saveState(gameTiles);
        rotateToRight();
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
    }

    void down() {
        saveState(gameTiles);
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
        rotateToRight();
    }
    public boolean canMove() {
        if(!getEmptyTiles().isEmpty()) return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j-1].value)
                    return true;
            }
        }
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[j][i].value == gameTiles[j-1][i]. value)return true;
            }
        }
        return false;
    }

    public void randomMove(){
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n){
            case 0: left();
                break;
            case 1: right();
                break;
            case 2: up();
                break;
            case 3: down();
                break;
        }
    }

    private boolean hasBoardChanged(){
        Tile[][] prev = (Tile[][]) previousStates.peek();
        int currTile = 0;
        int prevTile = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                currTile += gameTiles[i][j].value;
                prevTile += prev[i][j].value;
            }
        }
        return currTile != prevTile;
    }

    public MoveEfficiency getMoveEfficiency(Move move){
        MoveEfficiency movEff = null;
        move.move();
        if (!hasBoardChanged()) {
            movEff = new MoveEfficiency(-1 ,0 ,move);
        } else {
            movEff = new MoveEfficiency(getEmptyTiles().size() ,score ,move);
        }
        rollback();
        return movEff;
    }

    public void autoMove(){
        PriorityQueue queue = new PriorityQueue(4, Collections.<MoveEfficiency>reverseOrder());
        queue.add(getMoveEfficiency(this::randomMove));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));
        MoveEfficiency efficientMove = (MoveEfficiency) queue.poll();
        efficientMove.getMove().move();
    }
}
