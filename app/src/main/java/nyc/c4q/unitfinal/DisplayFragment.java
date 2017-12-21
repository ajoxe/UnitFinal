package nyc.c4q.unitfinal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {
    View rootView;
    TopFragment topFragment;
    BottomFragment bottomFragment;


    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_display, container, false);
        topFragment = new TopFragment();
        bottomFragment = new BottomFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.top_fragment_container_framelayout, topFragment);
        fragmentTransaction.replace(R.id.bottom_fragment_container_framelayout, bottomFragment);
        fragmentTransaction.commit();

        return rootView;
    }

}
