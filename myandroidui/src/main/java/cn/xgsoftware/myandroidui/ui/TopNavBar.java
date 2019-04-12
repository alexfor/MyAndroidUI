package cn.xgsoftware.myandroidui.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import cn.xgsoftware.myandroidui.R;

public class TopNavBar extends RelativeLayout {
    public TopNavBar(Context context) {
        super(context);
    }

    public TopNavBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_topnavbar, this, true);
    }

    public TopNavBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
