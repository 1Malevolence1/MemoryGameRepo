package game;

public class Point {
    private int truePoint = 0;
    private int falsePoint = 0;

    public Point(){

    }

    public int getTruePoint() {
        return truePoint;
    }

    public void setTruePoint(int truePoint) {
        this.truePoint = truePoint;
    }

    public int getFalsePoint() {
        return falsePoint;
    }

    public void setFalsePoint(int falsePoint) {
        this.falsePoint = falsePoint;
    }


    public void addingPoints(boolean score) {
        if (score) setTruePoint(plusOnePoint(getTruePoint()));
        else {
            setFalsePoint(plusOnePoint(getFalsePoint()));
        }
    }
    private int plusOnePoint(int count){
            return count + 1;
        }

    public void printResultPoint(){
        System.out.println("Верно угаданных: " + getTruePoint());
        System.out.println("Неверно угаданных: " + getFalsePoint());
    }
}
