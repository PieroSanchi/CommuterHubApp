package com.example.commuterhub;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

//CLASSE CHE SERVE PER GESTIRE LE TAB ED IL TABLAYOUT (TIME/PLACE)
public class FragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public FragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TimeTab();
        } else {
            return new PlaceTab();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 2;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.time);
            case 1:
                return mContext.getString(R.string.place);
            default:
                return null;
        }
    }
}