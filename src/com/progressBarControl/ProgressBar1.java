package com.progressBarControl;

public class ProgressBar1 {
    public ProgressBar1(int num,boolean isPercentage, int atNum) {
        setNum(num);
        if (atNum == 0) {
            init(isPercentage, num);
        }
    }

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private void init(boolean isPercentage, int num) {
        if (isPercentage) {
            System.out.println("Progress bar:");
            System.out.print("-".repeat(num) + " ,0.00%");
        } else {
            System.out.println("Progress bar:");
            System.out.print("-".repeat(num));
        }
    }

    public void updateProgress(String word, int atNum) {
        System.out.printf("\r %s", word.repeat(atNum) + "-".repeat(getNum() - atNum));
    }

    public void updatePercentage(int atNum, String word, double updatePercentage) {
        System.out.printf("\r %s%s  %.2f %%", word.repeat(atNum),"-".repeat(getNum() - atNum),updatePercentage);
    }
}
