package LineTraceWithCalibration;

import jp.ac.kagawa_u.infoexpr.Sensor.ColorSensor;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Main {

    static ColorSensor rightColor = new ColorSensor(SensorPort.S2);
    static ColorSensor leftColor = new ColorSensor(SensorPort.S3);
    static RegulatedMotor rightMotor = Motor.B;;
    static RegulatedMotor leftMotor  = Motor.C;

    public static void main(String[] args) {
        /*=========================================================
         =                   キャリブレーション                   =
         =========================================================*/

        int catchcount = 2;     // とる色の数
        RGBCalibration rightCalibration = new RGBCalibration(catchcount, rightColor);
        RGBCalibration leftCalibration = new RGBCalibration(catchcount, leftColor);
        LCD.drawString("==Right Calibration==", 0, 0);
        enterPressWait();
        rightCalibration.executeCalibration();
        LCD.clear();
        LCD.drawString("==Leftt Calibration==", 0, 0);
        enterPressWait();
        leftCalibration.executeCalibration();
        enterPressWait();

        /*=========================================================
         =                    ライントレース                      =
         =========================================================*/
        int lowSpeed = 120;
        int highSpeed = 260;
        float leftValue[] = new float[3];
        float rightValue[] = new float[3];

        while(Button.ESCAPE.isUp()) {
            leftValue = getSensorValue(leftColor);
            rightValue = getSensorValue(rightColor);

            LCD.clear();
            LCD.drawString(colorDecision(leftValue, leftCalibration) + " " + colorDecision(rightValue, rightCalibration), 0, 0);
            LCD.refresh();
            Delay.msDelay(100);

            // 黒＆黒
            if( colorDecision(leftValue, leftCalibration) == "black" && colorDecision(rightValue, rightCalibration) == "black"){

            }
            // 黒＆白
            else if( colorDecision(leftValue, leftCalibration) == "black" && colorDecision(rightValue, rightCalibration) == "white"){
                motorSetSpeed(lowSpeed, highSpeed);
            }

            // 白＆黒
            else if( colorDecision(leftValue, leftCalibration) == "white" && colorDecision(rightValue, rightCalibration) == "black"){
                motorSetSpeed(highSpeed, lowSpeed);
            }

            // 白＆白
            else if( colorDecision(leftValue, leftCalibration) == "white" && colorDecision(rightValue, rightCalibration) == "white"){
                motorSetSpeed(highSpeed, highSpeed);
            }

            else {

            }
            motorForward();
        }
    }

    /**
     * キャリブレーションの値を元に色の判断
     * @param float[] 読み取ったRGB
     * @param RGBCalibration キャリブレーション済みのクラス
     * @return String 色
     **/
    private static String colorDecision(float[] sensorValue, RGBCalibration calibration) {
        float whiteWidth = 0.1F;   // 白判定の認識範囲
        float blackWidth = 0.01F;  // 黒安定の認識範囲
        boolean whiteFlag = true;
        boolean blackFlag = true;

        float whiteData[] = calibration.getCalibData(0);
        float blackData[] = calibration.getCalibData(1);

        int i;

        for(i = 0;i < 3;i++){
            if (sensorValue[i] < (whiteData[i] - whiteWidth ) || (whiteData[i] + whiteWidth ) < sensorValue[i]){
                whiteFlag = false;
            }
            if (sensorValue[i] < (blackData[i] - blackWidth ) || (blackData[i] + blackWidth ) < sensorValue[i]){
                blackFlag = false;
            }
        }
        if(whiteFlag) {
            return "white";
        }else if(blackFlag){
            return "black";
        }
        return "NONE";
    }



    /**
     * 真ん中ボタンが押されるまで停止
     **/
    private static void enterPressWait(){
        while(Button.ENTER.isUp()){}
        while(Button.ENTER.isDown()){}
    }

    /**
     * float型の小数第4位以下を除去
     * @param float[] float型の配列
     * @return float[] float型の配列
     **/
    private static float[] cleanDecimal(float f[]){
        for(int i = 0; i < f.length; i++) {
            f[i] = (float)Math.floor((double)f[i] * 1000) / 1000;
        }
        return f;
    }

    /**
     * 左右のモーターの前進
     **/
    private static void motorSetSpeed(int leftMotorSpeed, int rightMotorSpeed){
        leftMotor.setSpeed(leftMotorSpeed);
        rightMotor.setSpeed(rightMotorSpeed);
    }

    /**
     * 左右のモーターの前進
     **/
    private static void motorForward(){
        leftMotor.forward();
        rightMotor.forward();
    }

    /**
     * センサで値を取得し、小数部を加工
     * @param ColorSensor 値の取得に使用するセンサ
     * @return float[] 簡略化されたセンサの値
     **/
    private static float[] getSensorValue(ColorSensor s) {
        float f[];
        f = s.getHSV();
        f = cleanDecimal(f);
        return f;
    }
}