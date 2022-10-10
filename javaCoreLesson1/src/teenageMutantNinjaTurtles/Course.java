package teenageMutantNinjaTurtles;

public class Course extends Let {
    private Let[] lets;
    private String result;


    public Course(Let[] lets) {
        this.lets = lets;

    }

    public Let[] getLets() {
        return lets;
    }


    public String doIt(Team team, Course shredder) {
        result = "Войны из команды(" + team.getNameTeam() + "), указанные ниже - одолели данного монстра: " + '\n';
        for (Participant participants : team.getParticipants()) {
            for (Let lets : shredder.getLets()) {
                result += participants.getNameParticipant() + ": " + '\n';
                if (participants.getDamageArmlets() > lets.getArmorArmlets() && participants.getDamageChainmail() > lets.getArmorChainmail() && participants.getDamageHelmet() > lets.getArmorHelmet() && participants.getDamageBoots() > lets.getArmorBoots()) {
                    result += "- Справился с " + lets.getNameLet() + '\n';
                } else result += "- Не справился c " + lets.getNameLet() + '\n';
            }
        }
        return result;
    }

}
