package kr.hs.dimigo.meal.oldversion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.hs.dimigo.meal.R;
import kr.hs.dimigo.meal.data.DateCalculator;

public class YesterdayMealViewFragment extends Fragment{

    private static YesterdayMealViewFragment yesterdayMealViewFragment;

    public static YesterdayMealViewFragment getInstance() {
        if(yesterdayMealViewFragment == null) {
            yesterdayMealViewFragment = new YesterdayMealViewFragment();
            return yesterdayMealViewFragment;
        } else {
            return yesterdayMealViewFragment;
        }
    }

    TextView yesterdayDateTitle;

    TextView yesterdayBreakfastMenuContent, yesterdayLunchMenuContent, yesterdayDinnerMenuContent, yesterdaySnackMenuContent;

    DateCalculator dateCalculator = new DateCalculator();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.yesterday_meal_view_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        yesterdayDateTitle = getActivity().findViewById(R.id.yesterdayDateTitle);
//        yesterdayDateTitle.setText(dateCalculator.dateTitleProvider(dateCalculator.getYesterday()));

        yesterdayBreakfastMenuContent = getActivity().findViewById(R.id.yesterdayBreakfastMenuContent);
        yesterdayLunchMenuContent = getActivity().findViewById(R.id.yesterdayLunchMenuContent);
        yesterdayDinnerMenuContent = getActivity().findViewById(R.id.yesterdayDinnerMenuContent);
        yesterdaySnackMenuContent = getActivity().findViewById(R.id.yesterdaySnackMenuContent);

        ApiCommunicator apiCommunicator = new ApiCommunicator(0, yesterdayBreakfastMenuContent, yesterdayLunchMenuContent, yesterdayDinnerMenuContent, yesterdaySnackMenuContent, getView(), getContext());
        apiCommunicator.initCommunicate();

    }
}