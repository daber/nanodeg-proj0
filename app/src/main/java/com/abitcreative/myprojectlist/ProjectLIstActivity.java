package com.abitcreative.myprojectlist;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ProjectLIstActivity extends AppCompatActivity {

    private ButtonCLickListener buttonListener = new ButtonCLickListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);
        ViewGroup list_root = (ViewGroup) findViewById(R.id.activity_project_list);

        for(int i = 0; i < list_root.getChildCount();i++){
            View v = list_root.getChildAt(i);
            if( v instanceof Button){
                Button button = (Button) v;
                button.setOnClickListener(buttonListener);
            }
        }
    }
}

class ButtonCLickListener implements View.OnClickListener{

    @Override
    public void onClick(View view) {
        AppCompatButton button = (AppCompatButton) view;
        CharSequence buttonText = button.getText();
        Resources res =view.getResources();
        String toastText= res.getString(R.string.launch_info,buttonText);
        Toast.makeText(view.getContext(),toastText,Toast.LENGTH_SHORT).show();
    }
}
