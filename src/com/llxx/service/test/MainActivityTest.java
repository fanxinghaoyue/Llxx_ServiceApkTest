/**
 * 
 */
package com.llxx.service.test;

import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

/**
 * @author 李万隆
 * @date   2016年8月18日
 * @qq 	461051353
 * @describe 类描述
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2
{

    // com.llxx.service.
    private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.llxx.socket.MainActivity";//启动类

    private static Class<?> launcherActivityClass;
    static
    {
        try
        {
            launcherActivityClass = Class
                    .forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public MainActivityTest() throws ClassNotFoundException
    {
        super(launcherActivityClass);
    }

    private Solo solo;

    @Override
    protected void setUp() throws Exception
    {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    /**
     * 测试启动数据
     * @throws Exception
     */
    public void testcaseStartActiviry() throws Exception
    {
        //等待  Activity　"MainActivity"　启动
        assertTrue("无法启动启动类", solo.waitForActivity("MainActivity", 30000));
        solo.sleep(5000);
    }

    /**
     * 测试点击按钮
     * @throws Exception
     */
    public void testcaseClickButton() throws Exception
    {
        //按下 按钮 "绿色"
        solo.clickOnButton("^发送数据$");
        solo.sleep(2000);
    }

    @Override
    public void tearDown() throws Exception
    {
        solo.finishOpenedActivities();

    }

}
