package com.moana.roadpro_manage.dummy;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class Dummy {
    public static ArrayList<Entry> getDummyData(int count, int range) {
        ArrayList<Entry> values = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {
            int val = (int) (Math.random() * range);
            values.add(new Entry(i, val));
        }
        return values;
    }

    public static int getRandomInt(int start, int range) {
        return  (int) (Math.random() * range) + start;
    }
}
