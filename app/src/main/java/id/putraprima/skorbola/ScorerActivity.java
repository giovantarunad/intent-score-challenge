package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ScorerActivity extends AppCompatActivity {

    EditText playerName;
    int key;
    int scoreHome;
    int scoreAway;
    String nameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorer);
        playerName = findViewById(R.id.editText);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            key = extras.getInt("key");
            scoreHome = extras.getInt("dataHome");
            scoreAway = extras.getInt("dataAway");
        }
    }

    public void hanldeOke(View view) {
        nameField = playerName.getText().toString();
        if (nameField.equals("")) {
            Toast.makeText(this, "Masukkan nama pemain!!", Toast.LENGTH_SHORT).show();
        }
        else{
            if (key == 1) {
                scoreHome += 1;
                nameField = playerName.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("homeGoalers", nameField);
                intent.putExtra("scoreHome", scoreHome);
                System.out.println(nameField);
                setResult(1, intent);
                finish();
            } else if (key == 2) {
                scoreAway += 1;
                nameField = playerName.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("awayGoalers", nameField);
                intent.putExtra("scoreAway", scoreAway);
                setResult(2, intent);
                finish();
            }
        }
    }
}
