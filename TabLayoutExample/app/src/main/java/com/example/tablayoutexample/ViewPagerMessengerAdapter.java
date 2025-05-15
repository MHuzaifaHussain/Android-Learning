package com.example.tablayoutexample;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerTitleStrip;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerMessengerAdapter extends FragmentStateAdapter {


    public ViewPagerMessengerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new chatFragment();
        } else if (position == 1) {
            return new StatusFragment();
        } else {
            return new CallsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return  3;
    }

}