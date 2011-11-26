package com.twinslin.pnum;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.LinearLayout;
import com.google.ads.*;
import com.twinslin.pnum.R;

import android.view.Window;

public class PhoneNumGBActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_LEFT_ICON);//?¨æ?é¡Œæ?é¡¯ç¤º?–æ?(icon)step 1
        setContentView(R.layout.main);
        getWindow().setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,R.drawable.icon);//?¨æ?é¡Œæ?é¡¯ç¤º?–æ?(icon)step 2
        
        // Create the adView
        LinearLayout layout =(LinearLayout)findViewById(R.id.AdLayout);
        AdView adView =new AdView(this, AdSize.BANNER, "a14ec6018893474");
        layout.addView(adView);
        adView.loadAd(new AdRequest());
        
        findviews();
        setListensers();
    }
    
    private Button button_calc;
    private EditText field_num;
    private TextView view_result;
    private TextView view_suggest;
 
    private void findviews(){
    	button_calc = (Button) findViewById(R.id.submit);
    	field_num = (EditText) findViewById(R.id.pnumber);
    	view_result = (TextView) findViewById(R.id.result);
    	view_suggest = (TextView) findViewById(R.id.suggest);
    	    	
    }
    private void openOptionsDialog(){
    	new AlertDialog.Builder(PhoneNumGBActivity.this)
    	.setTitle(R.string.error_title)
    	.setMessage(R.string.error_msg)
    	.setPositiveButton(R.string.ok_label,
		new DialogInterface.OnClickListener(){
    	  public void onClick(
			  DialogInterface dialoginterface, int i){
    		  field_num.setText("");	
    	  }
    	})
       	.show();		
     }
    
    private void openMenuDialog(){
    	new AlertDialog.Builder(PhoneNumGBActivity.this)
    	.setTitle(R.string.about_title)
    	.setMessage(R.string.about_msg)
    	.setPositiveButton(R.string.ok_label,
		new DialogInterface.OnClickListener(){
    	  public void onClick(
			  DialogInterface dialoginterface, int i){
       	   }
    	})
    	.setNegativeButton(R.string.home_label,
    	  new DialogInterface.OnClickListener(){
    		  public void onClick(
    			DialogInterface dialoginterface, int i){
    			  Uri uri = Uri.parse(getString(R.string.home_uri));
    			  Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    			  startActivity(intent);
    		  }
    	  })	
    	.show();		
    }
         
          
       //Listen for button clicks
    private void setListensers(){
    	button_calc.setOnClickListener(calcNUM);
    }
   
    private Button.OnClickListener calcNUM = new Button.OnClickListener() {
    	public void onClick(View v) {
    		DecimalFormat nf = new DecimalFormat("0");
    try{ 
    		//?–å??¸å?å­—ä¸²
    	    String getNum = field_num.getText().toString();
    		int numLength = getNum.length();
    		
    		if(numLength<4){
    			openOptionsDialog();
    			
       		}
    		else{
    			numLength -= 4;
    			field_num.setText("");
    		}
    	
    		String cutNum = getNum.substring(numLength);
    		OpNumGB pNum = new OpNumGB();  //è¨ˆç??©ä»¶
    	     	   
    		
			//Present result
    		view_result.setText(getText(R.string.num_result)+getNum+getText(R.string.num_gb)+nf.format(pNum.getVolumn(cutNum)));
    		
    		//Give number good & bad advance
    		String restostr = String.valueOf(pNum.getVolumn(cutNum));
     	    BigDecimal opResult = new BigDecimal(restostr);
     	    opResult = opResult.setScale(4,BigDecimal.ROUND_HALF_UP);
     	    
    		switch(opResult.intValue())	 {
    		case 1:view_suggest.setText(R.string.advance_aa);break;
    		case 2:view_suggest.setText(R.string.advance_ab);break;
    		case 3:view_suggest.setText(R.string.advance_ac);break;
    		case 4:view_suggest.setText(R.string.advance_ad);break;
    		case 5:view_suggest.setText(R.string.advance_ae);break;
    		case 6:view_suggest.setText(R.string.advance_af);break;
    		case 7:view_suggest.setText(R.string.advance_ag);break;
    		case 8:view_suggest.setText(R.string.advance_ah);break;
    		case 9:view_suggest.setText(R.string.advance_ai);break;
    		case 10:view_suggest.setText(R.string.advance_aj);break;
    		case 11:view_suggest.setText(R.string.advance_ak);break;
    		case 12:view_suggest.setText(R.string.advance_al);break;
    		case 13:view_suggest.setText(R.string.advance_am);break;
    		case 14:view_suggest.setText(R.string.advance_an);break;
    		case 15:view_suggest.setText(R.string.advance_ao);break;
    		case 16:view_suggest.setText(R.string.advance_ap);break;
    		case 17:view_suggest.setText(R.string.advance_aq);break;
    		case 18:view_suggest.setText(R.string.advance_ar);break;
    		case 19:view_suggest.setText(R.string.advance_as);break;
    		case 20:view_suggest.setText(R.string.advance_at);break;
    		case 21:view_suggest.setText(R.string.advance_au);break;
    		case 22:view_suggest.setText(R.string.advance_av);break;
    		case 23:view_suggest.setText(R.string.advance_aw);break;
    		case 24:view_suggest.setText(R.string.advance_ax);break;
    		case 25:view_suggest.setText(R.string.advance_ay);break;
    		case 26:view_suggest.setText(R.string.advance_az);break;
    		case 27:view_suggest.setText(R.string.advance_ba);break;
    		case 28:view_suggest.setText(R.string.advance_bb);break;
    		case 29:view_suggest.setText(R.string.advance_bc);break;
    		case 30:view_suggest.setText(R.string.advance_bd);break;
    		case 31:view_suggest.setText(R.string.advance_be);break;
    		case 32:view_suggest.setText(R.string.advance_bf);break;
    		case 33:view_suggest.setText(R.string.advance_bg);break;
    		case 34:view_suggest.setText(R.string.advance_bh);break;
    		case 35:view_suggest.setText(R.string.advance_bi);break;
    		case 36:view_suggest.setText(R.string.advance_bj);break;
    		case 37:view_suggest.setText(R.string.advance_bk);break;
    		case 38:view_suggest.setText(R.string.advance_bl);break;
    		case 39:view_suggest.setText(R.string.advance_bm);break;
    		case 40:view_suggest.setText(R.string.advance_bn);break;
    		case 41:view_suggest.setText(R.string.advance_bo);break;
    		case 42:view_suggest.setText(R.string.advance_bp);break;
    		case 43:view_suggest.setText(R.string.advance_bq);break;
    		case 44:view_suggest.setText(R.string.advance_br);break;
    		case 45:view_suggest.setText(R.string.advance_bs);break;
    		case 46:view_suggest.setText(R.string.advance_bt);break;
    		case 47:view_suggest.setText(R.string.advance_bu);break;
    		case 48:view_suggest.setText(R.string.advance_bv);break;
    		case 49:view_suggest.setText(R.string.advance_bw);break;
    		case 50:view_suggest.setText(R.string.advance_bx);break;
    		case 51:view_suggest.setText(R.string.advance_by);break;
    		case 52:view_suggest.setText(R.string.advance_bz);break;
    		case 53:view_suggest.setText(R.string.advance_ca);break;
    		case 54:view_suggest.setText(R.string.advance_cb);break;
    		case 55:view_suggest.setText(R.string.advance_cc);break;
    		case 56:view_suggest.setText(R.string.advance_cd);break;
            case 57:view_suggest.setText(R.string.advance_ce);break;
    	 	case 58:view_suggest.setText(R.string.advance_cf);break;
    		case 59:view_suggest.setText(R.string.advance_cg);break;
    		case 60:view_suggest.setText(R.string.advance_ch);break;
    		case 61:view_suggest.setText(R.string.advance_ci);break;
    		case 62:view_suggest.setText(R.string.advance_cj);break;
    		case 63:view_suggest.setText(R.string.advance_ck);break;
    		case 64:view_suggest.setText(R.string.advance_cl);break;
    		case 65:view_suggest.setText(R.string.advance_cm);break;
    		case 66:view_suggest.setText(R.string.advance_cn);break;
    		case 67:view_suggest.setText(R.string.advance_co);break;
    		case 68:view_suggest.setText(R.string.advance_cp);break;
    		case 69:view_suggest.setText(R.string.advance_cq);break;
    		case 70:view_suggest.setText(R.string.advance_cr);break;
    		case 71:view_suggest.setText(R.string.advance_cs);break;
    		case 72:view_suggest.setText(R.string.advance_ct);break;
    		case 73:view_suggest.setText(R.string.advance_cu);break;
    		case 74:view_suggest.setText(R.string.advance_cv);break;
    		case 75:view_suggest.setText(R.string.advance_cw);break;
    		case 76:view_suggest.setText(R.string.advance_cx);break;
    		case 77:view_suggest.setText(R.string.advance_cy);break;
    		case 78:view_suggest.setText(R.string.advance_cz);break;
    		case 79:view_suggest.setText(R.string.advance_da);break;
    		case 80:view_suggest.setText(R.string.advance_db);break;
    		case 81:view_suggest.setText(R.string.advance_dc);break;
    	    }   
    		}catch(Exception obj){}
    		
    	}
    };

    protected static final int MENU_ABOUT = Menu.FIRST;
    protected static final int NENU_QUIT = Menu.FIRST+1;
    
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, MENU_ABOUT, 0, "?œæ–¼...").setIcon(android.R.drawable.ic_menu_help);
		menu.add(0, NENU_QUIT, 0, "?¢é?").setIcon(android.R.drawable.ic_menu_close_clear_cancel);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case MENU_ABOUT:
		     openMenuDialog();
		     break;
		case NENU_QUIT:
			 finish();
			 break;
		}
		return super.onOptionsItemSelected(item);
	}
}
 