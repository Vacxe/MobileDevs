package com.example.myapp.lesson1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.myapp.R;

/**
 * Created by konstantinaksenov on 13.09.14.
 */
public class SetLabelActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_label_activity);
        findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText) findViewById(R.id.name_editText)).getText().toString();
                Intent resultIntent = new Intent();
                if (name.isEmpty()) {
                    setResult(Activity.RESULT_CANCELED);
                } else {
                    resultIntent.putExtra("name", name);
                    setResult(RESULT_OK, resultIntent);
                }
                finish();
            }
        });
    }
}
