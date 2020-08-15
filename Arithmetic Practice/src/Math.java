import java.util.Random;

public class Math{
    private int first;
    private int second;
    private int answer;

    public String createAdd(){
        Random random = new Random();
        first = random.nextInt(100);
        second = random.nextInt(100);
        answer = first + second;
        return first + " + " + second + " =  ?";
    }

    public String createMultiply(){
        Random random = new Random();
        first = random.nextInt(10);
        second = random.nextInt(10);
        answer = first * second;
        return first + " * " + second + " = ?";
    }

    public boolean checkMath(int check){
        return check == answer;
    }

    public int getAnswer(){return answer;}
}
