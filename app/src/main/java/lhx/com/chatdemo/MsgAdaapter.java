package lhx.com.chatdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lhx
 * date:on 2018/4/27 0027.
 * TODO : 消息列表适配器
 */

public class MsgAdaapter extends RecyclerView.Adapter<MsgAdaapter.ViewHolder>{

    private Context context;
    private List<Msg> mListDate;

    public MsgAdaapter(Context context, List<Msg> mListDate) {
        this.context = context;
        this.mListDate = mListDate;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.msg_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    Msg msg = mListDate.get(position);
    if(msg.getType() == Msg.TYPE_RECEIVED){
        //为收到消息的列表布局
        holder.leftLayout.setVisibility(View.VISIBLE);
        holder.rightLayout.setVisibility(View.GONE);
        holder.leftMsgTv.setText(msg.getContent());
    }else if(msg.getType() == Msg.TYPE_SENT){
        //为发送消息的列表布局
        holder.rightLayout.setVisibility(View.VISIBLE);
        holder.leftLayout.setVisibility(View.GONE);
        holder.rightMsgTv.setText(msg.getContent());
    }
    }

    @Override
    public int getItemCount() {
        return mListDate.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout leftLayout,rightLayout;
        TextView leftMsgTv,rightMsgTv;
        public ViewHolder(View itemView) {
            super(itemView);
            leftLayout = (LinearLayout)itemView.findViewById(R.id.left_layout);
            rightLayout = (LinearLayout)itemView.findViewById(R.id.right_layout);
            leftMsgTv = (TextView)itemView.findViewById(R.id.left_msg_text);
            rightMsgTv = (TextView)itemView.findViewById(R.id.right_msg_text);
        }
    }
}
