package com.example.commuterhub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment implements CardAdapter.OnItemListener {

    private static final String LOG = "Home-Fragment_LAB";
    private CardAdapter adapter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final Activity activity = getActivity();
        if (activity != null) {
            //setup the toolbar
            Utilities.setUpToolBar((AppCompatActivity) getActivity(), "CommuterHub");
            setRecyclerView(activity);

          /*  ListItemViewModel model = new ViewModelProvider(activity).get(ListItemViewModel.class);
            //when the list of the items changed, the adapter gets the new list.
            model.getItems().observe(activity, new Observer<List<CardItem>>() {
                @Override
                public void onChanged(List<CardItem> cardItems) {
                    adapter.setData(cardItems);
                }
            });*/

            //add fab icon
            FloatingActionButton floatingActionButton = activity.findViewById(R.id.fab_add);
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.startActivityForResult(new Intent(activity, AddClockActivity.class), Utilities.ACTIVITY_ADD_CLOCK);
                }
            });
        } else {
            Log.e(LOG, "Activity is null");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setRecyclerView(Activity activity) {
        recyclerView = activity.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        adapter = new CardAdapter(CardSingleton.getInstance().getCardItemList(), this);
        recyclerView.setAdapter(adapter);
    }

    void updateList() {
        Log.d(LOG, "updateList()");
        adapter.updateList();
    }

    @Override
    public void onItemClick(int position) {
        final View view = Objects.requireNonNull(recyclerView.findViewHolderForAdapterPosition(position)).itemView;
        final CardView cardView = view.findViewById(R.id.single_card);
        final View expandableView = cardView.findViewById(R.id.expandableView);

        TransitionManager.beginDelayedTransition(cardView, new Slide());
        expandableView.setVisibility(expandableView.getVisibility() == android.view.View.GONE ?
                android.view.View.VISIBLE : android.view.View.GONE);

        //gestire qui il comportamento degli switch
        //e dei bottoni EDIT e DELETE

      /*  view.findViewById(R.id.shareIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Log.d("LAB", "click");
                CardItem item = CardSingleton.getInstance().getCardItem(position);

                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.putExtra(android.content.Intent.EXTRA_TEXT, getString(R.string.place) +
                        item.getPlace() + "\n" + getString(R.string.description) +
                        item.getDescription() + "\n" + getString(R.string.date) + item.getDate());

                sendIntent.setType("text/plain");
                if (getActivity() != null && sendIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(Intent.createChooser(sendIntent, null));
                }
            }
        });  */
    }
}
