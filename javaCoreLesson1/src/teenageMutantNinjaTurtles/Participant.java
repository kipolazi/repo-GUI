package teenageMutantNinjaTurtles;

public class Participant {
    private String nameParticipant;
    private int damageArmlets;
    private int damageBoots;
    private int damageHelmet;
    private int damageChainmail;


    public Participant(String nameParticipant, int damageBoots, int damageHelmet, int damageArmlets, int damageChainmail) {
        this.nameParticipant = nameParticipant;
        this.damageBoots = damageBoots;
        this.damageHelmet = damageHelmet;
        this.damageArmlets = damageArmlets;
        this.damageChainmail = damageChainmail;
    }

    public String getNameParticipant() {
        return nameParticipant;
    }

    public int getDamageArmlets() {
        return damageArmlets;
    }

    public int getDamageBoots() {
        return damageBoots;
    }

    public int getDamageHelmet() {
        return damageHelmet;
    }

    public int getDamageChainmail() {
        return damageChainmail;
    }
}
