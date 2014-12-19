package cn.com.ubing.msg.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.tencent.xinge.ClickAction;
import com.tencent.xinge.Message;
import com.tencent.xinge.MessageIOS;
import com.tencent.xinge.Style;
import com.tencent.xinge.TimeInterval;
import com.tencent.xinge.XingeApp;

public class SendXinGeMsg {
    /**
     * 
     * @author 邱全松 2014-9-4 上午9:24:15
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Map<String, Object> custom = new HashMap<String, Object>();
        custom.put("requirementId", 2);
        custom.put("requirementType", 3);
        custom.put("requirementTitle", "07-15从香港到北");
        custom.put("endTime", new Date().getTime()+2222222222222L);

        Long AndroidAccessId = 2100046682L;
        Long IosAccessId = 2200064929L;
        Long IosCAccessId=2200065934L;
        String AndroidSecretKey = "18360564748e06a45ee53d7de98e8c4e";
        String IosSecretKey = "e572ae7f932f7890bcb87f15930e423c";
        String IosCSecretKey = "0dcafee6c3d0050366b20f408c234fd5";
        
        String token = "c4669023a968f77782c18f9bd2bd9a3b2f75132bc59dfac7624028879174d252";
        JSONObject result = pushSingleDeviceToIOS(1,IosCAccessId, IosCSecretKey, custom, token);
        System.out.print(result);

        // String token = "eaeb810b39f9b95047be8f5df25716dddd02f7d1";
         //JSONObject result = pushSingleDeviceMessageToAndroid(AndroidAccessId,AndroidSecretKey,custom,token);
        // JSONObject result = pushAllDeviceToAndriod(AndroidAccessId,AndroidSecretKey,custom);
        
//        
//        System.out.println("ios信鸽消息："+SendXinGeMsg.pushAllDeviceToIos(1,IosAccessId, IosSecretKey, custom, 2));
//        System.out.println("ios信鸽消息："+SendXinGeMsg.pushAllDeviceToIos(1,IosCAccessId, IosCSecretKey, custom, 2));
//        System.out.println("Android信鸽消息："+SendXinGeMsg.pushAllDeviceToAndriod(1,AndroidAccessId, AndroidSecretKey, custom));
    }

    // 下发消息到单个Android设备
    public static JSONObject pushSingleDeviceMessageToAndroid(Integer type,Long AndroidAccessId, String AndroidSecretKey, Map<String, Object> custom,
            String token) {
        Message message = buildMsgAndriod(type,custom);
        XingeApp xinge = new XingeApp(AndroidAccessId, AndroidSecretKey);
        JSONObject ret = xinge.pushSingleDevice(token, message);
        return ret;
    }

    // 下发消息到单个IOS设备
    public static JSONObject pushSingleDeviceToIOS(Integer type,Long IosAccessId, String IosSecretKey, Map<String, Object> custom, String token) {
        MessageIOS message = buildMsgIOS(type,custom);
        XingeApp xinge = new XingeApp(IosAccessId, IosSecretKey);
        JSONObject ret = xinge.pushSingleDevice(token, message, XingeApp.IOSENV_DEV);
        return (ret);
    }

    // 下发消息到所有android设备
    public static JSONObject pushAllDeviceToAndriod(Integer type,Long AndroidAccessId, String AndroidSecretKey, Map<String, Object> custom) {
        Message message = buildMsgAndriod(type,custom);
        XingeApp xinge = new XingeApp(AndroidAccessId, AndroidSecretKey);
        JSONObject ret = xinge.pushAllDevice(XingeApp.DEVICE_ALL, message);
        return (ret);
    }

    // 下发消息到所有IOS设备
    public static JSONObject pushAllDeviceToIos(Integer type,Long IosAccessId, String IosSecretKey, Map<String, Object> custom, int environment) {
        MessageIOS message = buildMsgIOS(type,custom);
        XingeApp xinge = new XingeApp(IosAccessId, IosSecretKey);
        JSONObject ret = xinge.pushAllDevice(XingeApp.DEVICE_ALL, message, environment);
        return (ret);
    }

    // 设置message公共参数
    public static Message buildMsgAndriod(Integer type,Map<String, Object> custom) {
        Message message = new Message();
        message.setType(Message.TYPE_NOTIFICATION);
        Style style = new Style(1);
        style = new Style(3, 1, 0, 1, 0);
        ClickAction action = new ClickAction();
        action.setActionType(ClickAction.TYPE_ACTIVITY);
	action.setActivity("com.hanglv.c2b.ui.c2b_pushActivity");
        // action.setActionType(ClickAction.TYPE_URL);
        // action.setUrl("http://www.baidu.com");
        message.setTitle("游必应");
        if(type==1){
            message.setContent("您有一桩生意来了，请查看！");
        }else if(type==2){
            message.setContent("您有一条新消息，请查看！");
        }else if(type==3){
            message.setContent("您提交的方案被采纳了，请查看！");
        }else if(type==4){
            message.setContent("您提交的方案被拒绝了，请查看！");
        }
        message.setStyle(style);
        message.setAction(action);
        message.setCustom(custom);
        TimeInterval acceptTime1 = new TimeInterval(0, 0, 23, 59);
        message.addAcceptTime(acceptTime1);
        return message;
    }

    // 设置message公共参数
    public static MessageIOS buildMsgIOS(Integer type,Map<String, Object> custom) {
        MessageIOS message = new MessageIOS();
        message.setExpireTime(259200);// 消息离线存储多久，单位为秒，最长存储时间3天。选填，默认为0，即不存储
        if(type==1){
            message.setAlert("您有一桩生意来了，请查看！");
        }else if(type==2){
            message.setAlert("您有一条新消息，请查看！");
        }else if(type==3){
            message.setAlert("您提交的方案被采纳了，请查看！");
        }else if(type==4){
            message.setAlert("您提交的方案被拒绝了，请查看！");
        }
        message.setBadge(1);
        message.setSound("blow.aiff");
        TimeInterval acceptTime1 = new TimeInterval(0, 0, 23, 59);
        message.addAcceptTime(acceptTime1);
        message.setCustom(custom);
        return message;
    }
}
