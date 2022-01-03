package me.anamila.simplenotes;

public class Notes {
    String judul;
    String catatan;

    public Notes(String judul, String catatan) {
        this.judul = judul;
        this.catatan = catatan;
    }

    @Override
    public String toString() {
        return judul + '\n' + "---------\n" + catatan + "\n===========\n";
    }
}
