package com.example.tictactoe;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	private int turn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        turn = 1; 
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void resetGame(View v) {
    	this.recreate();
    }
    
    public void onButtonClick(View v) {
    	switch(v.getId()) {
    	case R.id.button1:
    		processClick(R.id.button1);
    		break;
    	case R.id.button2:
    		processClick(R.id.button2);
    		break;
    	case R.id.button3:
    		processClick(R.id.button3); 
    		break;
    	case R.id.button4:
    		processClick(R.id.button4);
    		break;
    	case R.id.button5:
    		processClick(R.id.button5); 
    		break;
    	case R.id.button6:
    		processClick(R.id.button6);
    		break;
    	case R.id.button7:
    		processClick(R.id.button7);
    		break;
    	case R.id.button8:
    		processClick(R.id.button8); 
    		break;
    	case R.id.button9:
    		processClick(R.id.button9);
    		break;
    	default:
    		throw new RuntimeException("Unknown button id");
    		
    	}
    }
    
    private void processClick(int id) {
    	Button b = (Button) findViewById(id);
    	TextView info = (TextView) findViewById(R.id.info);
    	
    	if(!b.getText().equals(""))
    		return;
    	
    	if(turn % 2 == 1) {
    		//Player 1's Turn (X)
    		b.setText("X");
    		info.setText("Player 2's Turn");
    	} else {
    		// Player 2's Turn (O)
    		b.setText("O");
    		info.setText("Player 1's Turn");
    	}
    	
    	if(checkForWinner()) {
    		if(turn % 2 == 1) {
        		info.setText("Player 1 wins!!!");
        	} else {
        		info.setText("Player 2 wins!!!");
        	}
    	} else {
    		turn++;
    		
    		if(turn > 9) {
    			info.setText("It's a tie!!!");
    		}
    	}
    }
    
    private boolean checkForWinner() {
    	Button b1 = (Button) findViewById(R.id.button1);
    	Button b2 = (Button) findViewById(R.id.button2);
    	Button b3 = (Button) findViewById(R.id.button3);
    	Button b4 = (Button) findViewById(R.id.button4);
    	Button b5 = (Button) findViewById(R.id.button5);
    	Button b6 = (Button) findViewById(R.id.button6);
    	Button b7 = (Button) findViewById(R.id.button7);
    	Button b8 = (Button) findViewById(R.id.button8);
    	Button b9 = (Button) findViewById(R.id.button9);
    	
    	if(b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText()) && !b1.getText().equals("")) return true;
    	if(b4.getText().equals(b5.getText()) && b5.getText().equals(b6.getText()) && !b4.getText().equals("")) return true;
    	if(b7.getText().equals(b8.getText()) && b8.getText().equals(b9.getText()) && !b7.getText().equals("")) return true;
    	if(b1.getText().equals(b4.getText()) && b4.getText().equals(b7.getText()) && !b7.getText().equals("")) return true;
    	if(b2.getText().equals(b5.getText()) && b5.getText().equals(b8.getText()) && !b8.getText().equals("")) return true;
    	if(b3.getText().equals(b6.getText()) && b6.getText().equals(b9.getText()) && !b9.getText().equals("")) return true;
    	if(b1.getText().equals(b5.getText()) && b5.getText().equals(b9.getText()) && !b5.getText().equals("")) return true;
    	if(b7.getText().equals(b5.getText()) && b5.getText().equals(b3.getText()) && !b7.getText().equals("")) return true;
    	
    	return false;
    }
}
