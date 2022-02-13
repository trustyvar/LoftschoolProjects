package com.trustyvar.loftmoney;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trustyvar.loftmoney.items.Item;
import com.trustyvar.loftmoney.items.ItemsAdapter;

import java.util.ArrayList;

public class BudgetFragment extends Fragment {

    private static final String ARG_CURRENT_POSITION = "current_position";

    private RecyclerView itemsView;
    private int currentPosition;
    private ItemsAdapter itemsAdapter = new ItemsAdapter();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        configureRecyclerView();
    }

    private void configureRecyclerView() {
        itemsView = getView().findViewById(R.id.rv_items);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        itemsView.setLayoutManager(layoutManager);
        itemsView.setAdapter(itemsAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        itemsView.addItemDecoration(dividerItemDecoration);

    }

    private void generateData(){
        ArrayList<Item>list = new ArrayList();
        list.add(new Item("банан",100));
        list.add(new Item("яблоко",5000));
        itemsAdapter.setData(list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_budget, container, false);
    }

    public static BudgetFragment newInstance(int position) {
        BudgetFragment budgetFragment = new BudgetFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_CURRENT_POSITION, position);
        budgetFragment.setArguments(args);
        return budgetFragment;
    }
}