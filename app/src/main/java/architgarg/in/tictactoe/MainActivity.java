package architgarg.in.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText player1Name;
    EditText player2Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1Name = (EditText) findViewById(R.id.player_one_name);
        player2Name = (EditText) findViewById(R.id.payer_two_name);

    }

//    public void onSaveInstanceState(Bundle outState){
//        super.onSaveInstanceState(outState);
//
//        outState.putString("play1",player1Name.getText().toString());
//        outState.putString("play2",player2Name.getText().toString());
//    }

    public void showGameActivity(View view){
        Intent intent = GameActivity.getNewIntent(this, player1Name.getText().toString(), player2Name.getText().toString());

        startActivity(intent);
    }
}
