public class Name {
    String first;
    String last;
    String lastCommaFirst;

    public Name (String first, String last){
        this.first = first;
        this.last = last;
        setLastCommaFirst();
    }

    private void setLastCommaFirst() {
        if (last != null){
            this.lastCommaFirst = last + ", " + first;
        } else {
            this.lastCommaFirst = first;
        }

    }
}