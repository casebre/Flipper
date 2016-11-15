package ca.casebre.flipper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by rafael on 09/05/16.
 */
public class MultiStepFragmentPageAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 20;

    public MultiStepFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return MultiStepFragmentPage.newInstance(position);
    }

}