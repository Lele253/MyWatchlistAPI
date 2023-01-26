package apis.Manga.API.Entety;

import javax.persistence.*;

@Entity
public class Champ {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long champId;
    private String name;
    private String cost;
    private String skill;
    private String mana;
    private String trait1;
    private String trait2;
    private String trait3;
    private String bildURL;

    public Champ(String name, String cost, String skill, String mana, String trait1, String trait2, String trait3, String bildURL) {
        this.name = name;
        this.cost = cost;
        this.skill = skill;
        this.mana = mana;
        this.trait1 = trait1;
        this.trait2 = trait2;
        this.trait3 = trait3;
        this.bildURL = bildURL;
    }

    public Champ() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBildURL() {
        return bildURL;
    }

    public void setBildURL(String bildURL) {
        this.bildURL = bildURL;
    }

    public long getCombId() {
        return champId;
    }

    public String getTrait1() {
        return trait1;
    }

    public void setTrait1(String trait1) {
        this.trait1 = trait1;
    }

    public String getTrait2() {
        return trait2;
    }

    public void setTrait2(String trait2) {
        this.trait2 = trait2;
    }

    public String getTrait3() {
        return trait3;
    }

    public void setTrait3(String trait3) {
        this.trait3 = trait3;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getMana() {
        return mana;
    }

    public void setMana(String mana) {
        this.mana = mana;
    }
}



