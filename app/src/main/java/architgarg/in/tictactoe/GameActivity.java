package architgarg.in.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

      public static String EXTRA_PLAYER_1 = "hello";
      public static String EXTRA_PLAYER_2 = "hi";
      TextView text1;
      TextView text2;
      TextView resultTextView;


      private ImageView view1;
      private ImageView view2;
      private ImageView view3;
      private ImageView view4;
      private ImageView view5;
      private ImageView view6;
      private ImageView view7;
      private ImageView view8;
      private ImageView view9;
      private Button resetButton;

      private int score1 = 0;
      private int score2 = 0;
      private int flag = 0;

      int crossResource = R.drawable.cross2;
      int zeroResource = R.drawable.zero1;
      int x;

      String tag;
      String a;
      String b;


      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_game);

            Intent intent = this.getIntent();
            a = intent.getStringExtra(EXTRA_PLAYER_1);
            b = intent.getStringExtra(EXTRA_PLAYER_2);

            text1 = (TextView) findViewById(R.id.text1_id);
            text2 = (TextView) findViewById(R.id.text2_id);

            if (a.equals("") && b.equals("")) {
                  a = "Player 1";
                  b = "Player 2";
            } else if (b.equals("")) {
                  b = "Player 2";
            } else if (a.equals("")) {
                  a = "Player 1";
            }

            displayScores();

//        <<<<<<<< Playing with views >>>>>>
            view1 = (ImageView) findViewById(R.id.img1);
            view2 = (ImageView) findViewById(R.id.img2);
            view3 = (ImageView) findViewById(R.id.img3);
            view4 = (ImageView) findViewById(R.id.img4);
            view5 = (ImageView) findViewById(R.id.img5);
            view6 = (ImageView) findViewById(R.id.img6);
            view7 = (ImageView) findViewById(R.id.img7);
            view8 = (ImageView) findViewById(R.id.img8);
            view9 = (ImageView) findViewById(R.id.img9);
            resetButton = (Button) findViewById(R.id.reset_button);
            resultTextView = (TextView) findViewById(R.id.result_text_view);
            resetButton.setVisibility(View.INVISIBLE);
      }

      public static Intent getNewIntent(Context context, String player1, String player2) {
            Intent intent = new Intent(context, GameActivity.class);

            intent.putExtra(EXTRA_PLAYER_1, player1);
            intent.putExtra(EXTRA_PLAYER_2, player2);

            return intent;
      }

      public void crossClicked(View view) {

            if (flag % 2 == 0) {
                  x = crossResource;
                  tag = "abc";

            } else {
                  x = zeroResource;
                  tag = "xyz";
            }

            ((ImageView) view).setImageResource(x);
            view.setTag(tag);
            flag++;
            view.setEnabled(false);
            calculate();
      }

      public void calculate() {


            if (view1.getTag() == view2.getTag() && view2.getTag() == view3.getTag() && view1.getTag() != null) {
                  setResultText(view1);
                  resetButton.setVisibility(View.VISIBLE);
                  disableAllViews();
            } else if (view4.getTag() == view5.getTag() && view5.getTag() == view6.getTag() && view4.getTag() != null) {
                  setResultText(view4);
                  resetButton.setVisibility(View.VISIBLE);
                  disableAllViews();
            } else if (view7.getTag() == view8.getTag() && view8.getTag() == view9.getTag() && view9.getTag() != null) {
                  setResultText(view7);
                  resetButton.setVisibility(View.VISIBLE);
                  disableAllViews();
            } else if (view1.getTag() == view4.getTag() && view4.getTag() == view7.getTag() && view7.getTag() != null) {
                  setResultText(view1);
                  resetButton.setVisibility(View.VISIBLE);
                  disableAllViews();
            } else if (view2.getTag() == view5.getTag() && view5.getTag() == view8.getTag() && view8.getTag() != null) {
                  setResultText(view2);
                  resetButton.setVisibility(View.VISIBLE);
                  disableAllViews();
            } else if (view3.getTag() == view6.getTag() && view6.getTag() == view9.getTag() && view9.getTag() != null) {
                  setResultText(view3);
                  resetButton.setVisibility(View.VISIBLE);
                  disableAllViews();
            } else if (view1.getTag() == view5.getTag() && view5.getTag() == view9.getTag() && view9.getTag() != null) {
                  setResultText(view1);
                  resetButton.setVisibility(View.VISIBLE);
                  disableAllViews();
            } else if (view3.getTag() == view5.getTag() && view5.getTag() == view7.getTag() && view7.getTag() != null) {
                  setResultText(view3);
                  resetButton.setVisibility(View.VISIBLE);
                  disableAllViews();
            } else if (view1.getTag() != null && view2.getTag() != null && view3.getTag() != null && view4.getTag() != null &&
                    view5.getTag() != null && view6.getTag() != null && view7.getTag() != null && view8.getTag() != null && view9.getTag() != null) {
                  resultTextView.setText("Tie!! Better Luck Next Time!");
                  disableAllViews();
                  resetButton.setVisibility(View.VISIBLE);
            } else {
                  Log.d("Archit", "else case running again and againnnnnnnnnnnnnnnnnnnnnnnn");
            }
      }

      public void resetClicked(View view) {
            flag = 0;
            view1.setImageResource(0);
            view2.setImageResource(0);
            view3.setImageResource(0);
            view4.setImageResource(0);
            view5.setImageResource(0);
            view6.setImageResource(0);
            view7.setImageResource(0);
            view8.setImageResource(0);
            view9.setImageResource(0);
            resetButton.setVisibility(View.INVISIBLE);
            resultTextView.setText("");
            displayScores();
            enableAllViews();

            view1.setTag(null);
            view2.setTag(null);
            view3.setTag(null);
            view4.setTag(null);
            view5.setTag(null);
            view6.setTag(null);
            view7.setTag(null);
            view8.setTag(null);
            view9.setTag(null);
            return;
      }

      public void displayScores() {
            text1.setText(a + " : " + score1);
            text2.setText(b + " : " + score2);
            return;
      }

      public void disableAllViews() {
            view1.setEnabled(false);
            view2.setEnabled(false);
            view3.setEnabled(false);
            view4.setEnabled(false);
            view5.setEnabled(false);
            view6.setEnabled(false);
            view7.setEnabled(false);
            view8.setEnabled(false);
            view9.setEnabled(false);
      }

      public void enableAllViews() {
            view1.setEnabled(true);
            view2.setEnabled(true);
            view3.setEnabled(true);
            view4.setEnabled(true);
            view5.setEnabled(true);
            view6.setEnabled(true);
            view7.setEnabled(true);
            view8.setEnabled(true);
            view9.setEnabled(true);
            return;
      }

      public void setResultText(View view) {
            if (view.getTag() == "abc") {
                  resultTextView.setText(a + " Won!!");
                  score1++;
            } else if (view.getTag() == "xyz") {
                  resultTextView.setText(b + " Won!!");
                  score2++;
            }
            return;
      }
}
