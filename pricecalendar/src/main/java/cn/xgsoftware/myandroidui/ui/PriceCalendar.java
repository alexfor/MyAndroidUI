package cn.xgsoftware.myandroidui.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;

import cn.xgsoftware.myandroidui.pricecalendar.R;

public class PriceCalendar extends RelativeLayout {
    private LinearLayout llDays;
    private int weekCount = 4;

    public PriceCalendar(Context context) {
        super(context);
    }

    public PriceCalendar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_pricecalendar, this, true);

        TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.PriceCalendar);
        if(values != null) {
            boolean showWeek = values.getBoolean(R.styleable.PriceCalendar_showWeek, true);
            weekCount = values.getInteger(R.styleable.PriceCalendar_weekCount, 4);
            LinearLayout llWeek = findViewById(R.id.ll_week);
            llWeek.setVisibility(showWeek?VISIBLE:GONE);
        }

        init(context);
    }

    public PriceCalendar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context) {
        llDays = findViewById(R.id.ll_days);

        Calendar calendar = Calendar.getInstance();

        LinearLayout l1 = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        l1.setLayoutParams(params);
        l1.setOrientation(LinearLayout.HORIZONTAL);
        int c = this.getResources().getColor(android.R.color.transparent);
        int w = calendar.get(Calendar.DAY_OF_WEEK)-1;

        for(int i = 0; i < 7; i++) {
            View v = View.inflate(context, R.layout.item_daily_price, null);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
            p.weight = 1;
            v.setLayoutParams(p);
            v.setBackgroundColor(c);

            TextView tv1 = v.findViewById(R.id.tv_price);
            TextView tv2 = v.findViewById(R.id.tv_day);

            if(i >= w) {
                int d = calendar.get(Calendar.DAY_OF_MONTH);
                tv2.setText(d + "");
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
            else {
                tv2.setVisibility(INVISIBLE);
            }

            tv1.setBackgroundColor(c);
            tv2.setBackgroundColor(c);

            l1.addView(v);
        }

        LinearLayout l2 = new LinearLayout(context);
        l2.setLayoutParams(params);
        l2.setOrientation(LinearLayout.HORIZONTAL);
        for(int i = 0; i < 7; i++) {
            View v = View.inflate(context, R.layout.item_daily_price, null);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
            p.weight = 1;
            v.setLayoutParams(p);
            v.setBackgroundColor(c);

            TextView tv1 = v.findViewById(R.id.tv_price);
            TextView tv2 = v.findViewById(R.id.tv_day);

            tv1.setBackgroundColor(c);
            tv2.setBackgroundColor(c);

            int d = calendar.get(Calendar.DAY_OF_MONTH);
            tv2.setText(d+"");
            calendar.add(Calendar.DAY_OF_MONTH, 1);

            l2.addView(v);
        }

        LinearLayout l3 = new LinearLayout(context);
        l3.setLayoutParams(params);
        l3.setOrientation(LinearLayout.HORIZONTAL);
        for(int i = 0; i < 7; i++) {
            View v = View.inflate(context, R.layout.item_daily_price, null);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
            p.weight = 1;
            v.setLayoutParams(p);
            v.setBackgroundColor(c);

            TextView tv1 = v.findViewById(R.id.tv_price);
            TextView tv2 = v.findViewById(R.id.tv_day);

            tv1.setBackgroundColor(c);
            tv2.setBackgroundColor(c);

            int d = calendar.get(Calendar.DAY_OF_MONTH);
            tv2.setText(d+"");
            calendar.add(Calendar.DAY_OF_MONTH, 1);

            l3.addView(v);
        }

        llDays.addView(l1);
        llDays.addView(l2);
        llDays.addView(l3);

    }
}
