
package ohtu;

public class Player {
    private String name;
    private int goals;
    private int assists;
    private String nationality;
    private String team;

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public String getName() {
        return name;
    }

    public int getGoalsAssists() {
        return goals+assists;
    }

    @Override
    public String toString() {
        return String.format("%-20s" + " %-5s " + goals + " + " + assists + " = " + getGoalsAssists(), name, team);
    }
      
}
