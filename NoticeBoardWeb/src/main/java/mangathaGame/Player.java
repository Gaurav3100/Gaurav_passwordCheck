package mangathaGame;

public class Player {
    private int bet;
    private Card choosenCard;
    private boolean position;
    private int cash;

    public Player() {
        bet = 0;
        choosenCard = new Card("AS");
        position = false;
        cash = 0;
    }

    public Player(Player p) {
        bet = p.bet;
        choosenCard = p.choosenCard;
        position = p.position;
        cash = p.cash;
    }

    public void setPlayer(String bet,String card,String pos) {
        this.bet = Integer.parseInt(bet);
        this.choosenCard = new Card(card);
        if(pos.toLowerCase().equals("in"))
            this.position = false;
        else
            this.position = true;
    }

 

    public int getBet() {
        return bet;
    }

 

    public Card getChoosenCard() {
        return choosenCard;
    }

 

    public boolean isPosition() {
        return position;
    }

 

    public int getCash() {
        return cash;
    }

 

    public void setCash(int bet) {
        this.cash += bet;
    }

}
