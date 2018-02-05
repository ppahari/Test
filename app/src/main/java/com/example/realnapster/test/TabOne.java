package com.example.realnapster.test;

        import android.animation.Animator;
        import android.app.Activity;
        import android.app.Fragment;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;

        import butterknife.BindView;
        import butterknife.ButterKnife;
        import butterknife.Unbinder;

/**
 * Created by Realnapster on 2/5/2018.
 */

public class TabOne extends Fragment implements ItemClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private Unbinder unbinder;
    LinearLayoutManager layoutManager;
    Context mContext;
    DividerDecoration dividerDecoration;

    public static final int REQUEST_CODE = 100;
    public static final String DATA_STRING_EXTRA = "data_string_extra";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_one, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dividerDecoration = new DividerDecoration(mContext);
        layoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(dividerDecoration);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        MyAdapter adapter = new MyAdapter(getListItems());
        adapter.itemClickListener = this;
        mRecyclerView.setAdapter(adapter);

    }

    private List<ListItem> getListItems() {
        List<ListItem> listItems = new ArrayList<>();
        listItems.add(new ListItem(1, 1, R.mipmap.ic_launcher));
        listItems.add(new ListItem(2, 2, R.mipmap.ic_launcher));
        listItems.add(new ListItem(3, 3, R.mipmap.ic_launcher));
        listItems.add(new ListItem(4, 4, R.mipmap.ic_launcher));
        listItems.add(new ListItem(5, 5, R.mipmap.ic_launcher));

        return listItems;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setItemClickListener(ListItem item) {
        Intent intent = new Intent(mContext, SecondActivity.class);
        intent.putExtra(SecondActivity.LIST_ITEM_INTENT, item);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                String message = data.getStringExtra(DATA_STRING_EXTRA);
                Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
            }
        }
    }
}





