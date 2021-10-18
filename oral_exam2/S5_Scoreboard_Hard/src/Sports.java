public abstract class Sports {
private int currentPeriod;
private String[] teams = new String[2];
private int[] score = new int[2];
private boolean gameOver;

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }



    /** superclass sports constructor
     * */
    public Sports(String team1,String team2) {
        teams[0] = team1; //team 1
        teams[1] = team2;//team 2

        gameOver = false;//start game
    }

    /** set the teams */
    public void setTeams(String team1,String team2) {
        teams[0] = team1;
        teams[1] = team2;
    }

    /** get the teams*/
    public String getTeams(int teamNumber) {
//        return "team 1: " + teams[0] + " - " + "team 2: " + teams[1];
        return teams[teamNumber-1];
    }

    /** get score*/
    public int[] getScore() {
        return score;
    }

    /** get scoreboard*/
    public String getScoreBoard(){
        return teams[0] + ": " + score[0] + " - " + teams[1] + ": " + score[1];
    }

    public void setScore(int teamNO, int points){
        score[teamNO] = points;
    }

    /** abstract method to add score according to each subclass */
    abstract public void addScore(int scoringMethodNo);

    /** getScoring Methods abstract method for each subclass to implement*/
    abstract public String getScoringMethods();

    /** start game method*/
    public void startTheGame(){
        setCurrenPeriod(1);
    }

    /** method to end the current period of game  */
    public void endCurrentPeriod() {
        setCurrenPeriod(getCurrentPeriod()+1);
        checkGameOver();
    }
    /** method to get the lenght of the period*/
    abstract public String getLengthOfPeriod();

    /** get the game period object for the class */
    public int getCurrentPeriod(){return currentPeriod;}

    public void setCurrenPeriod(int periodNo){currentPeriod = periodNo; }

    /** method to get the name of the period */
    abstract public String getPeriodName();

    /** is the game over?*/
    abstract public void checkGameOver();

    /** declare the winning team */
    public String winningTeam(){

        if (score[0] > score[1]){
            return teams[0];
        }
        else if (score[1] > score[0]){
            return teams[1];
        }
        else{
            return "no winner, game tied" ;
        }
    }
}
