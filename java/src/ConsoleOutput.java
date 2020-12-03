import java.util.ArrayList;

public class ConsoleOutput implements Output{
    public void output(String display){
        System.out.println(display);
    }
    public void output(ArrayList<String> displayOutput){
        for (String display : displayOutput){
            System.out.println(display);
        }
    }
//    public void output(ArrayList<Card> hand){
//        for (Card card : hand){
//            System.out.println(card.display());
//        }
//    }
}
