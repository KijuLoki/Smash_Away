package smashaway.goldenwork.com.smashaway.BClass;

/**
 * Created by kader on 12/08/2017.
 */

public class PoolItem{
    private int id;
    private String Name;
    private String ustensile;
    private String type;
    private String dateclaim;
    private String urlprofile;

    public PoolItem() {
    }

    public PoolItem(int id, String name, String ustensile, String type, String dateclaim, String urlprofile) {
        this.id = id;
        Name = name;
        this.ustensile = ustensile;
        this.type = type;
        this.dateclaim = dateclaim;
        this.urlprofile = urlprofile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUstensile() {
        return ustensile;
    }

    public void setUstensile(String ustensile) {
        this.ustensile = ustensile;
    }

    public String getDateclaim() {
        return dateclaim;
    }

    public void setDateclaim(String dateclaim) {
        this.dateclaim = dateclaim;
    }

    public String getUrlprofile() {
        return urlprofile;
    }

    public void setUrlprofile(String urlprofile) {
        this.urlprofile = urlprofile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "pool{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", ustensile='" + ustensile + '\'' +
                ", type='" + type + '\'' +
                ", dateclaim='" + dateclaim + '\'' +
                ", urlprofile='" + urlprofile + '\'' +
                '}';
    }
}
