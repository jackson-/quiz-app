package models;

/**
 * Created by devin on 9/8/2015.
 */
public class Problem {
    private static String mQuestion;
    private static String mChoice1;
    private static String mChoice2;
    private static String mChoice3;
    private static String mChoice4;
    private static int mAnswer;

    public Problem(String mQuestion, String mChoice1, String mChoice2, String mChoice3, String mChoice4, int mAnswer){
        mQuestion = mQuestion;
        mChoice1 = mChoice1;
        mChoice2 = mChoice2;
        mChoice3 = mChoice3;
        mChoice4 = mChoice4;
        mAnswer = mAnswer;
    }

    public static int getmAnswer() {
        return mAnswer;
    }

    public static void setmAnswer(int mAnswer) {
        Problem.mAnswer = mAnswer;
    }

    public static String getmQuestion() {
        return mQuestion;
    }

    public static void setmQuestion(String mQuestion) {
        Problem.mQuestion = mQuestion;
    }

    public static String getmChoice1() {
        return mChoice1;
    }

    public static void setmChoice1(String mChoice1) {
        Problem.mChoice1 = mChoice1;
    }

    public static String getmChoice2() {
        return mChoice2;
    }

    public static void setmChoice2(String mChoice2) {
        Problem.mChoice2 = mChoice2;
    }

    public static String getmChoice3() {
        return mChoice3;
    }

    public static void setmChoice3(String mChoice3) {
        Problem.mChoice3 = mChoice3;
    }

    public static String getmChoice4() {
        return mChoice4;
    }
    public static void setmChoice4(String mChoice4) {
        Problem.mChoice4 = mChoice4;
    }
}
