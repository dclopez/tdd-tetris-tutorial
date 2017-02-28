package tetris;

public class Block implements BoardPiece {

    private final char block;

    public Block(char block) {
        this.block = block;
    }

    public String toString() {
        char block_as_string[] = { block };
        return new String(block_as_string);
    }

    public int width() {
        return 1;
    }

    public int height() {
        return 1;
    }

    public boolean is_hollow_at(int i, int j) {
        return ((i!=0) && (j!=0));

    }

}