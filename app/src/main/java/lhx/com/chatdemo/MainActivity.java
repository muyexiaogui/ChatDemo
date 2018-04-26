package lhx.com.chatdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();
    private EditText inputEd;
    private Button sendBtn;
    private RecyclerView mRecyclerView;
    private MsgAdaapter mAdaapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inirMsg();
        inputEd = (EditText)findViewById(R.id.input_text);
        sendBtn = (Button)findViewById(R.id.send_btn);
        mRecyclerView = (RecyclerView)findViewById(R.id.msg_recycler_view);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(manager);

        mAdaapter = new MsgAdaapter(MainActivity.this,msgList);
        mRecyclerView.setAdapter(mAdaapter);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputEd.getText().toString().trim();
                if(!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    mAdaapter.notifyItemInserted(msgList.size() - 1); //当有新消息的时候，刷新recyclerview中的显示
                    mRecyclerView.scrollToPosition(msgList.size() - 1);
                    inputEd.setText("");
                }
            }
        });
    }

    private void inirMsg() {
        Msg msg1 = new Msg("Hello World",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("你好，收到",Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("收到就好",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}
