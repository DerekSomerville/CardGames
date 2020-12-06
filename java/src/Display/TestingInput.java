package Display;
import java.util.List;
import java.util.ArrayList;
public class TestingInput implements Input{

    private List<String> inputValues = new ArrayList<String>();

    public void addInputValue(String inputValue) {
        this.inputValues.add(inputValue);
    }

    public void clear(){
        this.inputValues.clear();
    }

    public String getInputString(){
        return inputValues.remove(0);
    };
    public int getInputInt(){
        return Integer.parseInt(getInputString());
    };
}
