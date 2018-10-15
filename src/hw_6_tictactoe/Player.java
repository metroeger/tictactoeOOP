
package hw_6_tictactoe;

public class Player {
    private int score;
    
    public Player(){
       this.score = 0;
    }

    public void askInput(){
        System.out.println("Type your step: ");       
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }
    
}
