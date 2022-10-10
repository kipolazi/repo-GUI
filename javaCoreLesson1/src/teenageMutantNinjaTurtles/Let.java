package teenageMutantNinjaTurtles;

public class Let {
    private String nameLet;
    private int armorArmlets;
    private int armorBoots;
    private int armorHelmet;
    private int armorChainmail;

    public Let(String nameLet, int armorBoots, int armorChainmail, int armorHelmet, int armorArmlets) {
        this.nameLet = nameLet;
        this.armorBoots = armorBoots;
        this.armorChainmail = armorChainmail;
        this.armorHelmet = armorHelmet;
        this.armorArmlets = armorArmlets;
    }

    public Let() {
    }


    public String getNameLet() {
        return nameLet;
    }

    public int getArmorArmlets() {
        return armorArmlets;
    }

    public int getArmorBoots() {
        return armorBoots;
    }

    public int getArmorHelmet() {
        return armorHelmet;
    }

    public int getArmorChainmail() {
        return armorChainmail;
    }
}
