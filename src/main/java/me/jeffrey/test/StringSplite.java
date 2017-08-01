package me.jeffrey.test;

import com.google.common.base.Splitter;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by jeffreysun on 2017/8/1.
 */
public class StringSplite {
    private final static String input = "sysID=9900194&intfID=60&timestamp=20170725164845&logtime=20170725164845000&version=1.8.4&fullVersion=1.8.4.94.OpenSDK_1.8.4_KG- 27701&osType=ANDROID&appId=1400000482&apn=WIFI&country=其他&province=未知&isp=未知&accIp=121.51.32.92&accType=DC&connectType=UDP&getCfgResult=65536&getAccIpUsedTime=139&getAccIpResult=0&getAccIpVald=1&getAccIpSucc=1&getAccIpFail=0&connAccUsedTime=60&connAccResult=0&connAccVald=1&connAccSucc=1&connAccFail=0&reqViewUsedTime=15&reqViewResult=0&firstPkgUsedTime=265&firstViewUsedTime=556&firstFrameViewUsedTime=556&ffDecResult=0&exitRoomUsedTime=130&exitRoomResult=0&sendLossRateRaw=0&sendLossRateResend=0&sendUnsendData=0&sendLossRateCnt=0&recvLossRateRaw=31&recvLossRateResend=0&recvLossRateCnt=15&mainVideoDecFps=109&mainVideoDecBitRate=370&mainVideoBlackScr=0&mainVideoCnt=2&usrHasNoFlow=0&audHasNoFlow=0&audioSendBitrate=0&audioSendCnt=0&audioRecvBitrate=160&audioRecvCnt=1&encodeTotalFreezeRate=0&encodeTotalFreezeCnt=1&decodeTotalFreezeRate=0.0141491&decodeTotalFreezeCnt=1&recvBlackValidCnt=7&recvBlackTimes=5&dt=1500972525360&sid=0x0ae59423315562f30c591888dbc00000#10.229.148.35:21946&cp=snappy&cnt=1&NodeIP=10.229.148.35&rt=1500972525448&m=9&mid=2340&tid=node_report_monitor&bid=b_teg_rtindex_sng_video";
    private final static Splitter.MapSplitter mapSplitter = Splitter.on("&").withKeyValueSeparator("=");

    static Map<String,String> split(){
        String[] array = input.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String items : array) {
            String[] item = items.split("=", 2);
            if (item.length == 2) {
                map.put(item[0], item[1].trim());
            }
        }

        return map;
    }

    /**
     * 效率最优，但数据有异常时，会出现出具移位
     * @return
     */
    static Map<String,String> stringTokenizer(){
        StringTokenizer st = new StringTokenizer(input);
        Map<String, String> map = new HashMap<String, String>();
        while (st.hasMoreElements()){
            map.put(st.nextToken("="),st.nextToken("&"));
        }
        return map;
    }

    /**
     * 效率不是与原生split相当，数据异常时会报异常
     * @return
     */
    static Map<String,String> stringTokenizer2(){
        StringTokenizer st = new StringTokenizer(input,"&");
        Map<String, String> map = new HashMap<String, String>();
        while (st.hasMoreElements()){
            StringTokenizer st2 = new StringTokenizer(st.nextToken(),"=");
            map.put(st2.nextToken(),st2.nextToken());
        }
        return map;
    }

    /**
     * 没有效率方面优化，方便代码阅读
     * @return
     */
    static Map<String,String> splitter(){

        Map<String,String> splitMap = mapSplitter.split(input);
        return splitMap;
    }

    /**
     * 在这5种方法中，效率较高，数据异常时问题数据较少
     * @return
     */
    static Map<String,String> stringUtilsSplit(){
        String[] array = StringUtils.split(input,"&");
        Map<String, String> map = new HashMap<String, String>();
        for (String items : array) {
            String[] item = StringUtils.split(items,"=", 2);
            if (item.length == 2) {
                map.put(item[0], item[1].trim());
            }
        }

        return map;
    }
}
