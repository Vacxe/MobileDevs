package com.example.myapp.lesson1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.myapp.R;

/**
 * Created by konstantinaksenov on 13.09.14.
 */
public class ButtonActions extends Activity implements View.OnClickListener {
    private final static int SEL_LABEL_CODE = 1;

    //Button Listeners metods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_activity);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(1);
            }
        });

        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);

        findViewById(R.id.get_name_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                showToast(2);
                break;
            case R.id.button3:
                showToast(3);
                break;

            case R.id.get_name_button:
                startActivityForResult(new Intent(this, SetLabelActivity.class), SEL_LABEL_CODE);
                break;
        }

    }

    public void onButtonClicked(View v) {
        showToast(4);
    }

    private void showToast(int buttonId) {
        Toast.makeText(this, String.format("Button %d clicked", buttonId), Toast.LENGTH_SHORT).show();
    }

    //On Result


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SEL_LABEL_CODE) {
                String name = data.getExtras().getString("name");
                Button button = (Button) findViewById(R.id.get_name_button);
                button.setText(name);
                String button1Name = getString(R.string.button_1);
            }
        } else {

        }
    }
}
