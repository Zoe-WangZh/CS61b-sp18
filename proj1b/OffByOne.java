public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char s1, char s2) {
        return (s1 - s2 == 1) || (s2 - s1 == 1);
    }

}
