package ca.casebre.flipper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by rafael on 09/05/16.
 */

public class MultiStepFragmentPage extends Fragment {

    public static final String ARG_STEP = "ARG_STEP";
    private int stepNumber;

    public int getStepNumber() { return stepNumber; }


    public static MultiStepFragmentPage newInstance(int step) {
        Bundle args = new Bundle();
        args.putInt(ARG_STEP, step);
        MultiStepFragmentPage fragment = new MultiStepFragmentPage();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stepNumber = getArguments().getInt(ARG_STEP);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.first, container, false);
        TextView txtContent = (TextView) view.findViewById(R.id.fullscreen_content);
        TextView txtCounter = (TextView) view.findViewById(R.id.fullscreen_counter);
        txtCounter.setText(String.valueOf(stepNumber+1));

        switch (stepNumber) {
            case 0:
                txtContent.setText("Unsucessful business");
                break;
            case 1:
                txtContent.setText("Working hard");
                break;
            default:
                view = inflater.inflate(R.layout.first, container, false);
                break;

        }
        return view;
    }

}