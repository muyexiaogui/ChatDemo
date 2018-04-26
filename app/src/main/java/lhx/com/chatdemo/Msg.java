package lhx.com.chatdemo;

/**
 * Created by lhx
 * date:on 2018/4/27 0027.
 * TODO :消息类
 */

public class Msg {

    public static final int TYPE_RECEIVED = 0;  //接受消息类型
    public static final int TYPE_SENT = 1;  // 发送消息类型

    private String content;
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
