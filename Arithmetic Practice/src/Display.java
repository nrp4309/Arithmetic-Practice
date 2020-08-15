import javax.swing.*;

public class Display {
    private JButton Submit;
    public JPanel panel1;
    private JTextField Question;
    private JFormattedTextField Answer;
    private JTextField Feedback;
    private JTextField Correct;
    private JTextField Wrong;
    private JTextField Correct_label;
    private JTextField Wrong_label;
    private JButton Multiplication;
    private JButton Addition;
    private Math math;
    private boolean add;
    private int correct;
    private int wrong;

    public Display() {
        correct = 0;
        wrong = 0;
        add = true;
        math = new Math();
        Submit.addActionListener(e -> {
            String answer = readAnswer();
            String question = "";
            if(numCheck(answer)){
                if(math.checkMath(Integer.parseInt(answer))){
                    correct++;
                    if(correct%10==0){setFeedback("Good Job!");}
                    else{setFeedback("Correct!");}
                } else {
                    wrong++;
                    setFeedback("Sorry, correct answer was "+ math.getAnswer());
                }
                clearAnswer();
                updateScores();
                if(add){question = math.createAdd();}
                else{question = math.createMultiply();}
                setQuestion(question);
            }
            else{
                setFeedback("Please type a number.");
                clearAnswer();
            }
        });
        setQuestion(math.createAdd());
        Addition.addActionListener(e -> {
            if(!add){
                add = true;
                setQuestion(math.createAdd());
            }
            clearAnswer();
        });
        Multiplication.addActionListener(e -> {
            if(add){
                add = false;
                setQuestion(math.createMultiply());
            }
            clearAnswer();
        });
    }

    public boolean numCheck(String answer){
        answer = answer.strip();
        if(answer.equals("")){return false;}
        for(int i = 0;i<answer.length();i++){
            if(!Character.isDigit(answer.charAt(i))){return false;}
        }
        return true;
    }

    public void setQuestion(String question){
        Question.setText(question);
    }

    public void setFeedback(String feedback){
        Feedback.setText(feedback);
    }

    public void updateScores(){
        Wrong.setText(Integer.toString(wrong));
        Correct.setText(Integer.toString(correct));
    }

    public String readAnswer(){
        return Answer.getText();
    }

    public void clearAnswer(){
        Answer.setText("");
    }
}
