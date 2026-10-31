package com.lunaracres.businesspro;
import android.app.*;import android.os.*;import android.graphics.Color;import android.view.*;import android.widget.*;import java.util.*;
public class MainActivity extends Activity {
 LinearLayout root,items; TextView totalView; double total=0; int count=0; ArrayList<String> cart=new ArrayList<>();
 void add(String name,double price){total+=price;count++;cart.add(name);totalView.setText(String.format(java.util.Locale.US,"Items: %d     Total: $%.2f",count,total));}
 TextView label(String text,int size){TextView t=new TextView(this);t.setText(text);t.setTextSize(size);t.setTextColor(Color.rgb(24,39,58));t.setPadding(18,18,18,18);return t;}
 void button(String name,double price){Button b=new Button(this);b.setText(String.format(java.util.Locale.US,"%s  $%.2f",name,price));b.setAllCaps(false);b.setTextSize(19);b.setOnClickListener(v->add(name,price));items.addView(b);}
 public void onCreate(Bundle b){super.onCreate(b);root=new LinearLayout(this);root.setOrientation(1);root.setPadding(18,22,18,18);root.setBackgroundColor(Color.rgb(243,247,251));setContentView(root);
 root.addView(label("LUNAR BUSINESS PRO",25));root.addView(label("BAKER'S DAWGS  •  TEST REGISTER",17));
 totalView=label("Items: 0     Total: $0.00",23);root.addView(totalView);
 ScrollView scroll=new ScrollView(this);items=new LinearLayout(this);items.setOrientation(1);scroll.addView(items);root.addView(scroll,new LinearLayout.LayoutParams(-1,0,1));
 button("Hot Dog",3.28);button("Combo",7.00);button("German Chocolate Cake",5.00);button("Tres Leches Cake",5.00);
 Button checkout=new Button(this);checkout.setText("COMPLETE DEMO CASH SALE");checkout.setTextSize(17);checkout.setOnClickListener(v->{if(count==0)return;new AlertDialog.Builder(this).setTitle("Test sale only").setMessage(String.format(java.util.Locale.US,"Recorded demo cash sale: $%.2f. No real payment was collected.",total)).setPositiveButton("OK",(d,w)->{}).show();getPreferences(0).edit().putInt("sales",getPreferences(0).getInt("sales",0)+1).apply();total=0;count=0;cart.clear();totalView.setText("Items: 0     Total: $0.00");});root.addView(checkout);
 Button history=new Button(this);history.setText("VIEW DEMO SALE COUNT");history.setOnClickListener(v->new AlertDialog.Builder(this).setMessage("Demo sales: "+getPreferences(0).getInt("sales",0)).setPositiveButton("OK",null).show());root.addView(history);
 root.addView(label("OFFLINE TEST • NO LIVE CARD PROCESSING",12));
 }
}