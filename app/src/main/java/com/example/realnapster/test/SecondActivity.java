package com.example.realnapster.test;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {


    @BindView(R.id.iconImageView)
    ImageView iconImageView;
    @BindView(R.id.rowTitleTextView)
    TextView rowTitleTextView;
    @BindView(R.id.rowSubTitleTextView)
    TextView rowSubTitleTextView;
    @BindView(R.id.inputEditText)
    EditText inputEditText;

    private ListItem listItem;
    public static final String LIST_ITEM_INTENT = "list_item_intent";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        listItem = getIntent().getParcelableExtra(LIST_ITEM_INTENT);
        populateView();
    }

    private void populateView() {
        rowTitleTextView.setText("Row Title " + listItem.getTitle());
        rowSubTitleTextView.setText("Row Sub Title " + listItem.getSubtitle());
        iconImageView.setImageResource(listItem.getImageRes());
    }

    @OnClick(R.id.goBackButton)
    public void onViewClicked() {
        Intent intent = new Intent();
        intent.putExtra(TabOne.DATA_STRING_EXTRA, inputEditText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

}
