package org.tensorflow.demo;

import java.io.FileWriter;
import java.io.IOException;

public class LedControl {
    private static volatile LedControl ledControl = null;
    private Thread thread = null;
    private boolean exitFlag = false;
    private int sleepTime = 500;

    public static LedControl getInstance() {
        if (ledControl == null) {
            synchronized (LedControl.class) {
                if (ledControl == null) {
                    ledControl = new LedControl();
                }
            }
        }
        return ledControl;
    }

    public static synchronized void LedController(String group, boolean on) {
        int brightness = on ? 1 : 0;
        String cmd = "/sys/class/leds/" + group + "/brightness";
        try {
            FileWriter fw = new FileWriter(cmd);
            fw.write(String.valueOf(brightness));
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Led(Color color, boolean on) {
        switch (color) {
            case blue:
                blueLed(on);
                break;
            case orange:
                orangeLed(on);
                break;
            case muteLed:
                muteLed(on);
                break;
        }
    }

    public void LedSpinning(final boolean on) {

        exitFlag = !on;

        if (exitFlag && thread != null) {
            thread.interrupt();
        }

        if (thread != null)
            return;

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean flag = true;
                while (!exitFlag) {
                    LedController(flag ? "blue_led0" : "blue_led1", true);
                    LedController(flag ? "blue_led1" : "blue_led0", false);
                    flag = !flag;
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        offAllLed();
                        exit();
                    }
                }
                exit();
            }
        });
        thread.start();
    }

    final Object LED_lock = new Object();

    public void LedBlinkOneTime(final Color color){
        new Thread(new Runnable() {
            public void run() {
                synchronized (LED_lock) {
                    Led(color, true);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Led(color, false);
                }
            }
        }).start();
    }

    public void LedBlinking(final Color color, boolean on) {

        exitFlag = !on;

        if (exitFlag && thread != null) {
            thread.interrupt();
        }

        if (thread != null)
            return;

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean flag = true;
                while (!exitFlag) {
                    Led(color, flag);
                    flag = !flag;
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        offAllLed();
                        exit();
                    }
                }
                exit();
            }
        });
        thread.start();
    }

    private void exit() {
        thread = null;
    }

    private void offAllLed() {
        orangeLed(false);
        blueLed(false);
    }

    private void muteLed(boolean on) {
        LedController("mute_rled", on);
        LedController("btn_gled", !on);
    }

    private void orangeLed(boolean on) {
        LedController("amber_led", on);
    }

    private void blueLed(boolean on) {
        LedController("blue_led0", on);
        LedController("blue_led1", on);
    }

    public enum Color {blue, orange, muteLed}
}
