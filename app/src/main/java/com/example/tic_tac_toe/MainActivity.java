package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    boolean ganeActive = true;

//    user
//    0 --  o
//    1 --  x

    int activeUser = 1;

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

//    stateMean
//    0 --  o
//    1 --  x
//    2 --  null

    int[][] winingPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};


    public void tapp(View view) {
        ImageView img = (ImageView) view;
        int tabedImage = Integer.parseInt(img.getTag().toString());

        if (!ganeActive){
            gameReset(view);
        }

        if (gameState[tabedImage] == 2 ) {
            gameState[tabedImage] = activeUser;

            img.setTranslationY(1000f);
            if (activeUser == 0) {
                img.setImageResource(R.drawable.o);
                activeUser = 1;
                TextView status= findViewById(R.id.status);
                status.setText("x's turn");
            } else {
                img.setImageResource(R.drawable.x);
                activeUser = 0;
                TextView status= findViewById(R.id.status);
                status.setText("o's turn");
            }
            img.animate().translationYBy(-1000f).setDuration(300);
        }

        for(int[] winposition : winingPositions)
        {
            if(gameState[winposition[0]] == gameState[winposition[1]] &&
                    gameState[winposition[1]] == gameState[winposition[2]] &&
            gameState[winposition[0]]!=2){
                //somebody win and find out who!

                String winnerStr;
                if(gameState[winposition[0]]== 0){

                    TextView status= findViewById(R.id.status);
                    winnerStr ="o won";
                    ganeActive=false;
//                    status.setText("o wins");
                }

                else{
                    TextView status= findViewById(R.id.status);
//                    status.setText("x wins");
                    winnerStr ="x won";
                    ganeActive=false;
                }


//                Update the status bar for Winner annousment
                TextView status= findViewById(R.id.status);
                status.setText(winnerStr);



            }

        }

    }

    public void gameReset(View view){
        ganeActive = true;
        activeUser= 0;
        for (int i=0; i<gameState.length; i++){
            gameState[i]=2;

        }

        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);


        TextView status= findViewById(R.id.status);
        status.setText("x's turn: Tap to play");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }
}