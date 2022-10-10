package teenageMutantNinjaTurtles;


public class Team {
    private String nameTeam;
    private Participant[] participants;

    public Team(String nameTeam, Participant[] participants) {
        this.nameTeam = nameTeam;
        this.participants = participants;
    }

    public String toString(Team team) {
        for (Participant participants : team.participants) {
            System.out.println("Черепашка(" + participants.getNameParticipant() + ") имеет урон сквозь нарукавники = " + participants.getDamageArmlets() + ", урон сквозь сапоги = " + participants.getDamageBoots() + ", урон сквозь шлем = " + participants.getDamageHelmet() + ", урон сквозь броник = " + participants.getDamageChainmail());
        }
        System.out.println('\n');
        return null;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public Participant[] getParticipants() {
        return participants;
    }


    public static void main(String[] args) {
//        Создаю массив участников
        Participant[] participants = new Participant[4];
        participants[0] = new Participant("Leonardo", 6, 20, 5, 59);
        participants[1] = new Participant("Donatello", 4, 19, 6, 55);
        participants[2] = new Participant("Michelangelo", 5, 22, 8, 50);
        participants[3] = new Participant("Rafaele", 8, 23, 4, 60);
//        Создаю команду из массива участников
        Team team = new Team("mutantNinjaTurtles", participants);
//        Печатаю инфу обо всех участниках
        System.out.println("Информация обо всех участниках команды: ");
        team.toString(team);
//        Создаю массив препятсвий
        Let[] lets = new Let[3];
        lets[0] = new Let("standardArmor", 1, 41, 14, 2);
        lets[1] = new Let("standardArmorPlusBaf", 2, 51, 16, 3);
        lets[2] = new Let("standardArmorPlusBafX2", 7, 51, 19, 4);
//        Создаю Шреддера с разными броньками из массива выше
        Course shredder = new Course(lets);
//        Прошу наших черепашек вступить в файт сo Шреддерем и посмотреть на что они способны(каждый сам за себя) по отношению к виду его брони и записываю результат в переменную
        String result = shredder.doIt(team, shredder);
//        Печатаю результат в консоль
        System.out.println(result);
    }
}
