package com.fanhf.javastudy.classcodetest;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-23 12:27
 */
public class MultipleConditionJumpTest {
    public void switch1(int select) {
        int num;
        switch (select) {
            case 1:
                num = 10;
                break;
            case 2:
                num = 20;
                break;
            case 3:
                num = 30;
                break;
            case 4:
                num = 40;
                break;
            default:
                num = 50;
        }
    }

    public void switch2(int select) {
        int num;
        switch (select) {
            case 100:
                num = 10;
                break;
            case 500:
                num = 20;
                break;
            case 300:
                num = 30;
                break;
            case 400:
                num = 40;
                break;
            default:
                num = 50;
        }
    }

    public void switch3(String season) {
        switch (season) {
            case "SPRING":
                break;
            case "SUMMER":
                break;
            case "AUTUMN":
                break;
            case "WINTER":
                break;
        }
    }
}   
