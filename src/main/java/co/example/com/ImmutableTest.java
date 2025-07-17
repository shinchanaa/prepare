package co.example.com;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableTest {
    private final int id;
    private final String str;
    private final List<String> listD;

    public ImmutableTest(int id, String str, List<String> listD) {
        this.id = id;
        this.str = str;
        // Defensive copy to avoid external modification
        this.listD = new ArrayList<>(listD);
    }

    public int getId() {
        return id;
    }

    public String getStr() {
        return str;
    }

    public List<String> getListD() {
        // Defensive copy in getter
        //return  listD;
        return new ArrayList<>(listD);
        // Or: return Collections.unmodifiableList(listD);
    }
}