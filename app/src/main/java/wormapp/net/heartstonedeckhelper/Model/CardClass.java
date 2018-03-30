package wormapp.net.heartstonedeckhelper.Model;

/**
 * Created by hamdi on 12/07/15.
 */
public class CardClass {

    private int id;
    private String lib;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLib() {
        return lib;
    }


    public void setLib(String lib) {
        this.lib = lib;
    }

    @Override
    public String toString() {
        return "CardClass{" +
                "id=" + id +
                ", lib='" + lib + '\'' +
                '}';
    }
}
