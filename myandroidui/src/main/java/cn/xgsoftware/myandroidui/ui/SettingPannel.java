package cn.xgsoftware.myandroidui.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.xgsoftware.myandroidui.R;

public class SettingPannel extends LinearLayout {
    private int dividerColor;
    private Context ctx;
    private OnClickSettingPannelItem onClickListener;

    public SettingPannel(Context context) {
        super(context);
        ctx = context;
    }

    public SettingPannel(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
        LayoutInflater.from(context).inflate(R.layout.layout_settingpannel, this, true);
        init();
        TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.SettingPannel);
        if(values != null) {
            context.getResources().getColor(R.color.divider);
            dividerColor = values.getColor(R.styleable.SettingPannel_dividerColor,
                    context.getResources().getColor(R.color.divider));
        }
    }

    public SettingPannel(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnClickSettingPannelItemListener(OnClickSettingPannelItem listener) {
        onClickListener = listener;
    }

    public void addItem(Integer leftIcon, String text, String hint) {
        int cc = this.getChildCount();
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_settingpannel, null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);

        if(leftIcon != null) {
            ImageView iv = view.findViewById(R.id.iv_left);
            iv.setImageResource(leftIcon);
        }

        if(text != null) {
            TextView tv = view.findViewById(R.id.tv_title);
            tv.setText(text);
        }

        if(hint != null) {
            TextView tv = view.findViewById(R.id.tv_hint);
            tv.setText(hint);
        }
        view.setTag(cc);

        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int cc = (int) v.getTag();
                if(onClickListener != null) {
                    onClickListener.onClickItem(cc);
                }
            }
        });

        this.addView(view);
    }

//    设置右边图标
    public void setRightIcon(int res) {

    }

    private void init() {
        this.setOrientation(VERTICAL);
    }
}
