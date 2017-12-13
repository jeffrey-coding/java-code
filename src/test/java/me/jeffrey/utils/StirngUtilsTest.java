package me.jeffrey.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * StirngUtils Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>九月 14, 2017</pre>
 */
public class StirngUtilsTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: isNumber(String str)
     */
    @Test
    public void testIsNumberTrue() throws Exception {

        assertTrue(StirngUtils.isNumber("0"));
        System.out.println(Float.parseFloat("0"));
        System.out.println(Float.parseFloat("2.75011e-05"));

        assertTrue(StirngUtils.isNumber("1"));
        System.out.println(Float.parseFloat("1"));

        assertTrue(StirngUtils.isNumber("1.0"));
        System.out.println(Float.parseFloat("1.0"));

        assertTrue(StirngUtils.isNumber("0.1"));
        System.out.println(Float.parseFloat("0.1"));

        assertTrue(StirngUtils.isNumber("0.0"));
        System.out.println(Float.parseFloat("0.0"));

        assertTrue(StirngUtils.isNumber("-1"));
        System.out.println(Float.parseFloat("-1"));

        assertTrue(StirngUtils.isNumber("-1.0"));
        System.out.println(Float.parseFloat("-1.0"));

        assertTrue(StirngUtils.isNumber("-0.1"));
        System.out.println(Float.parseFloat("-0.1"));

        assertTrue(StirngUtils.isNumber("-0.0"));
        System.out.println(Float.parseFloat("-0.0"));
    }

    @Test
    public void testIsNumberFalse() throws Exception {
        String[] s = {"", " ", "a", ".", "-", "+", " .", " +", " 1", "1 ", "1 1"};

        for(int i = 0; i < s.length; i++){
            try{
                System.out.println(Float.parseFloat(s[i]));
                System.out.println("str [" + s[i] + "] is float");
            }catch (Exception e){
                assertFalse(StirngUtils.isNumber(s[i]));
            }
        }

    }


} 
