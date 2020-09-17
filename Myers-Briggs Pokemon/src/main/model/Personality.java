package main.model;

// Represents one of the 16 Myers-Briggs types having an index from 0-3 for each descriptor set
public class Personality {
    public int ei;          // Extroversion Introversion Index (3 being most extroverted and 0 being most introverted)
    public int sn;          // Sensing Intuition Index (3 being most sensing and 0 being most intuitive)
    public int tf;          // Thinking Feeling Index (3 being most thinking and 0 being most feeling)
    public int jp;          // Judging Perceiving Index (3 being most judging and 0 being most perceiving)

    // REQUIRES: 3 >= ei >= 0
    //           3 >= sn >= 0
    //           3 >= tf >= 0
    //           3 >= jp >= 0
    // EFFECTS: ei is set to eiScore, sn is set to snScore, tf is set to tfScore, jp is set to jpScore
    public Personality(int eiScore, int snScore, int tfScore, int jpScore) {
        ei = eiScore;       // Extroversion Introversion Index (3 being most extroverted and 0 being most introverted)
        sn = snScore;       // Sensing Intuition Index (3 being most sensing and 0 being most intuitive)
        tf = tfScore;       // Thinking Feeling Index (3 being most thinking and 0 being most feeling)
        jp = jpScore;       // Judging Perceiving Index (3 being most judging and 0 being most perceiving)
    }

    public int getEi() {
        return ei;
    }

    public int getSn() {
        return sn;
    }

    public int getTf() {
        return tf;
    }

    public int getJp() {
        return jp;
    }

    public void incrementEi() {
        ei ++;
    }

    public void incrementSn() {
       sn ++;
    }

    public void incrementTf() {
        tf ++;
    }

    public void incrementJp() {
        jp ++;
    }


    // EFFECTS: returns the MBTI type result of a given Personality based on the scores of each index
    public String evaluateMBTI() {
        if (ei >= 2 & sn >= 2 & tf >= 2 & jp >= 2) {
            return "ESTJ";
        } else if (ei < 2 & sn >= 2 & tf >= 2 & jp >= 2) {
            return "ISTJ";
        } else if (ei < 2 & sn < 2 & tf >= 2 & jp >= 2) {
            return "INTJ";
        } else if (ei < 2 & sn < 2 & tf < 2 & jp >= 2) {
            return "INFJ";
        } else if (ei < 2 & sn < 2 & tf < 2 & jp < 2) {
            return "INFP";
        } else if (ei >= 2 & sn < 2 & tf < 2 & jp < 2) {
            return "ENFP";
        } else if (ei >= 2 & sn >= 2 & tf < 2 & jp < 2) {
            return "ESFP";
        } else if (ei >= 2 & sn >= 2 & tf >= 2 & jp < 2) {
            return "ESTP";
        } else if (ei >= 2 & sn >= 2 & tf < 2 & jp >= 2) {
            return "ESFJ";
        } else if (ei >= 2 & sn < 2 & tf >= 2 & jp >= 2) {
            return "ENTJ";
        } else if (ei >= 2 & sn < 2 & tf >= 2 & jp < 2) {
            return "ENTP";
        } else if (ei < 2 & sn < 2 & tf >= 2 & jp < 2) {
            return "INTP";
        } else if (ei < 2 & sn >= 2 & tf >= 2 & jp < 2) {
            return "ISTP";
        } else if (ei < 2 & sn >= 2 & tf < 2 & jp < 2) {
            return "ISFP";
        } else if (ei < 2 & sn >= 2 & tf < 2 & jp >= 2) {
            return "ISFJ";
        } else {
            return "ENFJ";
        }
    }
}