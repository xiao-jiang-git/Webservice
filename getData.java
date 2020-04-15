package wsdl;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import grabData.DataOnline;
import hibernatePOJO.PowerxbMonitor;



public class getData extends ActionSupport {
    private static final long serialVersionUID = 13L;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    /* 根据检测点实时监测点谐波数据
     */
    public String execute(String did) throws Exception {
        try { //获取数据

            if (did != "") {
                PowerxbMonitor pp = DataOnline.getXbMap().get(did);

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("nowpowerxb", pp);
                result = JSON.toJSONString(jsonObject); // List转json
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }


}
