public class OffByN implements CharacterComparator {

    private int Num;

    public OffByN(int N) {
        this.Num = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return (x - y == Num || y - x == Num);
    }
}
