package test;

import main.model.Personality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Unit tests for the Personality class
public class PersonalityTest {
    Personality intj;
    Personality intp;
    Personality entj;
    Personality entp;
    Personality infj;
    Personality infp;
    Personality enfj;
    Personality enfp;
    Personality istj;
    Personality isfj;
    Personality estj;
    Personality esfj;
    Personality istp;
    Personality isfp;
    Personality estp;
    Personality esfp;

    @BeforeEach
    void runBefore() {
        intj = new Personality(0,0,3,3);
        intp = new Personality(0,0,3, 0);
        entj = new Personality(3,0,3,3);
        entp = new Personality(3,0,3,0);
        infj = new Personality(0,0,0,3);
        infp = new Personality(0,0,0,0);
        enfj = new Personality(3,0,0,3);
        enfp = new Personality(3,0,0,0);
        istj = new Personality(1,2,2,2);
        isfj = new Personality(1,2,1,2);
        estj = new Personality(2,2,2,2);
        esfj = new Personality(2,2,1,2);
        istp = new Personality(1,2,2,1);
        isfp = new Personality(1,2,1,1);
        estp = new Personality(2,2,2,1);
        esfp = new Personality(2,2,1,1);
    }

    @Test
    void testConstructor() {
        assertEquals(0, intj.getEi());
        assertEquals(0, intp.getSn());
        assertEquals(0, infj.getTf());
        assertEquals(0, entp.getJp());
        assertEquals(3, entp.getEi());
        assertEquals(2, estj.getSn());
        assertEquals(1, esfj.getTf());
        assertEquals(2, isfj.getJp());
        estp.incrementEi();
        assertEquals(3,estp.getEi());

    }

    @Test
    void testEvaluator() {
        assertEquals("INTJ", intj.evaluateMBTI());
        assertEquals("INTP", intp.evaluateMBTI());
        assertEquals("ENTJ", entj.evaluateMBTI());
        assertEquals("ENTP", entp.evaluateMBTI());
        assertEquals("INFJ", infj.evaluateMBTI());
        assertEquals("INFP", infp.evaluateMBTI());
        assertEquals("ENFJ", enfj.evaluateMBTI());
        assertEquals("ENFP", enfp.evaluateMBTI());
        assertEquals("ISTJ", istj.evaluateMBTI());
        assertEquals("ISFJ", isfj.evaluateMBTI());
        assertEquals("ESTJ", estj.evaluateMBTI());
        assertEquals("ESFJ", esfj.evaluateMBTI());
        assertEquals("ISTP", istp.evaluateMBTI());
        assertEquals("ISFP", isfp.evaluateMBTI());
        assertEquals("ESTP", estp.evaluateMBTI());
        assertEquals("ESFP", esfp.evaluateMBTI());
    }
}
