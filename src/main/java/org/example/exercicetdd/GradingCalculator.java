package org.example.exercicetdd;

public class GradingCalculator {
    public int Score;
    public int AttendancePercentage;

    public GradingCalculator(int score, int attendancePercentage) {
        Score = score;
        AttendancePercentage = attendancePercentage;
    }

    public char getGrade() {
        if(Score > 90 && AttendancePercentage > 70) return 'A';
        else if(Score > 80 && AttendancePercentage > 60) return  'B';
        else if (Score > 60 && AttendancePercentage > 60) return  'C';
        else return 'F';
    }



    @Override
    public String toString() {
        return "Score : "+this.Score+"% " + " Présence : "+this.AttendancePercentage+" => ";
    }
}