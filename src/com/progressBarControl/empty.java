package com.progressBarControl;

public class empty {
    public empty(String word, boolean isPercentage, long length) {
        setNum(10);
        setIsPercentage(isPercentage);
        setWord(word);
        setMultiple(length/num);
        setLength(length);
        setProgressBar1(new ProgressBar1(getNum(),isPercentage(),getAtNum()));
    }

    public empty(int num, String word, boolean isPercentage, long length) {
        setNum(num);
        setIsPercentage(isPercentage);
        setWord(word);
        setMultiple(length/num);
        setLength(length);
        setProgressBar1(new ProgressBar1(getNum(),isPercentage(),getAtNum()));
    }

    private String word;


    private long length;
    private boolean isPercentage;

    private double percentage = 0.0;

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    private ProgressBar1 progressBar1;

    // Num of Data
    private int num = 10;

    // At num
    private int atNum = 0;

    // Progress bar at present
    private long atPresent = 0;

    // Multiple of length/num
    private long multiple;

    public void setIsPercentage(boolean isPercentage) {
        this.isPercentage = isPercentage;
    }

    public void setProgressBar1(ProgressBar1 progressBar1) {
        this.progressBar1 = progressBar1;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ProgressBar1 getProgressBar1() {
        return progressBar1;
    }

    public String getWord() {
        return word;
    }

    public boolean isPercentage() {
        return isPercentage;
    }

    public int getNum() {
        return num;
    }

    public int getAtNum() {
        return atNum;
    }

    public void setAtNum(int atNum) {
        this.atNum = atNum;
    }

    public long getAtPresent() {
        return atPresent;
    }

    public void setAtPresent(long atPresent) {
        this.atPresent = atPresent;
    }

    public long getMultiple() {
        return multiple;
    }

    public void setMultiple(long multiple) {
        this.multiple = multiple;
    }

    public void updateAtPresent(){
        setAtPresent(getAtPresent()+1);
    }

    public void updateAtNum(){
        if((getAtPresent()/getMultiple()) == (getAtNum()+1)){
            setAtNum(getAtNum()+1);
        }
    }

    private boolean isUpdateAtNum(){
        // Update to at present everytime.
        updateAtPresent();
        // Record to at num.
        int i = getAtNum();
        // Update to at present.
        updateAtNum();
        return i < getAtNum();
    }

    private void updatePercentage(){
        // 设置小数点后保留两位
        String j = String.format("%.2f",(double) getAtPresent()/getLength()*100);

        double i = Double.parseDouble(j);
        if(i > getPercentage()){
            setPercentage(i);
        }
    }

    private boolean isUpdateAtPresent(){
        double i = getPercentage();
        updateAtPresent();
        updateAtNum();
        updatePercentage();
        return i < getPercentage();
    }

    public void toProgressBar_1() {
        if (!isPercentage) {
            if (isUpdateAtNum()) {
                getProgressBar1().updateProgress(getWord(), getAtNum());
            }
        }else {
            if(isUpdateAtPresent()){
                getProgressBar1().updatePercentage(getAtNum(), getWord(),getPercentage());
            }
        }
    }
}
